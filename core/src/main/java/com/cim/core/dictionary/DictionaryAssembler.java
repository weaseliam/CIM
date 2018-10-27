package com.cim.core.dictionary;

import java.util.Map;

public class DictionaryAssembler
{
	private DictionaryAssembler()
	{
		// private constructor
	}
	
	public static ApiDictionary toResource(String lang, Map<String, String> messages)
	{
		ApiDictionary dictionary = new ApiDictionary(lang, messages);
		
		return dictionary;
	}
}
