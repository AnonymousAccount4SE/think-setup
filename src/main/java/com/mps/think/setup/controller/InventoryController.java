package com.mps.think.setup.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.service.InventoryService;
import com.mps.think.setup.vo.AdjustmentTypeVO;
import com.mps.think.setup.vo.InventoryMapperVO;
import com.mps.think.setup.vo.LocationAreaDetailsVO;
import com.mps.think.setup.vo.VendorDetailsVO;

@RestController
@CrossOrigin
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/getInventory")
	public ResponseEntity<?> getAllInventory(@RequestParam(required = true) Integer publisherId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(inventoryService.getAllInventory(publisherId, PageRequest.of(page, size)));
	}

	@GetMapping("/getInventoryById/{inventoryId}")
	public ResponseEntity<?> getInventoryById(@PathVariable Integer inventoryId) {
		return ResponseEntity.ok(inventoryService.getInventoryById(inventoryId));
	}

	@PostMapping("/saveInventory")
	public ResponseEntity<?> saveInventory(@Valid @RequestBody InventoryMapperVO inventory) {
		return ResponseEntity.ok(inventoryService.saveInventory(inventory));
	}

	@PutMapping("/updateInventory")
	public ResponseEntity<?> updateInventory(@Valid @RequestBody InventoryMapperVO inventory) {
		return ResponseEntity.ok(inventoryService.updateInventory(inventory));
	}

	@PostMapping("/createVendor")
	public ResponseEntity<?> createVendor(@Valid @RequestBody VendorDetailsVO vendor) {
		return ResponseEntity.ok(inventoryService.createVendor(vendor));
	}

	@PutMapping("/updateVendor")
	public ResponseEntity<?> updateVendor(@Valid @RequestBody VendorDetailsVO vendor) {
		return ResponseEntity.ok(inventoryService.updateVendor(vendor));
	}

	@GetMapping("/getVendor")
	public ResponseEntity<?> getVendor(@RequestParam(required = true) Integer publisherId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(inventoryService.getVendor(publisherId, PageRequest.of(page, size)));
	}

	@PostMapping("/createAdjustmentType")
	public ResponseEntity<?> createAdjustmentType(@Valid @RequestBody AdjustmentTypeVO type) {
		return ResponseEntity.ok(inventoryService.createAdjustmentType(type));
	}

	@PutMapping("/updateAdjustmentType")
	public ResponseEntity<?> updateAdjustmentType(@Valid @RequestBody AdjustmentTypeVO type) {
		return ResponseEntity.ok(inventoryService.updateAdjustmentType(type));
	}

	@GetMapping("/getAdjustmentTypes")
	public ResponseEntity<?> getAdjustmentTypes(@RequestParam(required = true) Integer publisherId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(inventoryService.getAdjustmentTypes(publisherId, PageRequest.of(page, size)));
	}

	@PostMapping("/createLocationArea")
	public ResponseEntity<?> createLocationArea(@Valid @RequestBody LocationAreaDetailsVO location) {
		return ResponseEntity.ok(inventoryService.createLocationArea(location));
	}

	@PutMapping("/updateLocationArea")
	public ResponseEntity<?> updateLocationArea(@Valid @RequestBody LocationAreaDetailsVO location) {
		return ResponseEntity.ok(inventoryService.updateLocationArea(location));
	}

	@GetMapping("/getLocationArea")
	public ResponseEntity<?> getLocationArea(@RequestParam(required = true) Integer publisherId,
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(inventoryService.getLocationArea(publisherId, PageRequest.of(page, size)));
	}

}
