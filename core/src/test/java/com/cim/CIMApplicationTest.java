package com.cim;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.cim")
@EnableJpaRepositories("com.cim")
@EntityScan("com.cim")
@SpringBootApplication
public class CIMApplicationTest 
{
}
