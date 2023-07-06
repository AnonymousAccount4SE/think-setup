
package com.mps.think.setup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mps.think.setup.service.EffortRangeService;
import com.mps.think.setup.vo.EffortRangeVO;

@RestController
@CrossOrigin
public class EffortRangeController {
	
	@Autowired
	private EffortRangeService effortRangeService;
	
	@GetMapping("/getAllEffortRange")
	public ResponseEntity<?> getAllEffortRange() {
		return ResponseEntity.ok(effortRangeService.getAllEffortRange());
	}
	
	@PostMapping("/saveEffortRange")
	public ResponseEntity<?> saveEffortRange(@RequestBody EffortRangeVO id) {
		return ResponseEntity.ok(effortRangeService.saveEffortRange(id));
	}
	
	@PostMapping("/updateEffortRange")
	public ResponseEntity<?> updateEffortRange(@RequestBody EffortRangeVO id) {
		return ResponseEntity.ok(effortRangeService.updateEffortRange(id));	
		}
	
	@PostMapping("/findbyEffortRangeId")
	public ResponseEntity<?> findbyEffortRangeId(@RequestBody Integer id) {
		return ResponseEntity.ok(effortRangeService.findbyEffortRangeId(id));
	}
	
	@DeleteMapping("/deletebyEffortRangeId")
	public ResponseEntity<?> deleteByEffortRangeId(@RequestBody Integer id) {
		return ResponseEntity.ok(effortRangeService.deleteByEffortRangeId(id));
	}
	
	@PostMapping("/findAllEffortRangeByAddRenewalsId")
	public ResponseEntity<?> findAllEffortRangeByAddRenewalsId(@RequestBody Integer id) {
		return ResponseEntity.ok(effortRangeService.findAllEffortRangeByAddRenewalsId(id));
	}

}
