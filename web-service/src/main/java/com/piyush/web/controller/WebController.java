package com.piyush.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.piyush.web.data.HealthCheckResponse;


@RestController
public class WebController {

	@Autowired
	@LoadBalanced
	public RestTemplate restTemplate;

	protected Logger logger = Logger.getLogger(this.getClass());
	
	public static final String ACCOUNT_SERVICE = "http://accounts-service/";
	
	@GetMapping("/healthCheck")
	public ResponseEntity<?> healthCheck() {

		logger.info("Inside  Account Server");
		return ResponseEntity.ok(new HealthCheckResponse(true, "Web Server"));
	}
	
	@GetMapping("/info")
	public ResponseEntity<?> info() {

		logger.info("Inside  Account Server");
		return ResponseEntity.ok(new HealthCheckResponse(true, "Web Server"));
	}
	
	@GetMapping("/connectAccountServer")
	public ResponseEntity<?> connectAccountServer() {

		HealthCheckResponse healthCheckResponse = restTemplate.getForObject(ACCOUNT_SERVICE + "healthCheck", HealthCheckResponse.class);
		logger.info("Inside  Account Server");
		return ResponseEntity.ok(healthCheckResponse);
	}
	
	
}
