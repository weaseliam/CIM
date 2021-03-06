package com.cim.core.migration;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/migration")
public class MigrationRest
{
	private static final Logger	log	= LoggerFactory.getLogger(MigrationRest.class);

	private MigrationService	migrationService;

	@Autowired
	public MigrationRest(@NotNull MigrationService migrationService)
	{
		this.migrationService = migrationService;
	}

	@PostMapping
	public ResponseEntity<MigrationResponse> migrate(
			@RequestBody MigrationRequest request)
	{
		log.debug("Migrating db for {}", request);

		MigrationResponse response = migrationService.migrate(request);
		
		log.debug("Response {}", response);
		return ResponseEntity.ok(response);
	}
}
