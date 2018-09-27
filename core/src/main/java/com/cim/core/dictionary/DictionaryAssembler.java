package com.cim.core.dictionary;

import java.util.Map;

public class DictionaryAssembler
{
	public static DictionaryUi toUi(String lang, Map<String, String> messages)
	{
		DictionaryUi dictionary = new DictionaryUi(lang, messages);
		
		return dictionary;
	}
}
