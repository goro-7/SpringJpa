package com.grsdev.springJpa.config.prop.demo;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix="app.props")
@Component
public class AppProperties {
	
	private String name;
	
	private List<String> fruits;
	
	private Map<String,String> map;
	
	private LoginDetails loginDetails;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFruits() {
		return fruits;
	}

	public void setFruits(List<String> fruits) {
		this.fruits = fruits;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
	public LoginDetails getLoginDetails() {
		return loginDetails;
	}

	public void setLoginDetails(LoginDetails loginDetails) {
		this.loginDetails = loginDetails;
	}



	public static class LoginDetails{
		
		private String username;
		
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
	}
}
