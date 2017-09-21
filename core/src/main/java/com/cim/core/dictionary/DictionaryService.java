package com.cim.core.dictionary;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

@Service
public class DictionaryService
{
	private static final Logger log = LoggerFactory.getLogger(DictionaryService.class);
	
	private Map<String, Map<String, String>> dictionaries = new HashMap<>();
	private String defaultLang = "en";
	
	@PostConstruct
	private void init()
	{
		loadDictionaries();
		
		setDefaultLanguage();
	}

	private void loadDictionaries()
	{
		try
		{
			ResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver();
			Resource[] resources = resourceResolver.getResources(
					ResourceUtils.CLASSPATH_URL_PREFIX + "dictionary/*");

			log.info("Found {} dictionaries in classpath", resources != null ? resources.length : 0);

			for (Resource resource : resources)
			{
				Properties messages = new Properties();
				try (InputStream in = resource.getInputStream())
				{
					messages.load(in);
				}
				catch (IOException e)
				{
					log.error("Failed to load dictionary from " + resource, e);
					continue;
				}

				String fileName = resource.getFilename();
				String language = fileName.substring(0, fileName.indexOf('.'));
				dictionaries.put(language, (Map) messages);

				log.debug("Loaded {} dictionary from {}", language, resource);
			}
			
			log.info("Loaded {} dictionaries {}", dictionaries.size(), dictionaries.keySet());
		}
		catch (IOException e)
		{
			log.error("Failed to load dictionary files", e);
		}
	}
	
	private void setDefaultLanguage()
	{
		if (!dictionaries.keySet().isEmpty() && 
			!dictionaries.keySet().contains(defaultLang))
		{
			String firstLang = dictionaries.keySet().iterator().next();
			defaultLang = firstLang;
		}
		
		log.info("Default language is {}", defaultLang);
	}
	
	public Map<String, String> getDefaultDictionary()
	{
		return getDictionary(defaultLang);
	}
	
	public Map<String, String> getDictionary(String lang)
	{
		Map<String, String> dictionary = dictionaries.get(lang);
		return dictionary;
	}
	
	public Map<String, String> getDictionaryWithFallback(String lang)
	{
		Map<String, String> dictionary = getDictionary(lang);
		if (dictionary == null)
		{
			dictionary = getDefaultDictionary();
		}
		
		return dictionary;
	}
	
	public String getDefaultLanguage()
	{
		return defaultLang;
	}
	
	public List<String> listSupportedLanguages()
	{
		return new ArrayList<String>(dictionaries.keySet());
	}
	
	public String getMessage(String code)
	{
		return getMessage(code, null, defaultLang);
	}
	
	public String getMessage(String code, String[] params)
	{
		return getMessage(code, params, defaultLang);
	}
	
	public String getMessage(String code, String lang)
	{
		return getMessage(code, null, lang);
	}
	
	public String getMessage(String code, String[] params, String lang)
	{
		if (StringUtils.isBlank(code) ||
			StringUtils.isBlank(lang))
		{
			log.debug("Failed to read message for lang {}, code {}, params {}", lang, code, params);
			return code;
		}
		
		Map<String, String> dictionary = dictionaries.get(lang);
		if (dictionary == null ||
			dictionary.isEmpty() ||
			!dictionary.containsKey(code))
		{
			log.debug("Failed to read message for lang {}, code {}, params {}", lang, code, params);
			return code;
		}
		
		String message = dictionary.get(code);
		if (ArrayUtils.isEmpty(params))
		{
			return message;
		}
		
		return formatMessage(message, params);
	}

	private String formatMessage(String message, String[] params)
	{
		if (StringUtils.isBlank(message) ||
			ArrayUtils.isEmpty(params))
		{
			return message;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < message.length(); i++)
		{
			char c = message.charAt(i);
			if (c != '{')
			{
				sb.append(c);
				continue;
			}
			
			if (i + 2 >= message.length() ||
				message.charAt(i + 1) < '0' && message.charAt(i + 1) > '9' ||
				message.charAt(i + 2) != '}')
			{
				sb.append(c);
				continue;
			}
			
			int paramIndex = message.charAt(i + 1) - '0';
			if (paramIndex >= params.length)
			{
				sb.append(c);
				continue;
			}
			
			sb.append(params[paramIndex]);
			i += 2;
		}
		
		return sb.toString();
	}
}
