package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.model.BasicJurisdictionTaxRate;
import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.model.CommodityCodes;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.service.BasicJurisdictionTaxRateService;
import com.mps.think.setup.service.BasicTaxRateService;
import com.mps.think.setup.service.CommodityCodesService;
import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.utils.Avalara;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;
import com.mps.think.setup.vo.JurisdictionsVO;
import com.mps.think.setup.vo.TaxCalculationDataVO;

@RestController
@CrossOrigin
public class JurisdictionsController {
	
	@Autowired
	JurisdictionsService jurisdictionsService;
	
	@Autowired
	BasicJurisdictionTaxRateService basicJurisdictionTaxRateService;
	
	@Autowired
	CommodityCodesService commodityCodesService;
	
	@Autowired
	BasicCommodityTaxRateService basicCommodityTaxRateService;
	
	@Autowired
	BasicTaxRateService basicTaxRateService;
	
	@GetMapping("/getAlljurisdictions")
	public ResponseEntity<?> getAlljurisdictions() {
		return ResponseEntity.ok(jurisdictionsService.findAllJurisdictions());
	}
	
	@PostMapping("/savejurisdictions")
	public ResponseEntity<?> savejurisdictions(@RequestBody JurisdictionsVO id) {
		return ResponseEntity.ok(jurisdictionsService.saveJurisdictions(id));
	}
	
	@PostMapping("/updatejurisdictions")
	public ResponseEntity<?> updatejurisdictions(@RequestBody JurisdictionsVO id) {
		return ResponseEntity.ok(jurisdictionsService.updateJurisdictions(id));
	}
	
	@PostMapping("/findbyjurisdictionsId")
	public ResponseEntity<?> findbyId(@RequestBody Integer id) {
		return ResponseEntity.ok(jurisdictionsService.findbyId(id));
	}
	
	@DeleteMapping("/deleteByJurisdictionsId")
	public ResponseEntity<?> deleteJurisdictionsById(@RequestBody Integer id) {
		return ResponseEntity.ok(jurisdictionsService.deleteJurisdictionsById(id));
	}
	
	@PostMapping("/getAllJurisdictionsForPublisher")
	public ResponseEntity<?> findAllJurisdictionsForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(jurisdictionsService.findAllJurisdictionsForPublisher(pubId));
	}
	
	@PostMapping("/findbyJurisdictionStateTaxContry")
	public ResponseEntity<?> findbyId(@RequestBody JurisdictionsVO JurisdictionVo ) {
		return ResponseEntity.ok(jurisdictionsService.findbyJurisdictionStateTaxContry(JurisdictionVo));
	}

	@GetMapping("/getAllcountrybyJurisdiction")
	public ResponseEntity<?> findbyId() {
		return ResponseEntity.ok(jurisdictionsService.getAllcountrybyJurisdiction());
	}
	@PostMapping("/getAllStateByJurisdiction")
	public ResponseEntity<?> getAllStateByJurisdiction(@RequestBody String country ) {
		return ResponseEntity.ok(jurisdictionsService.getAllStateByJurisdiction(country));
	}
	
	@PostMapping("/getbasicJurisdictionTaxRateByPubId")
	public ResponseEntity<?> getbasicJurisdictionTaxRateByPubId(@RequestBody Integer pubId) {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.findbasicJurisdictionTaxRateByPubId( pubId));
	}
	
	@PostMapping("/updatebasicJurisdictionTaxRate")
	public ResponseEntity<?> updatebasicJurisdictionTaxRate(@RequestBody BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		return ResponseEntity.ok(basicJurisdictionTaxRateService.updatebasicJurisdictionTaxRate(basicJurisdictionTaxRateVO));
	}
	
	@PostMapping("/findbasicTaxRatebyId")
	public ResponseEntity<?> findbasicTaxRatebyId(@RequestBody Integer id) {
		return ResponseEntity.ok(basicTaxRateService.findbasicTaxRatebyId(id));
	}
	
	@PostMapping("/taxCalculation")
	public ResponseEntity<?> taxCalculation(@RequestBody JurisdictionsVO JurisdictionVo) {
		Jurisdictions jurisdictions = jurisdictionsService.findbyJurisdictionStateTaxContry(JurisdictionVo);
		BasicCommodityTaxRate basicCommodityTaxRate = null;
		BasicJurisdictionTaxRate basicJurisdictionTaxRate = null;
		if(!jurisdictions.getExternalAlapplicable().equalsIgnoreCase("none")) {
//			avaalara api call
			Avalara avalara = new Avalara();
			return ResponseEntity.ok(avalara.AvalaraTaxClient(null, null, null, null));
		}else if(jurisdictions.getTaxCoumputation()){
			basicJurisdictionTaxRate = basicJurisdictionTaxRateService.findbasicJurisdictionTaxRatebyId(jurisdictions.getId());
		}else {
			CommodityCodes commodityCodes = commodityCodesService.getCommodityCodesdetails(JurisdictionVo.getCommodityCodes().getCommodityCode());
			basicCommodityTaxRate = basicCommodityTaxRateService.getbasicCommodityTaxRateById(commodityCodes.getId());
		}
		TaxCalculationDataVO taxCalculationData = null;	
		taxCalculationData.setBasictaxRate(basicCommodityTaxRate.getBasicCommodityTaxRateId().getRateValue());
		taxCalculationData.setCommodityTaxRateRate(basicCommodityTaxRate.getRateValue());
		taxCalculationData.setJurisdictionTaxRate(basicJurisdictionTaxRate.getRateValue());
		return ResponseEntity.ok(taxCalculationData);
	}
}
