package com.cim.core.dictionary;

import java.util.Map;

public class DictionaryUi
{
	private String language;
	
	private Map<String, String> messages;

	public DictionaryUi()
	{
	}
	
	public DictionaryUi(String language, Map<String, String> messages)
	{
		this.language = language;
		this.messages = messages;
	}
	
	public String getLanguage()
	{
		return language;
	}

	public void setLanguage(String language)
	{
		this.language = language;
	}

	public Map<String, String> getMessages()
	{
		return messages;
	}

	public void setMessages(Map<String, String> messages)
	{
		this.messages = messages;
	}
	
	@Override
	public String toString()
	{
		return "DictionaryUi [language=" + language + ", no messages=" + (messages != null ? messages.size() : 0) + "]";
	}
}
