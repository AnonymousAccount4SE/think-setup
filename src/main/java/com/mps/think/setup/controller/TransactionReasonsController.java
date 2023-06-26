package com.mps.think.setup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 import com.mps.think.setup.service.TransactionReasonsService;
 import com.mps.think.setup.vo.TransactionReasonsVO;

@RestController
@CrossOrigin
public class TransactionReasonsController {

	
	@Autowired
	TransactionReasonsService transactionReasonsService;
	
	@GetMapping("/getAllTransactionReasons")
	public ResponseEntity<?> getAllTransactionReasons() {
		return ResponseEntity.ok(transactionReasonsService.findAllTransactionReasons());
	}
 	
	@PostMapping("/saveTransactionReasons")
	public ResponseEntity<?> saveTransactionReasons(@RequestBody TransactionReasonsVO transactionReasonsVO) {
		return ResponseEntity.ok(transactionReasonsService.saveTransactionReasons(transactionReasonsVO));
	}
	@PostMapping("/updateTransactionReasons")
	public ResponseEntity<?> updateTransactionReasons(@RequestBody TransactionReasonsVO transactionReasonsVO) {
		return ResponseEntity.ok(transactionReasonsService.updateTransactionReasons(transactionReasonsVO));
	}
	@PostMapping("/findbyTransactionReasonsId")
	public ResponseEntity<?> findbyTransactionReasonsId(@RequestBody Integer transactionReasonsId) {
		return ResponseEntity.ok(transactionReasonsService.findbyTransactionReasonsId(transactionReasonsId));
	}
	
	@DeleteMapping("/deleteByTransactionReasonsId")
	public ResponseEntity<?> deleteByTransactionReasonsId(@RequestBody Integer transactionReasonsId) {
		return ResponseEntity.ok(transactionReasonsService.deleteByTransactionReasonsId(transactionReasonsId));
	}
}
