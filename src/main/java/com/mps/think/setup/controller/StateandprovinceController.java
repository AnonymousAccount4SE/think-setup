package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.StateandprovinceService;
import com.mps.think.setup.vo.StateandprovinceVO;
import com.mps.think.setup.vo.EnumModelVO.AddressValidation;
import com.mps.think.setup.vo.EnumModelVO.TaxComputation;

@RestController
@CrossOrigin
public class StateandprovinceController {
	
	@Autowired
	StateandprovinceService stateandprovinceService;
	
	@GetMapping("/getAllStateandprovince")
	public ResponseEntity<?> getAllStateandprovince() {
		return ResponseEntity.ok(stateandprovinceService.getAllStateandprovince());
	}
	
	@PostMapping("/saveStateandprovince")
	public ResponseEntity<?> saveStateandprovince(@RequestBody StateandprovinceVO id) {
		return ResponseEntity.ok(stateandprovinceService.saveStateandprovince(id));
	}
	
	@PostMapping("/updateStateandprovince")
	public ResponseEntity<?> updateStateandprovince(@RequestBody StateandprovinceVO id) {
		return ResponseEntity.ok(stateandprovinceService.updateStateandprovince(id));
	}
	
	@PostMapping("/findbyStateandprovinceId")
	public ResponseEntity<?> findbyStateandprovinceId(@RequestBody Integer id) {
		return ResponseEntity.ok(stateandprovinceService.findbyStateandprovinceId(id));
	}
	
	@DeleteMapping("/deletebyStateandprovinceId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(stateandprovinceService.deleteByStateandprovinceId(id));
	}
	
	@PostMapping("/findAllStateandprovinceForPublisher")
	public ResponseEntity<?> findAllStateandprovinceForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(stateandprovinceService.findAllStateandprovinceForPublisher(pubId));
	}
	
	@GetMapping("/findAllTaxComputationforstate")
	public ResponseEntity<?> getAllTaxComputation() {
		List<String> list= new ArrayList<>();
		for(TaxComputation data:TaxComputation.values()) {
			list.add(data.getTaxComputation());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllAddressValidationforstate")
	public ResponseEntity<?> getAllAddressValidation() {
		List<String> list= new ArrayList<>();
		for(AddressValidation data:AddressValidation.values()) {
			list.add(data.getAddressValidation());
		}
		return ResponseEntity.ok(list);
	}
	
//	@PostMapping("/findAllStateandprovinceForCountry")
//	public ResponseEntity<?> findAllStateandprovinceForCountry(@RequestBody Integer id) {
//		return ResponseEntity.ok(stateandprovinceService.findAllStateandprovinceForCountry(id));
//	}

}
