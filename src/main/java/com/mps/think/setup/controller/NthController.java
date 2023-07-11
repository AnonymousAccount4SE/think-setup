package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.NthService;
import com.mps.think.setup.vo.NthVO;

@RestController
@CrossOrigin
public class NthController {
	
	@Autowired
	private NthService nthService;
	
	@GetMapping("/getAllNth")
	public ResponseEntity<?> getAllNth() {
		return ResponseEntity.ok(nthService.getAllNth());
	}
	
	@PostMapping("/saveNth")
	public ResponseEntity<?> saveProcess(@RequestBody NthVO id) {
		return ResponseEntity.ok(nthService.saveNth(id));
	}
	
	@PostMapping("/updateNth")
	public ResponseEntity<?> updateJobQueue(@RequestBody NthVO id) {
		return ResponseEntity.ok(nthService.updateNth(id));
	}
	
	@PostMapping("/findbyNthId")
	public ResponseEntity<?> findbyProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(nthService.findbyNthId(id));
	}
	
	@DeleteMapping("/deletebyNthId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(nthService.deleteByNthId(id));
	}
	
	@PostMapping("getAllNthForPublisher")
	public ResponseEntity<?> findAllNthByPubId(@RequestBody Integer id) {
		return ResponseEntity.ok(nthService.findAllNthByPubId(id));
	}
	

}
