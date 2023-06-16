package com.mps.think.setup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.serviceImpl.IssueGenerationServiceImpl;
import com.mps.think.setup.vo.IssueGenerationVo;

@RestController
@CrossOrigin
public class IssueGenerationController {

	@Autowired
	IssueGenerationServiceImpl issueGenerationServiceImpl;

	@GetMapping("/findAllIssueGeneration")
	public ResponseEntity<?> findAllIssueGeneration() {
		return ResponseEntity.ok(issueGenerationServiceImpl.findAllIssueGenerationVo());
	}

//	@PostMapping("/saveIssueGeneration")
//	public ResponseEntity<?> saveIssueGenerationVo(@RequestBody IssueGenerationVo issueGenerationVo) {
//		return ResponseEntity.ok(issueGenerationServiceImpl.saveIssueGenerationVo(issueGenerationVo));
//	}
	
	//Supplementary issue
	@PostMapping("/insertIssueGeneration")
	public ResponseEntity<?> insertIssueGenerationVo(@RequestBody IssueGenerationVo issueGenerationVo) {
		return ResponseEntity.ok(issueGenerationServiceImpl.insertIssueGenerationVo(issueGenerationVo));
	}
	
	@PostMapping("/generateIssue")
	public ResponseEntity<?> generateIssueGenerationVo(@RequestBody IssueGenerationVo issueGenerationVo) {
		return ResponseEntity.ok(issueGenerationServiceImpl.generateIssueGenerationVo(issueGenerationVo));
	}

	@PostMapping("/updateIssueGeneration")
	public ResponseEntity<?> updateIssueGeneration(@RequestBody IssueGenerationVo issueGenerationVo) {
		return ResponseEntity.ok(issueGenerationServiceImpl.updateIssueGenerationVo(issueGenerationVo));
	}

	@PostMapping("/findbyIssueId")
	public ResponseEntity<?> findbyIssueId(@RequestBody Integer issueId) {
		return ResponseEntity.ok(issueGenerationServiceImpl.findbyIssueId(issueId));
	}
	
	@GetMapping("/findMaxSeqIssue")
	public ResponseEntity<?> findMaxSeqIssue(@RequestParam Integer ocId) {
		return ResponseEntity.ok(issueGenerationServiceImpl.findMaxSeqIssue(ocId));
	}
	
	@DeleteMapping("/deleteIssuebyId")
	public ResponseEntity<?> deleteIssueCode(@RequestBody Integer[] IssueId) {
		return ResponseEntity.ok(issueGenerationServiceImpl.deleteIssueById(IssueId));
	}
	
	@PostMapping("/getAllIssueGenerationForPublisher")
	public ResponseEntity<?> getAllIssueGenerationForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(issueGenerationServiceImpl.getAllIssueGenerationForPublisher(pubId));
	}
	
	@PostMapping("/getCurrentIssue")
	public ResponseEntity<?> getCurrentIssue(@RequestParam Integer pubId,@RequestParam List<Integer> ocId) {
		return ResponseEntity.ok(issueGenerationServiceImpl.getCurrentIssue(pubId, ocId));
	}
}
