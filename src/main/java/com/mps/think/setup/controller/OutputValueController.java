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
import com.mps.think.setup.service.OutputValueService;
import com.mps.think.setup.vo.OutputValueVO;
import com.mps.think.setup.vo.EnumModelVO.Mode;


@RestController
@CrossOrigin
public class OutputValueController {
	
	@Autowired
	OutputValueService outputValueService;
	
	@GetMapping("/getAllOutputValue")
	public ResponseEntity<?> getAllOutputValue() {
		return ResponseEntity.ok(outputValueService.getAllOutputValue());
	}
	
	@PostMapping("/saveOutputValue")
	public ResponseEntity<?> saveOutputValue(@RequestBody OutputValueVO id) {
		return ResponseEntity.ok(outputValueService.saveOutputValue(id));
	}

	@PostMapping("/updateOutputValue")
	public ResponseEntity<?> updateOutputValue(@RequestBody OutputValueVO id) {
		return ResponseEntity.ok(outputValueService.updateOutputValue(id));
	}
	
	@PostMapping("/findbyOutputValueId")
	public ResponseEntity<?> findbyOutputValueId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputValueService.findbyOutputValueId(id));
	}
	
	@DeleteMapping("/deletebyOutputValueId")
	public ResponseEntity<?> deleteByOutputValueId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputValueService.deleteByOutputValueId(id));
	}
	
	@GetMapping("/findAllModes")
	public ResponseEntity<?> getAllMode() {
		List<String> list= new ArrayList<>();
		for(Mode data:Mode.values()) {
			list.add(data.getMode());
		}
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("getAllOutputValueForPublisher")
	public ResponseEntity<?> findAllOutputValueByPubId(@RequestBody Integer id) {
		return ResponseEntity.ok(outputValueService.findAllOutputValueByPubId(id));
	}

}
