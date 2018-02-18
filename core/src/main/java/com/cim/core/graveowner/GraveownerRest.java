package com.cim.core.graveowner;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/graveowner")
public class GraveownerRest
{
	private static final Logger	log	= LoggerFactory.getLogger(GraveownerRest.class);

	private GraveownerService	graveownerService;

	@Autowired
	public GraveownerRest(@NotNull GraveownerService graveownerService)
	{
		this.graveownerService = graveownerService;
	}

	@GetMapping(path = "/list")
	public ResponseEntity<GraveownerListUi> list(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int size,
			@RequestParam(defaultValue = "id") String sort)
	{
		log.debug("Fetching graveowners list for page {}, size {}, sort {}", page, size, sort);
		
		Page<Graveowner> graveownersPage = graveownerService.list(page, size, sort);
		GraveownerListUi graveowners = GraveownerAssembler.toResource(graveownersPage, sort);
		
		log.debug("Response {}", graveowners);
		return ResponseEntity.ok(graveowners);
	}
}
