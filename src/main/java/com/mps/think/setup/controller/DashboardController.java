package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.DashboardService;

@RestController
@CrossOrigin
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping("/getDashboardCountsForPublisher")
	public ResponseEntity<?> getDashboardCountsForPublisher(@RequestParam Integer pubId) throws Exception {
		return ResponseEntity.ok(dashboardService
				.getDashboardCountsForPublisher(pubId));
	}
	
	@PostMapping("/getOrderTypesCountForPublisher")
	public ResponseEntity<?> getOrderTypesCountForPublisher(@RequestBody Integer pubId) throws Exception {
		return ResponseEntity.ok(dashboardService
				.getOrderTypesCountForPublisher(pubId));
	}
	
	@PostMapping("/getOrdersPerMonthForPublisher")
	public ResponseEntity<?> getOrdersPerMonthForPublisher(@RequestParam Integer pubId, @RequestParam Integer year) throws Exception {
		return ResponseEntity.ok(dashboardService
				.getOrdersPerMonthForPublisher(pubId,year));
	}
}
