package com.cim;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BaseRestTest
{
    @LocalServerPort
    private int port;
    
    protected int getLocalServerPort()
    {
    	return port;
    }
    
	@Test
	public void testPort()
	{
		assertTrue(port > 1024);
	}
}
