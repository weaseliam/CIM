package com.cim.core.migration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.cim.core.contract.Contract;
import com.cim.core.contract.ContractService;
import com.cim.core.exempt.Exempt;
import com.cim.core.exempt.ExemptService;
import com.cim.core.grave.Grave;
import com.cim.core.grave.GraveService;
import com.cim.core.graveowner.Graveowner;
import com.cim.core.graveowner.GraveownerService;
import com.cim.core.graveyard.Graveyard;
import com.cim.core.graveyard.GraveyardService;
import com.cim.core.util.DateUtil;

@Service
@Repository
public class MigrationServiceImpl implements MigrationService
{
	private static final Logger	log	= LoggerFactory.getLogger(MigrationServiceImpl.class);

	private GraveownerService	graveownerService;
	private GraveyardService	graveyardService;
	private ExemptService		exemptService;
	private GraveService		graveService;
	private ContractService		contractService;

	@Autowired
	public MigrationServiceImpl(@NotNull ExemptService exemptService, @NotNull GraveyardService graveyardService,
			@NotNull GraveownerService graveownerService, @NotNull GraveService graveService,
			@NotNull ContractService contractService)
	{
		this.graveownerService = graveownerService;
		this.graveyardService = graveyardService;
		this.exemptService = exemptService;
		this.graveService = graveService;
		this.contractService = contractService;
	}

	@Override
	public MigrationResponse migrate(MigrationRequest request)
	{
		log.info("Start migration process for {}", request);

		MigrationResponse response = new MigrationResponse();
		JdbcTemplate jdbcTemplate = createJdbcTemplate(request);
		long duration = 0;
		boolean isGravesMigrated = false;
		boolean isContractsMigrated = false;

		for (Map.Entry<String, String> entry : request.getTablesMapping().entrySet())
		{
			String targetTable = entry.getKey();
			String sourceTable = entry.getValue();

			log.info("Migrate {} to {} start", sourceTable, targetTable);
			long startTime = System.currentTimeMillis();

			if (Graveowner.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraveowner(jdbcTemplate, sourceTable, targetTable, response);
			}
			else if (Graveyard.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraveyard(jdbcTemplate, sourceTable, targetTable, response);
			}
			else if (Exempt.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateExempts(jdbcTemplate, sourceTable, targetTable, response);
			}
			else if (Grave.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraves(jdbcTemplate, sourceTable, targetTable, response);
				isGravesMigrated = true;
			}
			else if (Contract.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateContracts(jdbcTemplate, sourceTable, targetTable, response);
				isContractsMigrated = true;
			}
			else
			{
				log.warn("Migrate {} to {} SKIPPED - {} not supported", sourceTable, targetTable, targetTable);
			}

			long localDuration = System.currentTimeMillis() - startTime;
			log.info("Migrate {} to {} took {} milliseconds", sourceTable, targetTable, localDuration);
			duration += localDuration;
		}
		
		if (isGravesMigrated && isContractsMigrated)
		{
			long startTime = System.currentTimeMillis();
			
			mapContractsToGraves();
			
			long localDuration = System.currentTimeMillis() - startTime;
			log.info("Map contracts to graves took {} milliseconds", localDuration);
			duration += localDuration;
		}
		else
		{
			log.warn("Did not map contracts to graves");
		}

		response.setDurationSeconds(duration / 1000);
		log.info("Migration process ended with {}", response);
		return response;
	}

