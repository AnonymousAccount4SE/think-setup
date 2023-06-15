package com.mps.think.setup.serviceImpl;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.MultiLineItemOrder;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.model.OrderAuxiliaryInformation;
import com.mps.think.setup.model.OrderCategory;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.model.OrderDeliveryOptions;
import com.mps.think.setup.model.OrderItemDetails;
import com.mps.think.setup.model.OrderItems;
import com.mps.think.setup.model.OrderKeyInformation;
import com.mps.think.setup.model.OrderPaymentOptions;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.MultiLineItemOrderRepo;
import com.mps.think.setup.repo.OrdersToBeSuspendedRepo;
import com.mps.think.setup.repo.SuspendOrderRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.utils.Pair;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.vo.OrderVO;

@Service
public class AddOrderServiceImpl implements AddOrderService {

	@Autowired
	private AddOrderRepo addOrderRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private MultiLineItemOrderRepo multiLineOrderRepo;
	
	@Autowired
	OrdersToBeSuspendedRepo ordersToSuspendRepo;
	
	@Autowired
	SuspendOrderRepo suspendedOrderRepo;

	@Override
	public Order saveOrder(OrderVO order) throws Exception {
		Order newOrder = mapper.convertValue(order, Order.class);
		if (order.getOtherAddressCustomer() == null || order.getOtherAddressCustomer().getCustomerId() == 0) newOrder.setOtherAddressCustomer(null);
		Order createdOrder = addOrderRepo.saveAndFlush(newOrder);
		MultiLineItemOrder orderSibling = multiLineOrderRepo.findByOrderOrderId(createdOrder.getOrderId());
		if (order.getParentOrder() == null || order.getParentOrder().getParentOrderId() == 0) {
			orderSibling.setParentOrderId(createdOrder.getOrderId());
			multiLineOrderRepo.saveAndFlush(orderSibling);
		} else {
			MultiLineItemOrder mainParent = multiLineOrderRepo.findByOrderOrderId(order.getParentOrder().getParentOrderId());
			orderSibling.setParentOrderId(mainParent.getParentOrderId());
			multiLineOrderRepo.saveAndFlush(orderSibling);
		}
		return createdOrder;
	}

	@Override
	public Page<Order> getAllOrders(Pageable page) throws Exception {
		return addOrderRepo.findAll(page);
	}

	@Override
	public Order getOrderById(Integer orderId) throws Exception {
		return addOrderRepo.findById(orderId).get();
	}

	@Override
	public Page<Order> getAllOrderByCustomerId(Integer customerId, Pageable page) throws Exception {
//		return addOrderRepo.findAllByCustomerId(customerId);
		return addOrderRepo.findByCustomerIdCustomerId(customerId, page);
	}

	@Override
	public Order updateOrder(Order order) throws Exception {
//		ObjectMapper mapper = new ObjectMapper();
		Order updateOrder = mapper.convertValue(order, Order.class);
		if (order.getOtherAddressCustomer() == null || order.getOtherAddressCustomer().getCustomerId() == 0) updateOrder.setOtherAddressCustomer(null);	
		Integer parentOrderId = order.getParentOrder().getParentOrderId();
		MultiLineItemOrder currentParent = multiLineOrderRepo.findByOrderOrderId(order.getOrderId());
		if (parentOrderId <= 0 || currentParent.getParentOrderId().equals(currentParent.getOrder().getOrderId())) {
			updateOrder.setParentOrder(currentParent);
		} else {
			currentParent.setParentOrderId(parentOrderId);
			updateOrder.setParentOrder(currentParent);
		}
		updateOrder.setParentOrder(multiLineOrderRepo.findByOrderOrderId(order.getOrderId()));
		return addOrderRepo.saveAndFlush(updateOrder);
	}

	@Override
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception {
		return addOrderRepo.findByOrderClassOcId(ocId);
	}

	@Override
	public Page<Order> getSearchedOrders(Integer pubId, Integer customerId, String keyword, Pageable page) {
		return addOrderRepo.findOrdersBySearch(pubId.equals(0) ? null : pubId, customerId, keyword, page);
	}

	@Override
	public List<OrderCodesSuper> getRecentTwoOrderOfCustomer(Integer customerId) throws Exception {		
		return addOrderRepo.fetchRecentTwoOrderByCustomerId(customerId).stream().map(o -> o.getKeyOrderInformation().getOrderCode()).collect(Collectors.toList());
	}

	@Override
	public Page<Order> getAllorderForPublisher(Pageable page,Integer pubId) throws Exception {
		return addOrderRepo.findAllByCustomerIdPublisherId(page,pubId);
	}

	@Override
	public void setAllOrdersOfCustomerInActive(Integer customerId) {
		List<Order> orders = addOrderRepo.findByCustomerIdCustomerId(customerId);
		orders.forEach(o -> {
			o.setOrderStatus(OrderStatus.cancel_for_nonpayment.getDisplayName());
		});
		addOrderRepo.saveAllAndFlush(orders);
	}

	public Page<Order> getOrdersById(Integer id, Pageable page) {
		return multiLineOrderRepo.findOrdersByParentOrderId(addOrderRepo.findById(id).get().getParentOrder().getParentOrderId(), page);
	}

	@Override
	public Order getSubOrderById(Integer id) {
		Optional<Order> order = addOrderRepo.findById(id);
		if (order.isPresent()) return order.get();
		return null;
	}

