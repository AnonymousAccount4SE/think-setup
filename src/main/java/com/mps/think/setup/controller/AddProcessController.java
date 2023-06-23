package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.AddProcessService;
import com.mps.think.setup.vo.AddProcessVO;

@RestController
@CrossOrigin
public class AddProcessController {
	
	@Autowired
	AddProcessService addProcessService;
	
	@GetMapping("/getAllAddProcess")
	public ResponseEntity<?> getAllAddProcess() {
		return ResponseEntity.ok(addProcessService.getAllProcess());
	}
	
	@PostMapping("/saveAddProcess")
	public ResponseEntity<?> saveProcess(@RequestBody AddProcessVO id) {
		return ResponseEntity.ok(addProcessService.saveProcess(id));
	}
	
	@PostMapping("/updateAddProcess")
	public ResponseEntity<?> updateJobQueue(@RequestBody AddProcessVO id) {
		return ResponseEntity.ok(addProcessService.updateProcess(id));
	}
	
	@PostMapping("/findbyAddProcessId")
	public ResponseEntity<?> findbyProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(addProcessService.findbyProcessId(id));
	}
	
	@DeleteMapping("/deletebyAddProcessId")
	public ResponseEntity<?> deleteByProcessId(@RequestBody Integer id) {
		return ResponseEntity.ok(addProcessService.deleteByProcessId(id));
	}
	
	@PostMapping("/getAllAddProcessForPublisher")
	public ResponseEntity<?> findAllAddProcessForPublisher(@RequestBody Integer pubId) {
		return ResponseEntity.ok(addProcessService.findAllAddProcessForPublisher(pubId));
	}
	
//	@PostMapping("getAllAddProcessForpid")
//	public ResponseEntity<?> findAllAddProcessByPubId(@RequestBody Integer pId) {
//		return ResponseEntity.ok(addProcessService.findAllAddProcessByPId(pId));
//	}

}
