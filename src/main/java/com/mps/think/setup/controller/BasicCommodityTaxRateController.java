package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;

@RestController
@CrossOrigin
public class BasicCommodityTaxRateController {

	@Autowired
	private BasicCommodityTaxRateService basicCommodityTaxRateService;

	@GetMapping("/findAllbasicCommodityTaxRate")
	public ResponseEntity<List<BasicCommodityTaxRate>> findAllbasicCommodityTaxRate() {
		return ResponseEntity.ok(basicCommodityTaxRateService.findAllbasicCommodityTaxRate());
	}

	@PostMapping("/saveBasicCommodityTaxRateDetails")
	public ResponseEntity<?> saveBasicCommodityTaxRateDetails(
			@RequestBody BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
		return ResponseEntity
				.ok(basicCommodityTaxRateService.saveBasicCommodityTaxRateDetails(basicCommodityTaxRateVO));
	}

	@PostMapping("/updatebasicCommodityTaxRate")
	public ResponseEntity<?> updatebasicCommodityTaxRate(@RequestBody BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
		return ResponseEntity.ok(basicCommodityTaxRateService.updatebasicCommodityTaxRate(basicCommodityTaxRateVO));
	}

	@PostMapping("/getbasicCommodityTaxRateById")
	public ResponseEntity<?> getbasicCommodityTaxRateById(@RequestBody Integer id) {
		return ResponseEntity.ok(basicCommodityTaxRateService.getbasicCommodityTaxRateById(id));
	}

}
