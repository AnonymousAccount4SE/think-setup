package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.InstallmentPlanService;
import com.mps.think.setup.vo.InstallmentPlanVO;
import com.mps.think.setup.vo.PaymentThresholdVO;
import com.mps.think.setup.vo.SetupInstallmentsVO;

@RestController
@CrossOrigin
public class InstallmentPlanController {

	@Autowired
	InstallmentPlanService installmentPlanService;
	 
	@GetMapping("/getAllInstallmentPlan")
	public ResponseEntity<?> getAllInstallmentPlan() {
		return ResponseEntity.ok(installmentPlanService.getAllInstallmentPlan());
	}
	
	@PostMapping("/saveInstallmentPlan")
	public ResponseEntity<?> saveInstallmentPlan(@RequestBody InstallmentPlanVO installmentPlanVO){
		return ResponseEntity.ok(installmentPlanService.saveInstallmentPlanService(installmentPlanVO));
	}
	
	
	@PostMapping("/updateInstallmentPlan")
	public ResponseEntity<?> updateInstallmentPlan(@RequestBody InstallmentPlanVO installmentPlanVO){
		return ResponseEntity.ok(installmentPlanService.updateInstallmentPlan(installmentPlanVO));
	}
	
	@PostMapping("/getInstallmentPlanById")
	public ResponseEntity<?> getInstallmentPlanById(@RequestBody Integer id){
		return ResponseEntity.ok(installmentPlanService.findByInstallmentPlanId(id));
	}
	
	@DeleteMapping("/DeleteInstallmentPlan")
	public ResponseEntity<?> DeleteInstallmentPlan(@RequestBody Integer id) {
		return ResponseEntity.ok(installmentPlanService.DeleteInstallmentPlan(id));
	}
	
	@PostMapping("/saveSetUpInstallments")
	public ResponseEntity<?> saveSetUpInstallments(@RequestBody SetupInstallmentsVO setupInstallmentPlanVO){
		return ResponseEntity.ok(installmentPlanService.saveSetUpInstallmentsService(setupInstallmentPlanVO));
	}
	
	@PostMapping("/updateSetUpInstallments")
	public ResponseEntity<?> updateSetUpInstallments(@RequestBody SetupInstallmentsVO setupInstallmentPlanVO){
		return ResponseEntity.ok(installmentPlanService.updateSetUpInstallments(setupInstallmentPlanVO));
	}
	
	@GetMapping("/getAllSetUpInstallments")
	public ResponseEntity<?> getSetUpInstallments() {
		return ResponseEntity.ok(installmentPlanService.getSetUpInstallments());
	}
	
	@PostMapping("/getSetUpInstallmentsById")
	public ResponseEntity<?> getSetUpInstallmentsById(@RequestBody Integer id){
		return ResponseEntity.ok(installmentPlanService.findBySetUpInstallmentsId(id));
	}
}
