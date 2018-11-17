package com.cim.core.grave;

import java.util.List;

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
	
	@GetMapping
	public ResponseEntity<ApiGraveList> list(
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "100") int size,
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(required = false) List<Long> contractIds)
	{
		log.debug("Fetching graves for page={}, size={}, sort={}, contractIds={}", 
				page, size, sort, contractIds);
		
		GraveFilter filter = GraveAssembler.fromResource(contractIds);
		log.debug("Using filter {}", filter);			
		
		Page<Grave> graves = graveService.list(page, size, sort, filter);
		ApiGraveList apiGraves = GraveAssembler.toResource(graves, sort);
		
		log.debug("Response {}", apiGraves);
		return ResponseEntity.ok(apiGraves);
	}
}
