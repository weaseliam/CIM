package com.cim.core.dictionary;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AcceptLanguageHandlerMethodArgumentResolver.AcceptLanguage;
import com.cim.core.app.AppConstants;

@RestController
@RequestMapping(AppConstants.API_PATH + "/dictionary")
public class DictionaryRest
{
	private static final Logger log = LoggerFactory.getLogger(DictionaryRest.class);
	
	private DictionaryService dictionaryService;
	
	@Autowired
	public DictionaryRest(@NotNull DictionaryService dictionaryService)
	{
		this.dictionaryService = dictionaryService;
	}
	
	@GetMapping
	public ResponseEntity<DictionaryUi> getDictionaryForAcceptLang(
			@AcceptLanguage String acceptLanguage)
	{
		return getDictionary(acceptLanguage);
	}

	@GetMapping(value = "/{lang}")
	public ResponseEntity<DictionaryUi> getDictionaryForLang(
			@PathVariable("lang") String lang)
	{
		return getDictionary(lang);
	}
	
	@GetMapping(path = "/list")
	public ResponseEntity<List<String>> getSupportedLanguages()
	{
		log.debug("Fetching supported languages");

		List<String> supportedLanguages = dictionaryService.getSupportedLanguages();

		log.debug("Response {}", supportedLanguages);
		return ResponseEntity.ok(supportedLanguages);
	}

	private ResponseEntity<DictionaryUi> getDictionary(String lang)
	{
		log.debug("Fetching dictionary for language {}", lang);
		
		Map<String, String> messages = dictionaryService.getDictionary(lang);
		if (messages == null)
		{
			messages = new HashMap<>();
		}
		
		DictionaryUi dictionary = DictionaryAssembler.toResource(lang, messages);
		
		log.debug("Response {}", dictionary);
		return ResponseEntity.ok(dictionary);
	}
}
