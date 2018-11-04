package com.cim.core.migration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

	@Autowired
	public MigrationServiceImpl(@NotNull ExemptService exemptService, @NotNull GraveyardService graveyardService,
			@NotNull GraveownerService graveownerService, @NotNull GraveService graveService)
	{
		this.graveownerService = graveownerService;
		this.graveyardService = graveyardService;
		this.exemptService = exemptService;
		this.graveService = graveService;
	}

	@Override
	public MigrationResponse migrate(MigrationRequest request)
	{
		log.info("Start migration process for {}", request);

		MigrationResponse response = new MigrationResponse();
		JdbcTemplate jdbcTemplate = createJdbcTemplate(request);
		long duration = 0;

		for (Map.Entry<String, String> entry : request.getTablesMapping().entrySet())
		{
			String targetTable = entry.getKey();
			String sourceTable = entry.getValue();

			log.info("Migrate {} to {} start", sourceTable, targetTable);
			long startTime = System.currentTimeMillis();

			if (Graveowner.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraveowner(jdbcTemplate, sourceTable, response);
			}
			else if (Graveyard.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraveyard(jdbcTemplate, sourceTable, response);
			}
			else if (Exempt.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateExempts(jdbcTemplate, sourceTable, response);
			}
			else if (Grave.class.getSimpleName().equalsIgnoreCase(targetTable))
			{
				migrateGraves(jdbcTemplate, sourceTable, response);
			}
			else
			{
				log.warn("Migrate {} to {} SKIPPED - {} not supported", sourceTable, targetTable, targetTable);
			}

			long localDuration = System.currentTimeMillis() - startTime;
			log.info("Migrate {} to {} took {}", sourceTable, targetTable, localDuration);
			duration += localDuration;
		}

		response.setDurationSeconds(duration / 1000);
		log.info("Migration process ended with {}", response);
		return response;
	}

	private void migrateGraveowner(JdbcTemplate jdbcTemplate, String tableName, MigrationResponse response)
	{
		log.debug("Migrating {}", tableName);
		
		final long batchSize = 200;
		long cursor = 0;
		for (;;)
		{
			// TODO use prepared statement ?
			List<Graveowner> graveowners = jdbcTemplate.query("SELECT * FROM " + tableName + " LIMIT " + cursor + ", " + batchSize,  new RowMapper<Graveowner>()
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

		response.addTable(tableName, cursor);
	}

	private void migrateGraveyard(JdbcTemplate jdbcTemplate, String tableName, MigrationResponse response)
	{
		log.debug("Migrating {}", tableName);
		
		// TODO use prepared statement ?
		List<Graveyard> graveyards = jdbcTemplate.query("SELECT * FROM " + tableName, new RowMapper<Graveyard>()
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

		response.addTable(tableName, graveyardService.save(graveyards).size());
	}

	private void migrateExempts(JdbcTemplate jdbcTemplate, String tableName, MigrationResponse response)
	{
		log.debug("Migrating {}", tableName);
		
		// TODO use prepared statement ?
		List<Exempt> exempts = jdbcTemplate.query("SELECT * FROM " + tableName, new RowMapper<Exempt>()
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

		response.addTable(tableName, exemptService.save(exempts).size());
	}

	private void migrateGraves(JdbcTemplate jdbcTemplate, String tableName, MigrationResponse response)
	{
		final long batchSize = 200;
		long cursor = 0;
		for (;;)
		{
			// TODO use prepared statement ?
			List<Grave> graves = jdbcTemplate.query("SELECT * FROM " + tableName + " LIMIT " + cursor + ", " + batchSize,  new RowMapper<Grave>()
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
					grave.setAni(rs.getInt("ANI"));
					grave.setDataIncep(DateUtil.toLocalDateTime(rs.getDate("DATAINCEP")));
					grave.setDataExp(DateUtil.toLocalDateTime(rs.getDate("DATAEXP")));
					grave.setNrCh(rs.getString("NR_CH"));
					grave.setDataCh(DateUtil.toLocalDateTime(rs.getDate("DATA_CH")));
					grave.setSuma(rs.getBigDecimal("SUMA"));
					grave.setContract(rs.getString("CONTRACT"));
					grave.setNrContr(rs.getString("NR_CONTR"));
					grave.setDataContr(DateUtil.toLocalDateTime(rs.getDate("DATA_CONTR")));
					grave.setInd(rs.getInt("IND"));
					grave.setStare(rs.getString("STARE"));
					grave.setDataStare(DateUtil.toLocalDateTime(rs.getDate("DATA_STARE")));
					grave.setTranse(rs.getInt("TRANSE"));
					grave.setCodCs(rs.getInt("COD_CS"));
					grave.setMatricola(rs.getInt("MATRICOLA"));
					grave.setModif(rs.getString("MODIF"));
					
					// update foreign keys
					int scutit = rs.getInt("SCUTIT");
					Exempt exempt = scutit > 0 ? exemptService.findFirstByCod(scutit) : null;
					if (exempt != null)
					{
						grave.setExemptId(exempt.getId());
					}
					
					String cimitir = rs.getString("CIMITIR");
					Graveyard graveyard = cimitir.length() > 0 ? graveyardService.findFirstByNume(cimitir.trim()) : null;
					if (graveyard != null)
					{
						grave.setGraveyardId(graveyard.getId());
					}
					else
					{
						log.warn("Failed to associate graveyard for {}", grave);
					}
					
					long marca = rs.getLong("MARCA");
					Graveowner graveowner = marca > 0 ? graveownerService.findFirstByOldId(marca) : null;
					if (graveowner != null)
					{
						grave.setGraveownerId(graveowner.getId());
					}
					else
					{
						log.warn("Failed to associate graveowner for {}", grave);
					}
					
					return grave;
				}
			});

			if (graves.isEmpty())
			{
				break;
			}
			
			cursor += graveService.save(graves).size();
		}

		response.addTable(tableName, cursor);
	}
	
	private JdbcTemplate createJdbcTemplate(MigrationRequest request)
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(request.getDriverClassName());
		dataSource.setUrl(request.getDbUrl());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		return jdbcTemplate;
	}
}
