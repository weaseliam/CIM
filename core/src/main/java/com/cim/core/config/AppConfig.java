package com.cim.core.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cim.core.util.DateUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class AppConfig
{
	@Bean
	@Primary
	public ObjectMapper objectMapperConfig()
	{
		ObjectMapper objectMapper = new ObjectMapper();

		// set spring boot recommended options
		objectMapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		// handle date time as ISO-8601
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		javaTimeModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>()
		{
			@Override
			public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
					throws IOException
			{
				ZonedDateTime zdt = DateUtil.toZonedDateTime(value);
				String s = zdt.format(DateTimeFormatter.ISO_INSTANT);
				gen.writeString(s);
			}
		});
		javaTimeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>()
		{
			@Override
			public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException
			{
				LocalDateTime ldt = LocalDateTime.parse(p.getValueAsString(), DateTimeFormatter.ISO_INSTANT);
				return ldt;
			}
		});
		objectMapper.registerModule(javaTimeModule);

		return objectMapper;
	}
}
