package com.piyush.accountservice.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piyush.accountservice.data.HealthCheckResponse;

@RestController
public class AccountsController {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@GetMapping("/healthCheck")
	public ResponseEntity<?> healthCheck() {

		logger.info("Inside  Account Server");
		return ResponseEntity.ok(new HealthCheckResponse(true, "Account Server"));
	}
	
	@GetMapping("/info")
	public ResponseEntity<?> info() {

		logger.info("Inside  Account Server");
		return ResponseEntity.ok(new HealthCheckResponse(true, "Account Server"));
	}
}
