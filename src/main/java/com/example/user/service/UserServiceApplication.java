package com.example.user.service;

import com.example.user.service.dto.User;
import com.example.user.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class UserServiceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Map<String,User> userMap = new LinkedHashMap<>();
		User user1 = new User("100", "john_111", null);
		User user2 = new User("102", "john_222", null);
		User user3 = new User("103", "john_333", null);
/*		User user4 = new User("104", "john_444", null);
		User user5 = new User("105", "john_555", null);*/
		userMap.put(user1.getUserId(),user1);
		userMap.put(user2.getUserId(),user2);
		userMap.put(user3.getUserId(),user3);
/*		userMap.put(user4.getUserId(),user4);
		userMap.put(user5.getUserId(),user5);*/
		userService.setUserMap(userMap);


	}
}