	private JdbcTemplate createJdbcTemplate(MigrationRequest request)
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(request.getDriverClassName());
		dataSource.setUrl(request.getDbUrl());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}
	
	private void migrateGraveowner(JdbcTemplate jdbcTemplate, String source, String target, MigrationResponse response)
	{
		log.debug("Migrating {} to {}", source, target);
		
		int batchSize = 200;
		long cursor = 0;
		for (;;)
		{
			log.debug("{} cursor at {}", source, cursor);
			List<Graveowner> graveowners = jdbcTemplate.query("SELECT * FROM " + source + " LIMIT " + cursor + ", " + batchSize,  new RowMapper<Graveowner>()
			{
				@Override
				public Graveowner mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Graveowner graveowner = new Graveowner();
					graveowner.setOldId(rs.getLong("MARCA"));
					graveowner.setCnp(rs.getString("CNP"));
					graveowner.setNume(rs.getString("NUME"));
					graveowner.setPrenume(rs.getString("PRENUME") != null ? rs.getString("PRENUME") : "");
					graveowner.setCodLoc(rs.getInt("CODLOC"));
					graveowner.setLocalitate(rs.getString("LOCALITATE"));
					graveowner.setJudet(rs.getString("JUDET"));
					graveowner.setTara(rs.getString("TARA"));
					graveowner.setStr(rs.getString("STR"));
					graveowner.setNr(rs.getString("NR"));
					graveowner.setBl(rs.getString("BL"));
					graveowner.setSc(rs.getString("SC"));
					graveowner.setEt(rs.getString("ET"));
					graveowner.setAp(rs.getString("AP"));
					graveowner.setCodPost(rs.getString("CODPOST"));
					graveowner.setTel(rs.getString("TEL"));
					graveowner.setFax(rs.getString("FAX"));
					graveowner.setMail(rs.getString("MAIL"));
					graveowner.setNrContr(rs.getString("NR_CONTR"));
					graveowner.setDataContr(DateUtil.toLocalDateTime(rs.getDate("DATA_CONTR")));
					graveowner.setContract(rs.getString("CONTRACT"));
					graveowner.setAct(rs.getString("ACT"));
					graveowner.setSeria(rs.getString("SERIA"));
					graveowner.setNrAct(rs.getString("NR_ACT"));
					graveowner.setEmitator(rs.getString("EMITATOR"));
					graveowner.setDataAct(DateUtil.toLocalDateTime(rs.getDate("DATA_ACT")));
					graveowner.setDubiu(rs.getString("DUBIU"));
					graveowner.setDataDubiu(DateUtil.toLocalDateTime(rs.getDate("DATA_DUBIU")));
					graveowner.setAvans(rs.getString("AVANS"));
					graveowner.setAnDebut(rs.getInt("AN_DEBUT"));
					graveowner.setAnFinal(rs.getInt("AN_FINAL"));
					graveowner.setModif(rs.getString("MODIF"));
					graveowner.setAvizat(rs.getString("AVIZAT"));
					graveowner.setDataAviz(DateUtil.toLocalDateTime(rs.getDate("DATA_AVIZ")));
					
					String address = buildAddress(graveowner);
					graveowner.setAdresa(address);

					return graveowner;
				}

				private String buildAddress(Graveowner graveowner)
				{
					StringBuilder sb = new StringBuilder();
					String separator = ",";
					
					sb.append(safeGet(graveowner.getStr()))
						.append(separator).append(safeGet(graveowner.getNr()))
						.append(separator).append(safeGet(graveowner.getBl()))
						.append(separator).append(safeGet(graveowner.getSc()))
						.append(separator).append(safeGet(graveowner.getEt()))
						.append(separator).append(safeGet(graveowner.getAp()));
					
					return sb.toString();
				}

				private String safeGet(String str)
				{
					return str == null || "null".equals(str.trim().toLowerCase()) 
							? "" 
							: str.trim();
				}
			});

			if (graveowners.isEmpty())
			{
				break;
			}
			
			cursor += graveownerService.save(graveowners).size();
		}

		response.addTable(source, target, cursor);
	}

	private void migrateGraveyard(JdbcTemplate jdbcTemplate, String source, String target, MigrationResponse response)
	{
		log.debug("Migrating {} to {}", source, target);
		
		List<Graveyard> graveyards = jdbcTemplate.query("SELECT * FROM " + source, new RowMapper<Graveyard>()
		{
			@Override
			public Graveyard mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Graveyard graveyard = new Graveyard();
				graveyard.setNume(rs.getString("DENCIM"));
				graveyard.setTara("Romania");
				graveyard.setLocalitate("");
				graveyard.setJudet("");
				graveyard.setStr("");
				graveyard.setNr("");

				return graveyard;
			}
		});

		response.addTable(source, target, graveyardService.save(graveyards).size());
	}

	private void migrateExempts(JdbcTemplate jdbcTemplate, String source, String target, MigrationResponse response)
	{
		log.debug("Migrating {} to {}", source, target);
		
		List<Exempt> exempts = jdbcTemplate.query("SELECT * FROM " + source, new RowMapper<Exempt>()
		{
			@Override
			public Exempt mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Exempt exempt = new Exempt();
				exempt.setCod(rs.getInt("COD"));
				exempt.setNume(rs.getString("DENUMIRE"));

				return exempt;
			}
		});

		response.addTable(source, target, exemptService.save(exempts).size());
	}

	private void migrateGraves(JdbcTemplate jdbcTemplate, String source, String target, MigrationResponse response)
	{
		log.debug("Migrating {} to {}", source, target);
		
		int batchSize = 200;
		long cursor = 0;
		for (;;)
		{
			Set<Grave> gravesToRemove = new HashSet<>();
			
			log.debug("{} cursor at {}", source, cursor);
			List<Grave> graves = jdbcTemplate.query("SELECT * FROM " + source + " LIMIT " + cursor + ", " + batchSize,  new RowMapper<Grave>()
			{
				@Override
				public Grave mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Grave grave = new Grave();
					grave.setOldId(rs.getLong("MARCA"));
					grave.setCodZona(rs.getInt("CODZONA"));
					grave.setSector(rs.getString("SECTOR"));
					grave.setRind(rs.getString("RIND"));
					grave.setPozitie(rs.getString("POZITIE"));
					grave.setNrLocuri(rs.getInt("NRLOCURI"));
					
					// update foreign keys
					// graveyardId
					String cimitir = rs.getString("CIMITIR");
					Graveyard graveyard = graveyardService.findFirstByNume(cimitir.trim());
					if (graveyard != null)
					{
						grave.setGraveyardId(graveyard.getId());
					}
					else
					{
						log.warn("Failed to associate graveyard to {}", grave);
					}
					
					// handle existing graves
					List<Grave> existingGraves = graveService.findAllByOldId(grave.getOldId());
					if (existingGraves != null && !existingGraves.isEmpty())
					{
						Grave graveToRemove = existingGraves.stream()
								.filter(eg -> grave.equals(eg))
								.findFirst()
								.orElse(null);
						if (graveToRemove != null)
						{
							gravesToRemove.add(graveToRemove);
						}
					}
					
					return grave;
				}
			});

			if (graves.isEmpty())
			{
				break;
			}
			
			cursor += graves.size();
			
			graves.removeAll(gravesToRemove);
			Set<Grave> uniqueGraves = graves.stream()
					.collect(Collectors.toSet());
			
			graveService.save(new ArrayList<>(uniqueGraves));
		}

		response.addTable(source, target, cursor);
	}
	
	private void migrateContracts(JdbcTemplate jdbcTemplate, String source, String target, MigrationResponse response)
	{
		log.debug("Migrating {} to {}", source, target);
		
		int batchSize = 200;
		long cursor = 0;
		for (;;)
		{
			log.debug("{} cursor at {}", source, cursor);
			List<Contract> contracts = jdbcTemplate.query("SELECT * FROM " + source + " LIMIT " + cursor + ", " + batchSize,  new RowMapper<Contract>()
			{
				@Override
				public Contract mapRow(ResultSet rs, int rowNum) throws SQLException
				{
					Contract contract = new Contract();
					contract.setOldId(rs.getLong("MARCA"));
					contract.setAni(rs.getInt("ANI"));
					contract.setDataIncep(DateUtil.toLocalDateTime(rs.getDate("DATAINCEP")));
					contract.setDataExp(DateUtil.toLocalDateTime(rs.getDate("DATAEXP")));
					contract.setNrCh(rs.getString("NR_CH"));
					contract.setDataCh(DateUtil.toLocalDateTime(rs.getDate("DATA_CH")));
					contract.setSuma(rs.getBigDecimal("SUMA"));
					contract.setContract(rs.getString("CONTRACT"));
					contract.setNrContr(rs.getString("NR_CONTR"));
					contract.setDataContr(DateUtil.toLocalDateTime(rs.getDate("DATA_CONTR")));
					contract.setInd(rs.getInt("IND"));
					contract.setStare(rs.getString("STARE"));
					contract.setDataStare(DateUtil.toLocalDateTime(rs.getDate("DATA_STARE")));
					contract.setTranse(rs.getInt("TRANSE"));
					contract.setCodCs(rs.getInt("COD_CS"));
					contract.setMatricola(rs.getInt("MATRICOLA"));
					contract.setModif(rs.getString("MODIF"));
					
					// update foreign keys
					// exemptId
					int scutit = rs.getInt("SCUTIT");
					Exempt exempt = exemptService.findFirstByCod(scutit);
					if (exempt != null)
					{
						contract.setExemptId(exempt.getId());
					}
					
					// graveownerId
					Graveowner graveowner = graveownerService.findFirstByOldId(contract.getOldId());
					if (graveowner != null)
					{
						contract.setGraveownerId(graveowner.getId());
					}
					else
					{
						log.warn("Failed to associate graveowner to {}", contract);
					}
					
					// graveId
					List<Grave> existingGraves = graveService.findAllByOldId(contract.getOldId());
					if (existingGraves != null && !existingGraves.isEmpty())
					{
						int codZona = rs.getInt("CODZONA");
						String sector = rs.getString("SECTOR");
						String rind = rs.getString("RIND");
						String pozitie = rs.getString("POZITIE");
						int nrLocuri = rs.getInt("NRLOCURI");
						String cimitir = rs.getString("CIMITIR");
						Graveyard graveyard = graveyardService.findFirstByNume(cimitir.trim());
						
						Grave graveToSearch = new Grave();
						graveToSearch.setCodZona(codZona);
						graveToSearch.setSector(sector);
						graveToSearch.setRind(rind);
						graveToSearch.setPozitie(pozitie);
						graveToSearch.setNrLocuri(nrLocuri);
						graveToSearch.setGraveyardId(graveyard.getId());
						graveToSearch.setOldId(contract.getOldId());
						
						Grave grave = existingGraves.stream()
								.filter(g -> graveToSearch.equals(g))
								.findFirst()
								.orElse(null);
						if (grave != null)
						{
							contract.setGraveId(grave.getId());
						}
						else
						{
							log.warn("Failed to associate grave to {}", contract);
						}
					}
					else
					{
						log.warn("Failed to associate grave to {}", contract);
					}
					
					return contract;
				}
			});

			if (contracts.isEmpty())
			{
				break;
			}
			
			cursor += contractService.save(contracts).size();
		}

		response.addTable(source, target, cursor);
	}
	
	private void mapContractsToGraves()
	{
		log.debug("Mapping graves to contracts");
		
		int batchSize = 200;
		int page = 1;
		
		List<Grave> graves;
		while (!(graves = graveService.list(page, batchSize, null, null).getResults()).isEmpty())
		{
			log.debug("graves cursor at {}", (page-1) * batchSize);
			
			for (Grave grave : graves)
			{
				List<Contract> contracts = contractService.findAllByOldId(grave.getOldId()).stream()
						.filter(contract -> contract.getGraveId().equals(grave.getId()))
						.collect(Collectors.toList());
				
				if (contracts.isEmpty())
				{
					log.warn("Failed to associate contract to {}", grave);
					continue;
				}
				
				Collections.sort(contracts, new Comparator<Contract>()
				{
					@Override
					public int compare(Contract c1, Contract c2)
					{
						return c2.getDataExp().compareTo(c1.getDataExp());
					}
				});
				
				grave.setContractId(contracts.get(0).getId());
			}
			
			graveService.save(graves);
			page++;
		}
	}
}
