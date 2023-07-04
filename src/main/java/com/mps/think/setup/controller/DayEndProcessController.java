package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.DayEndProcessService;
import com.mps.think.setup.vo.DayEndProcessVO;

@CrossOrigin
@RestController
public class DayEndProcessController {
	
	@Autowired
	private DayEndProcessService dayEndProcessService;
	
	@PostMapping("/fetchDayEndProcessById")
	public ResponseEntity<?> fetchDayEndProcessById(@RequestBody Integer id) {
		return ResponseEntity.ok(dayEndProcessService.fetchById(id));
	}
	
	@PostMapping("/fetchDayEndProcessByPubId")
	public ResponseEntity<?> fetchDayEndProcessByPubId(@RequestBody Integer id) {
		return ResponseEntity.ok(dayEndProcessService.fetchByPubId(id));
	}

	@PostMapping("/saveDayEndProcess")
	public ResponseEntity<?> saveDayEndProcess(@RequestBody DayEndProcessVO dayEndProcess) {
		return ResponseEntity.ok(dayEndProcessService.saveDayEndProcess(dayEndProcess));
	}
	
	@PutMapping("/updateDayEndProcess")
	public ResponseEntity<?> updateDayEndProcess(@RequestBody DayEndProcessVO dayEndProcess) {
		return ResponseEntity.ok(dayEndProcessService.updateDayEndProcess(dayEndProcess));
	}
	
}
