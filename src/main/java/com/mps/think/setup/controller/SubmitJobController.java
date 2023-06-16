package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.SubmitJobService;
import com.mps.think.setup.vo.SubmitJobVO;

@RestController
@CrossOrigin
public class SubmitJobController {
	
	@Autowired
	SubmitJobService submitJobService;
	
	@GetMapping("/getAllsubmitJob")
	public ResponseEntity<?> getAllSubmitJob() {
		return ResponseEntity.ok(submitJobService.getAllSubmitJob());
	}
	
	@PostMapping("/savesubmitJob")
	public ResponseEntity<?> saveSubmitJob(@RequestBody SubmitJobVO id) {
		return ResponseEntity.ok(submitJobService.saveSubmitJob(id));
	}
	
	@PostMapping("/updatesubmitJob")
	public ResponseEntity<?> updateJobQueue(@RequestBody SubmitJobVO id) {
		return ResponseEntity.ok(submitJobService.updateSubmitJob(id));
	}
	
	@PostMapping("/findbysubmitJobId")
	public ResponseEntity<?> findbyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(submitJobService.findbySubmitJobId(id));
	}
	
	@DeleteMapping("/deletebysubmitJobId")
	public ResponseEntity<?> deletebyJobQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(submitJobService.deleteBySubmitJobId(id));
	}

	@PostMapping("findAllSubmitJobByPubId")
	public ResponseEntity<?> getAllTaxonomyForPublisher( @RequestBody Integer publisherId) {
		return ResponseEntity.ok(submitJobService.findAllSubmitJobByPubId(publisherId));
	}
}
