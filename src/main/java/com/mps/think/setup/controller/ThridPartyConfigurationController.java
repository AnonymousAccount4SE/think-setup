package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ThridPartyConfigService;
import com.mps.think.setup.vo.ThridPartyConfigurationVO;

@RestController
@CrossOrigin
public class ThridPartyConfigurationController {

	@Autowired
	ThridPartyConfigService thridPartyConfigService;

	@GetMapping("/getThridPartyConfiguration")
	public ResponseEntity<?> thridPartyConfigService() {
		return ResponseEntity.ok(thridPartyConfigService.getThridPartyConfiguration());
	}

	@PostMapping("/saveThridPartyConfiguration")
	public ResponseEntity<?> saveThridPartyConfiguration(
			@RequestBody ThridPartyConfigurationVO thridPartyConfigurationVO) {
		return ResponseEntity.ok(thridPartyConfigService.saveThridPartyConfiguration(thridPartyConfigurationVO));
	}

	@PostMapping("/updateThridPartyConfiguration")
	public ResponseEntity<?> updateThridPartyConfiguration(
			@RequestBody ThridPartyConfigurationVO thridPartyConfigurationVO) {
		return ResponseEntity.ok(thridPartyConfigService.updateThridPartyConfiguration(thridPartyConfigurationVO));
	}

	@PostMapping("/findbyThridPartyConfiguration")
	public ResponseEntity<?> findbyTermsId(@RequestBody Integer id) {
		return ResponseEntity.ok(thridPartyConfigService.findbyThridPartyConfiguration(id));
	}

	@DeleteMapping("/deleteByThridPartyConfiguration")
	public ResponseEntity<?> deleteBytermsId(@RequestBody Integer id) {
		return ResponseEntity.ok(thridPartyConfigService.deleteByThridPartyConfiguration(id));
	}

}
