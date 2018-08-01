package com.cim.core.exempt;

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
@RequestMapping(AppConstants.API_PATH + "/exempt")
public class ExemptRest
{
	private static final Logger	log	= LoggerFactory.getLogger(ExemptRest.class);

	private ExemptService	exemptService;

	@Autowired
	public ExemptRest(@NotNull ExemptService exemptService)
	{
		this.exemptService = exemptService;
	}

	@GetMapping
	public ResponseEntity<ExemptListUi> list()
	{
		log.debug("Fetching exempts");

		List<Exempt> exempts = exemptService.list();
		ExemptListUi uiExempts = ExemptAssembler.toResource(exempts);

		log.debug("Response {}", uiExempts);
		return ResponseEntity.ok(uiExempts);
	}
}
