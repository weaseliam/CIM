package com.cim.core.grave;

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
@RequestMapping(AppConstants.API_PATH + "/grave")
public class GraveRest
{
	private static final Logger	log	= LoggerFactory.getLogger(GraveRest.class);

	private GraveService		graveService;

	@Autowired
	public GraveRest(@NotNull GraveService graveService)
	{
		this.graveService = graveService;
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<GraveListUi> list(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int size,
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(required = false) Long graveownerId)
	{
		log.debug("Fetching graves for page={}, size={}, sort={}, graveownerId={}", 
				page, size, sort, graveownerId);
		
		GraveFilter filter = null;
		if (graveownerId != null)
		{
			filter = new GraveFilter(graveownerId);
			log.debug("Using filter {}", filter);			
		}
		
		Page<Grave> graves = graveService.list(page, size, sort, filter);
		GraveListUi uiGraves = GraveAssembler.toResource(graves, sort);
		
		log.debug("Response {}", uiGraves);
		return ResponseEntity.ok(uiGraves);
	}
}
