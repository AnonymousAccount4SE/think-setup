package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.QueueService;
import com.mps.think.setup.vo.QueueVO;

@RestController
@CrossOrigin
public class QueueController {
	
	@Autowired
	QueueService queueService;
	
	@GetMapping("/getAllQueue")
	public ResponseEntity<?> getAllQueue() {
		return ResponseEntity.ok(queueService.getAllQueue());
	}
	
	@PostMapping("/saveQueue")
	public ResponseEntity<?> saveQueue(@RequestBody QueueVO id) {
		return ResponseEntity.ok(queueService.saveQueue(id));
	}

	@PostMapping("/updateQueue")
	public ResponseEntity<?> updateQueue(@RequestBody QueueVO id) {
		return ResponseEntity.ok(queueService.updateQueue(id));
	}
	
	@PostMapping("/findbyQueueId")
	public ResponseEntity<?> findbyQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(queueService.findbyQueueId(id));
	}
	
	@DeleteMapping("/deletebyQueueId")
	public ResponseEntity<?> deleteByQueueId(@RequestBody Integer id) {
		return ResponseEntity.ok(queueService.deleteByQueueId(id));
	}
	
	@PostMapping("getAllQueueForPublisher")
	public ResponseEntity<?> getAllQueueForPublisher(@RequestBody Integer id) {
		return ResponseEntity.ok(queueService.findAllQueueByPubId(id));
	}

}
