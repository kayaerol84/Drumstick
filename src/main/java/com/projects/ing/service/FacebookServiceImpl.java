package com.projects.ing.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.projects.ing.domain.User;

@Component
public class FacebookServiceImpl implements FacebookService{

	public User fetchUser() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://graph.facebook.com/ramyaraghumanbabu?name";
		User user=restTemplate.getForObject(url, User.class);
		return user;
	}
	
}