	@Override
	public List<Order> getAllOrderByCustomerIdAndOrderId(Integer customerId, Integer orderId) throws Exception {
		return addOrderRepo.fetchOrdersForPaymentsByCustomerIdPrioGivenOrderId(customerId, orderId);
	}

	@Override
	public List<Order> getAllOrder() {
		return addOrderRepo.findAll();
	}

	@Override
	public List<OrderCategory> getAllOrderCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderAddressMapping> getAllOrderAddressMapping() {
		List<List<OrderAddressMapping>> orderAddressMapping = addOrderRepo.findAll().stream().map(a -> a.getOrderAddresses()).collect(Collectors.toList());
		List<OrderAddressMapping> output = new ArrayList<>();
		for (List<OrderAddressMapping> s : orderAddressMapping) {
			output.addAll(s);
		}
		return output;
	}

	@Override
	public List<OrderAuxiliaryInformation> getAllOrderAuxiliaryInformation() {
List<OrderAuxiliaryInformation> orderAuxiliaryInformation = addOrderRepo.findAll().stream().map(m -> m.getAuxiliaryInformation()).collect(Collectors.toList());
		
		return orderAuxiliaryInformation;
	}

	@Override
	public List<OrderDeliveryOptions> getAllOrderDeliveryOptions() {
List<OrderDeliveryOptions> orderDeliveryOptions = addOrderRepo.findAll().stream().map(m -> m.getDeliveryAndBillingOptions()).collect(Collectors.toList());
		
		return orderDeliveryOptions;
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
List<OrderItems> orderItems = addOrderRepo.findAll().stream().map(m -> m.getOrderItemsAndTerms()).collect(Collectors.toList());
		
		return orderItems;
	}

	@Override
	public List<OrderKeyInformation> getAllOrderKeyInformation() {
		List<OrderKeyInformation> orderKeyInformation = addOrderRepo.findAll().stream().map(m -> m.getKeyOrderInformation()).collect(Collectors.toList());
		
		return orderKeyInformation;
	}

	@Override
	public List<PaymentBreakdown> getAllPaymentBreakdown() {
		 List<PaymentBreakdown> paymentBreakdown = addOrderRepo.findAll().stream().map(m -> m.getPaymentBreakdown()).collect(Collectors.toList());
			
			return paymentBreakdown;
	}

	@Override
	public List<MultiLineItemOrder> getAllMultiLineItemOrder() {
		 List<MultiLineItemOrder> multiLineItemOrder = addOrderRepo.findAll().stream().map(m -> m.getParentOrder()).collect(Collectors.toList());
			
			return multiLineItemOrder;
	}

	
	@Override
	public List<Order> updateOrderPaymentStatus(LinkedHashMap<String, String> OrderPaymentStatus) {
	    List<Order> updatedOrders = new ArrayList<>();
	    
	    for (Map.Entry<String, String> entry : OrderPaymentStatus.entrySet()) {
	    	String orderId = entry.getKey();
	        String paymentStatus = entry.getValue();

	        Order order = addOrderRepo.findById(Integer.valueOf(orderId)).orElse(null);
	        
	        if (order != null) {
	            PaymentBreakdown paymentBreakdown = order.getPaymentBreakdown();
	            paymentBreakdown.setPaymentStatus(paymentStatus);
	            
	            Order updatedOrder = addOrderRepo.save(order);
	            updatedOrders.add(updatedOrder);
	        }
	    }
	    
	    return updatedOrders;
	}

	@Override
	public List<Order> updateOrderStatus(LinkedHashMap<String, String> OrderStatus) {

		 List<Order> updatedOrders = new ArrayList<>();
		    
		    for (Map.Entry<String, String> entry : OrderStatus.entrySet()) {
		    	String orderId = entry.getKey();
		    	String odrStatus = entry.getValue();

		        Order order = addOrderRepo.findById(Integer.valueOf(orderId)).orElse(null);
		        
		        if (order != null) {
//		            OrderStatus odStatus = order.getOrderStatus();
		            order.setOrderStatus(odrStatus);
		            
		            Order updatedOrder = addOrderRepo.save(order);
		            updatedOrders.add(updatedOrder);
		        }
		    }
		    
		    return updatedOrders;
	}
  
//	public List<Order> updateOrderPaymentStatus(LinkedHashMap<String, String> OrderPaymentStatus) {
//	    List<Order> updatedOrders = new ArrayList<>();
//	    
//	    for (Map.Entry<String, String> entry : OrderPaymentStatus.entrySet()) {
//	        String orderId = entry.getKey();
//	        String paymentStatus = entry.getValue();
//
//	        try {
//	            int orderIdInt = Integer.parseInt(orderId);
//	            Order order = addOrderRepo.findById(orderIdInt).orElse(null);
//
//	            if (order != null) {
//	                PaymentBreakdown paymentBreakdown = order.getPaymentBreakdown();
//	                paymentBreakdown.setPaymentStatus(paymentStatus);
//
//	                Order updatedOrder = addOrderRepo.save(order);
//	                updatedOrders.add(updatedOrder);
//	            }
//	        } catch (NumberFormatException e) {
//	            // Handle the case where the orderId cannot be parsed to an integer
//	            // You can log an error, throw an exception, or perform appropriate error handling
//	            // For now, we skip the current iteration of the loop
//	            continue;
//	        }
//	    }
//	    
//	    return updatedOrders;
//	}

}
