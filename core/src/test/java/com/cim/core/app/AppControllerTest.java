package com.cim.core.app;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import com.cim.BaseRestTest;

public class AppControllerTest extends BaseRestTest
{
	@Test
	public void testRoot()
	{
		given()
		.when()
			.get("/")
		.then()
		    .statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void testLogin()
	{
		given()
		.when()
			.get("/login")
		.then()
		    .statusCode(HttpStatus.OK.value());
	}
}
