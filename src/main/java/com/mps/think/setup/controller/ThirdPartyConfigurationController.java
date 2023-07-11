package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.ThirdPartyConfigService;
import com.mps.think.setup.vo.ThirdPartyConfigurationVO;

@RestController
@CrossOrigin
public class ThirdPartyConfigurationController {

	@Autowired
	ThirdPartyConfigService thirdPartyConfigService;

	@GetMapping("/getThirdPartyConfiguration")
	public ResponseEntity<?> thirdPartyConfigService() {
		return ResponseEntity.ok(thirdPartyConfigService.getThirdPartyConfiguration());
	}

	@PostMapping("/saveThirdPartyConfiguration")
	public ResponseEntity<?> saveThirdPartyConfiguration(
			@RequestBody ThirdPartyConfigurationVO thirdPartyConfigurationVO) {
		return ResponseEntity.ok(thirdPartyConfigService.saveThirdPartyConfiguration(thirdPartyConfigurationVO));
	}

	@PostMapping("/updateThirdPartyConfiguration")
	public ResponseEntity<?> updateThirdPartyConfiguration(
			@RequestBody ThirdPartyConfigurationVO thirdPartyConfigurationVO) {
		return ResponseEntity.ok(thirdPartyConfigService.updateThirdPartyConfiguration(thirdPartyConfigurationVO));
	}

	@PostMapping("/findbyThirdPartyConfiguration")
	public ResponseEntity<?> findbyTermsId(@RequestBody Integer id) {
		return ResponseEntity.ok(thirdPartyConfigService.findbyThirdPartyConfiguration(id));
	}

	@DeleteMapping("/deleteByThirdPartyConfiguration")
	public ResponseEntity<?> deleteBytermsId(@RequestBody Integer id) {
		return ResponseEntity.ok(thirdPartyConfigService.deleteByThirdPartyConfiguration(id));
	}

}
