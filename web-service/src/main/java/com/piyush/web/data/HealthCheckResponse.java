package com.piyush.web.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HealthCheckResponse {

	boolean isActive;
	String serverName;
}
