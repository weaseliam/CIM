package com.cim.core.dictionary;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cim.core.app.AppController;

@RestController
@RequestMapping(AppController.API_PATH + "/dictionary")
public class DictionaryRest
{
	private static final Logger log = LoggerFactory.getLogger(DictionaryRest.class);
	
	private DictionaryService dictionaryService;
	
	@Autowired
	public DictionaryRest(DictionaryService dictionaryService)
	{
		Assert.notNull(dictionaryService, "dictionaryService must not be null");
		
		this.dictionaryService = dictionaryService;
	}
	
	@GetMapping
	public ResponseEntity<DictionaryUi> getDictionary()
	{
		String lang = dictionaryService.getDefaultLanguage();
		
		return getDictionary(lang);
	}

	@GetMapping(value="/{lang}")
	public ResponseEntity<DictionaryUi> getDictionaryForLang(@PathVariable("lang") String lang)
	{
		return getDictionary(lang);
	}
	
	private ResponseEntity<DictionaryUi> getDictionary(String lang)
	{
		log.debug("Fetching dictionary for language {}", lang);
		
		Map<String, String> messages = dictionaryService.getDictionary(lang);
		if (messages == null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		DictionaryUi dictionary = DictionaryAssembler.toResource(lang, messages);
		
		log.debug("Response {}", dictionary);
		return ResponseEntity.ok(dictionary);
	}
}
