package com.cim.core.app;

import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Test;

import com.cim.BaseRestTest;

public class AppControllerTest extends BaseRestTest
{
	@Test
	public void testRoot()
	{
		get("/")
		.then()
		    .body("path", equalTo("/"));
	}
	
	@Test
	public void testLogin()
	{
		get("/login")
		.then()
			.body("path", equalTo("/login"));
	}
}
