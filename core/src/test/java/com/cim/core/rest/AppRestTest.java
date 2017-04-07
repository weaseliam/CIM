package com.cim.core.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cim.web.TestCIMApplication;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestCIMApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class AppRestTest
{
    @LocalServerPort
    int port;
	
    @Before
    public void setUp() 
    {
        RestAssured.port = port;
    }
    
	@Test
	public void testAppIndex()
	{
	}
}
