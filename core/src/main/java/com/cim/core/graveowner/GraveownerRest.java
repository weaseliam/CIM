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

	@GetMapping
	public ResponseEntity<ApiGraveownerList> list(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int size,
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(required = false) Long id,
			@RequestParam(required = false) String cnp,
			@RequestParam(required = false) String nume,
			@RequestParam(required = false) String prenume,
			@RequestParam(required = false) String localitate,
			@RequestParam(required = false) String judet,
			@RequestParam(required = false) String adresa)
	{
		log.debug("Fetching graveowners for page={}, size={}, sort={}", page, size, sort);
		
		GraveownerFilter filter = GraveownerAssembler.fromResource(id, cnp, nume, prenume, localitate, judet, adresa);
		log.debug("Using filter {}", filter);			
		
		Page<Graveowner> graveowners = graveownerService.list(page, size, sort, filter);
		ApiGraveownerList apiGraveowners = GraveownerAssembler.toResource(graveowners, sort, filter);
		
		log.debug("Response {}", apiGraveowners);
		return ResponseEntity.ok(apiGraveowners);
	}
}
