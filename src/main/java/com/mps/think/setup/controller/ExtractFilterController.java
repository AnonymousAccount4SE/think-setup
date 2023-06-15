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

import com.mps.think.setup.model.ExtractFilter;
import com.mps.think.setup.service.AddProcessService;
import com.mps.think.setup.service.ExtractFilterService;
import com.mps.think.setup.utils.AppConstants.AuxCategory;
import com.mps.think.setup.utils.AppConstants.ExtractFilterTableName;
import com.mps.think.setup.vo.AddProcessVO;
import com.mps.think.setup.vo.ExtractFilterGroupVO;
import com.mps.think.setup.vo.ExtractFilterVO;
 
@RestController
@CrossOrigin
public class ExtractFilterController {
	
	@Autowired
	ExtractFilterService extractFilter;
	
	@GetMapping("/getAllExtractFilter")
	public ResponseEntity<?> getAllExtractFilter() {
		return ResponseEntity.ok(extractFilter.getAllExtractFilter());
	}
	
	@PostMapping("/saveExtractFilter")
	public ResponseEntity<?> saveExtractFilter(@RequestBody ExtractFilterVO id) {
		return ResponseEntity.ok(extractFilter.saveExtractFilter(id));
	}
	 
	@PostMapping("/updateExtractFilter")
	public ResponseEntity<?> updateExtractFilter(@RequestBody ExtractFilterVO id) {
		return ResponseEntity.ok(extractFilter.updateExtractFilter(id));
	}
	
	@PostMapping("/findbyExtractFilterId")
	public ResponseEntity<?> findbyExtractFilterId(@RequestBody Integer id) {
		return ResponseEntity.ok(extractFilter.findbyExtractFilterId(id));
	}
	
	@DeleteMapping("/deletebyExtractFilterId")
	public ResponseEntity<?> deleteByExtractFilterId(@RequestBody Integer id) {
		return ResponseEntity.ok(extractFilter.deleteByExtractFilterId(id));
	}

	@GetMapping("/getAllExtractFilterTables")
	public ResponseEntity<?> getAllExtractFilterTables() {
		List<String> list= new ArrayList<>();
		for(ExtractFilterTableName data:ExtractFilterTableName.values()) {
			list.add(data.displayName());
		}
		return ResponseEntity.ok(list);
	}
	 @PostMapping("/findAllColumnsOfTables")
	public ResponseEntity<?> getAllColumnsOfTables(@RequestBody String tableName) {
		return ResponseEntity.ok(extractFilter.getAllColumnsOfTables(tableName));
	}  
}
