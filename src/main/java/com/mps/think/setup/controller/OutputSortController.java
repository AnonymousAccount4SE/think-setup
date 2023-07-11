package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.OutputSortService;
import com.mps.think.setup.vo.OutputSortVO;

@RestController
@CrossOrigin
public class OutputSortController {
	
	@Autowired
	OutputSortService outputSortService;
	
	@GetMapping("/getAllOutputSort")
	public ResponseEntity<?> getAllOutputSort() {
		return ResponseEntity.ok(outputSortService.getAllOutputSort());
	}
	
	@PostMapping("/saveOutputSort")
	public ResponseEntity<?> saveProcess(@RequestBody OutputSortVO id) {
		return ResponseEntity.ok(outputSortService.saveOutputSort(id));
	}
	
	@PostMapping("/updateOutputSort")
	public ResponseEntity<?> updateJobQueue(@RequestBody OutputSortVO id) {
		return ResponseEntity.ok(outputSortService.updateOutputSort(id));
	}
	
	@PostMapping("/findbyOutputSortId")
	public ResponseEntity<?> findbyProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputSortService.findbyOutputSortId(id));
	}
	
	@DeleteMapping("/deletebyOutputSortId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputSortService.deleteByOutputSortId(id));
	}
	
	@PostMapping("getAllOutputSortForPublisher")
	public ResponseEntity<?> findAllOutputSortByPubId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputSortService.findAllOutputSortByPubId(id));
	}

}
