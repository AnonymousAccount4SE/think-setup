package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.service.CommodityCodesService;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;
import com.mps.think.setup.vo.CommodityCodesVO;

@RestController
@CrossOrigin
public class CommodityCodesController {
	
	@Autowired
	CommodityCodesService commodityCodesService;
	
	@Autowired
	BasicCommodityTaxRateService basicCommodityTaxRateService;
	
	@GetMapping("/getAllCommodityCodes")
	public ResponseEntity<?> getAllCommodityCodes() {
		return ResponseEntity.ok(commodityCodesService.findAllCommodityCodes());
	}
	
	@PostMapping("/saveCommodityCodes")
	public ResponseEntity<?> savecommodityCodes(@RequestBody CommodityCodesVO id) {
		return ResponseEntity.ok(commodityCodesService.saveCommodityCodes(id));
	}
	
	@PostMapping("/updateCommodityCodes")
	public ResponseEntity<?> updatecommodityCodes(@RequestBody CommodityCodesVO id) {
		return ResponseEntity.ok(commodityCodesService.updateCommodityCodes(id));
	}
	
	@PostMapping("/findbyCommodityCodesId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id) {
		return ResponseEntity.ok(commodityCodesService.findbyId(id));
	}
	
	@DeleteMapping("/deleteByCcId")
	public ResponseEntity<?> deleteCommodityCodesById(@RequestBody Integer id) {
		return ResponseEntity.ok(commodityCodesService.deleteCommodityCodesById(id));
	}

	@PostMapping("/getAllCommodityCodesForPublisher")
	public ResponseEntity<?> findAllCommodityCodesForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(commodityCodesService.findAllCommodityCodesForPublisher(pubId));
	}
	
	@PostMapping("/getbasicCommodityTaxRateByPubId")
	public ResponseEntity<?> getbasicCommodityTaxRateByPubId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(basicCommodityTaxRateService.getbasicCommodityTaxRateByPubId( pubId));
	}
	
//	@PostMapping("/updatebasicCommodityTaxRate")
//	public ResponseEntity<?> updatebasicCommodityTaxRate(@RequestBody BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
//		return ResponseEntity.ok(basicCommodityTaxRateService.updatebasicCommodityTaxRate(basicCommodityTaxRateVO));
//	}
}
