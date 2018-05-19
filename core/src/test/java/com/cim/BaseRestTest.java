package com.cim;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class BaseRestTest
{
	@LocalServerPort
    private int port;
    
    protected int getLocalServerPort()
    {
    	return port;
    }
    
	@Before
	public void before()
	{
		RestAssured.port = port;
	}
}
