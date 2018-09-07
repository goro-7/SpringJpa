package com.grsdev.springJpa.config.prop.demo;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.grsdev.springJpa.SpringJpaApplication;
import com.grsdev.springJpa.config.prop.demo.AppProperties;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringJpaApplication.class)
public class ConfigPropDemoTest {
	
	@Autowired
	private AppProperties appProps;
	
	
	@Test
	public void test1() {
		out.println("appProps.name:"+appProps.getName());
		assertThat(appProps.getName()).isEqualTo("Demo Application");
		
		assertThat(appProps.getFruits()).contains("Apple","Mango");
		
		assertThat(appProps.getMap()).containsKey("waitTime");
		
		Object object = appProps.getMap().get("waitTime");
		
		
		assertThat(appProps.getLoginDetails().getUsername()).isEqualTo("grsalvi");
		assertThat(appProps.getLoginDetails().getPassword()).isEqualTo("Newton7#");
		
	}

}
