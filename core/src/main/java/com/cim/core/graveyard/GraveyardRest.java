package com.cim.core.graveyard;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/graveyard")
public class GraveyardRest
{
	private static final Logger	log	= LoggerFactory.getLogger(GraveyardRest.class);

	private GraveyardService	graveyardService;

	@Autowired
	public GraveyardRest(@NotNull GraveyardService graveyardService)
	{
		this.graveyardService = graveyardService;
	}

	@GetMapping
	public ResponseEntity<GraveyardListUi> list()
	{
		log.debug("Fetching graveyards");

		List<Graveyard> graveyards = graveyardService.list();
		GraveyardListUi uiGraveyards = GraveyardAssembler.toUi(graveyards);

		log.debug("Response {}", uiGraveyards);
		return ResponseEntity.ok(uiGraveyards);
	}
}
