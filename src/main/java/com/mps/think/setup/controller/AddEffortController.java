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
import com.mps.think.setup.service.AddEffortService;
import com.mps.think.setup.vo.AddEffortVO;
import com.mps.think.setup.vo.EnumModelVO.EffortType;
import com.mps.think.setup.vo.EnumModelVO.Pricing;
import com.mps.think.setup.vo.EnumModelVO.SendTo;


@RestController
@CrossOrigin
public class AddEffortController {
	
	@Autowired
	private AddEffortService addEffortService;
	
	@GetMapping("/getAllEffort")
	public ResponseEntity<?> getAllInserts() {
		return ResponseEntity.ok(addEffortService.getAllAddEffort());
	}
	
	@PostMapping("/saveEffort")
	public ResponseEntity<?> saveInserts(@RequestBody AddEffortVO id) {
		return ResponseEntity.ok(addEffortService.saveAddEffort(id));
	}
	
	@PostMapping("/updateEffort")
	public ResponseEntity<?> updateInserts(@RequestBody AddEffortVO id) {
		return ResponseEntity.ok(addEffortService.updateAddEffort(id));	
		}
	
	@PostMapping("/findbyEffortId")
	public ResponseEntity<?> findbySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(addEffortService.findbyAddEffortId(id));
	}
	
	@DeleteMapping("/deletebyEffortId")
	public ResponseEntity<?> deleteBySplitsId(@RequestBody Integer id) {
		return ResponseEntity.ok(addEffortService.deleteByAddEffortId(id));
	}
	
	@GetMapping("/findAllEffortType")
	public ResponseEntity<?> getAllEffortType() {
		List<String> list= new ArrayList<>();
		for(EffortType data:EffortType.values()) {
			list.add(data.getEffortType());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllSendTo")
	public ResponseEntity<?> getAllSendTo() {
		List<String> list= new ArrayList<>();
		for(SendTo data:SendTo.values()) {
			list.add(data.getSendTo());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllPricing")
	public ResponseEntity<?> getAllPricing() {
		List<String> list= new ArrayList<>();
		for(Pricing data:Pricing.values()) {
			list.add(data.getPricing());
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/getAllAddEffortForRenewalId")
	public ResponseEntity<?> findAllAddEffortForRenewalId(@RequestBody Integer id) {
		return ResponseEntity.ok(addEffortService.findAllAddEffortForRenewalId(id));
	}

}
