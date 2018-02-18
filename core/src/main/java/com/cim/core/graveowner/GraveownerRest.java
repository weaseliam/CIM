package com.cim.core.graveowner;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/graveowner")
public class GraveownerRest
{
	private static final Logger	log	= LoggerFactory.getLogger(GraveownerRest.class);

	private GraveownerService	graveownerService;

	public GraveownerRest(@NotNull GraveownerService graveownerService)
	{
		this.graveownerService = graveownerService;
	}
}
