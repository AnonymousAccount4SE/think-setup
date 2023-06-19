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

import com.mps.think.setup.service.AddressService;
import com.mps.think.setup.vo.AddressesVO;
import com.mps.think.setup.vo.EnumModelVO.AddressCategory;
import com.mps.think.setup.vo.EnumModelVO.AddressType;
import com.mps.think.setup.vo.EnumModelVO.Frequency;
import com.mps.think.setup.vo.EnumModelVO.OrderType;
import com.mps.think.setup.vo.EnumModelVO.Status;

import net.minidev.json.JSONObject;

@RestController
@CrossOrigin
public class AddressesController {
	
	@Autowired
	AddressService addressService;
	
	@GetMapping("/getAllAddresses")
	public ResponseEntity<?> getAllAddresses() {
		return ResponseEntity.ok(addressService.getAllAddresses());
	}

	@PostMapping("/saveAddresses")
	public ResponseEntity<?> saveaddresses(@RequestBody AddressesVO addressId) {
		return ResponseEntity.ok(addressService.saveAddresses(addressId));
	}
	
	@PostMapping("/updateAddresses")
	public ResponseEntity<?> updateaddresses(@RequestBody AddressesVO addressId) {
		return ResponseEntity.ok(addressService.updateAddresses(addressId));
	}
	
	@PostMapping("/findbyAddressesId")
	public ResponseEntity<?> findbyAddressesId(@RequestBody Integer addressId) {
		return ResponseEntity.ok(addressService.findbyAddressesId(addressId));
	}
	
	@DeleteMapping("/deleteByAddressesId")
	public ResponseEntity<?> deleteByCancelReasonsId(@RequestBody Integer addressId) {
		return ResponseEntity.ok(addressService.deleteByAddressesId(addressId));
	}
	
	@GetMapping("/findAllAddressType")
	public ResponseEntity<?> getAllAddressType() {
		return ResponseEntity.ok(AddressType.values());
	}
	
	@GetMapping("/findAllAddressCategory")
	public ResponseEntity<?> getAllAddressCategory() {
		List<String> list= new ArrayList<>();
		for(AddressCategory data:AddressCategory.values()) {
			list.add(data.getDisplayName());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllFrequency")
	public ResponseEntity<?> getAllFrequency() {
		List<String> list= new ArrayList<>();
		for(Frequency data:Frequency.values()) {
			list.add(data.getDisplayName());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/findAllstatus")
	public ResponseEntity<?> getAllStatus() {
		return ResponseEntity.ok(Status.values());
	}
	
	@PostMapping("/updateGivenAddressesAsNonPrimary")
	public ResponseEntity<?> updateGivenAddressesNonPrimary(@RequestBody List<Integer> addressesIds) {
		JSONObject json = new JSONObject();
	    json.put("data", "updated");
		addressService.setGivenAddressesNonPrimary(addressesIds);
		return ResponseEntity.ok(json.toString());
	}
	
	@PostMapping("/updateSelectedAddressAsPrimary")
	public ResponseEntity<?> updateSelectedAddressAsPrimary(@RequestBody Integer id) {
		JSONObject json = new JSONObject();
	    json.put("data", "updated");
		addressService.updateSelectedAddressAsPrimary(id);
		return ResponseEntity.ok(json.toString());
	}
	
	@GetMapping("/getAllCustomercolumnsforaddress")
	public ResponseEntity<?> findAllColumnforAddresses() {
		return ResponseEntity.ok(addressService.findAllColumnforAddresses());
	}
	
//	@PostMapping("/updatePrimaryAddressbyCustId")
//	public ResponseEntity<?> updatePrimaryAddressbyCustId(Integer customerId, Integer addressId) {
//		return ResponseEntity.ok(addressService.updatePrimaryAddressbyCustId(customerId, addressId));
//	}
//	=============================================================================
	
//	@PostMapping("/findAllAddressesByCustomerId")
//	public ResponseEntity<?> findAllAddressesByCustId(@RequestBody Integer id) {
//		return ResponseEntity.ok(addressService.getAllAddressesByCustomerId(id));
//	}

}
