package com.mps.think.setup.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.EnumModelVO.OrderType;
import com.mps.think.setup.vo.EnumModelVO.PaymentStatus;
import com.mps.think.setup.vo.OrderVO;

@RestController
@CrossOrigin
public class AddOrderController {
	
	@Autowired
	private AddOrderService addOrderService;
	
	@GetMapping("/getAllCustomercolumnsOrders")
	public ResponseEntity<?> findAllColumnForOrders() {
		return ResponseEntity.ok(addOrderService.findAllColumnForOrders());
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@RequestBody OrderVO order) throws Exception {
		return ResponseEntity.ok(addOrderService.saveOrder(order));
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<?> updateOrder(@RequestBody Order order) throws Exception {
		return ResponseEntity.ok(addOrderService.updateOrder(order));
	}
	
	@PutMapping("/updateOrderPaymentStatus")
	public ResponseEntity<?> updateOrderPaymentStatus(@RequestParam LinkedHashMap<String, String> OrderPaymentStatus) throws Exception {
		return ResponseEntity.ok(addOrderService.updateOrderPaymentStatus(OrderPaymentStatus));
	}
	
	@PutMapping("/updateOrderStatus")
	public ResponseEntity<?> updateOrderStatus(@RequestParam LinkedHashMap<String, String> OrderStatus) throws Exception {
		return ResponseEntity.ok(addOrderService.updateOrderStatus(OrderStatus));
	}
	
	@GetMapping("/getAllOrders")
	public ResponseEntity<?> getAllOrders(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity.ok(addOrderService.getAllOrders(PageRequest.of(page, size, Sort.by("orderId").descending())));
	}
	
	@GetMapping("/getOrderById/{orderId}")
	public ResponseEntity<?> getOrderById(@PathVariable Integer orderId, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity.ok(addOrderService.getOrdersById(orderId, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getAllOrderByCustomerId/{customerId}")
	public ResponseEntity<?> getAllOrderByCustomerId(@PathVariable Integer customerId, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) throws Exception {
		return ResponseEntity.ok(addOrderService.getAllOrderByCustomerId(customerId, PageRequest.of(page, size, Sort.by("orderId").descending())));
	}
	
	@GetMapping("/getAllOrderByCustomerIdandOrderId/{customerId}{orderId}")
	public ResponseEntity<?> getAllOrderByCustomerId(@RequestParam(required = true) Integer customerId, @RequestParam(required = true) Integer orderId) throws Exception {
		return ResponseEntity.ok(addOrderService.getAllOrderByCustomerIdAndOrderId(customerId,orderId));
	}
	
	@GetMapping("/findAllPaymentStatus")
	public ResponseEntity<?> getAllPaymentStatus() {
		return ResponseEntity.ok(PaymentStatus.values());
	}
	
	@GetMapping("/findAllOrderStatus")
	public ResponseEntity<?> getAllOrderStatus() {
		return ResponseEntity.ok(OrderStatus.values());
	}
	
	@GetMapping("/findAllOrderType")
	public ResponseEntity<?> getAllOrderType() {
		List<String> list= new ArrayList<>();
		for(OrderType data:OrderType.values()) {
			list.add(data.getDisplayName());
		}
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getAllOrdersByOrderClassId/{ocIc}")
	public ResponseEntity<?> getAllOrdersByOrderClassId(@PathVariable("ocIc") Integer ocIc) throws Exception {
		return ResponseEntity.ok(addOrderService.getAllOrdersByOrderClassId(ocIc));
	}
	
	@GetMapping("/searchOrders")
	public ResponseEntity<?> getAllOrdersFromSearch(@RequestParam(required = true) Integer pubId, @RequestParam(required = false) Integer customerId, @RequestParam(required = false) String keyword, @RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(addOrderService.getSearchedOrders(pubId, customerId, keyword, PageRequest.of(page, size)));
	}
	
	@GetMapping("/getRecentTwoOrderCodesOfCustomer/{customerId}")
	public ResponseEntity<?> getRecentTwoOrderOfCustomer(@PathVariable("customerId") Integer customerId) throws Exception {
		return ResponseEntity.ok(addOrderService.getRecentTwoOrderOfCustomer(customerId));
	}
	
	@PostMapping("/getAllorderForPublisher")
	public ResponseEntity<?> getAllorderForPublisher(@RequestParam(defaultValue = "0") Integer page,
			@RequestParam(defaultValue = "5") Integer size , @RequestParam Integer pubId) throws Exception {
		return ResponseEntity.ok(addOrderService.getAllorderForPublisher(PageRequest.of(page, size, Sort.by("orderId").descending()), pubId));
	}
	
	@GetMapping("/getSubOrderById/{orderId}")
	public ResponseEntity<?> getSubOrderById(@PathVariable("orderId") Integer orderId) {
		return ResponseEntity.ok(addOrderService.getSubOrderById(orderId));
	}
	
	@GetMapping("/getAllOrdersToRenewed")
	public ResponseEntity<?> getAllOrdersToRenewed(@RequestParam(required = true) Integer pubId, @RequestParam(required = false) Integer customerId, 
			@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		return ResponseEntity.ok(addOrderService.getAllNonRenewedOrders(pubId, customerId, PageRequest.of(page, size)));
	}

}
