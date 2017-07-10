package com.cim.core.app;

import static io.restassured.RestAssured.given;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppControllerTest
{
    @LocalServerPort
    int port;
	
	@Test
	public void testRoot()
	{
		given().
			port(port).
		when().
			get("/");
	}
	
	@Test
	public void testLogin()
	{
		given().
			port(port).
		when().
			get("/login");
	}
}
