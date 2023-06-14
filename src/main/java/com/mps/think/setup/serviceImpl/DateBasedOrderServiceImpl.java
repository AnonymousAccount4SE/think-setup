package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.service.DateBasedOrderService;
import com.mps.think.setup.vo.DateBasedOrderVO;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.EnumModelVO.OrderType;
import com.mps.think.setup.vo.OrderKeyInformationVO;
import com.mps.think.setup.vo.OrderVO;

@Service
public class DateBasedOrderServiceImpl implements DateBasedOrderService {
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private AddOrderRepo orderRepo;
	
	@Autowired
	private AddOrderService orderService;
	
	@Override
	public DateBasedOrderVO saveDateBasedOrder(DateBasedOrderVO order) throws Exception {
//		Order dateBasedOrder = mapper.convertValue(order, Order.class);
//		dateBasedOrder.setOrderStatus(OrderStatus.Active);
//		dateBasedOrder.setOrderType(OrderType.DateBasedSubscriptionOrder.getDisplayName());
//		Order savedDateBasedOrder = orderRepo.saveAndFlush(dateBasedOrder);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		return mapper.convertValue(savedDateBasedOrder, DateBasedOrderVO.class);
		
		OrderVO generalOrder = mapper.convertValue(order, OrderVO.class);
		generalOrder.setOrderType(OrderType.DateBasedSubscriptionOrder.getDisplayName());
		generalOrder.setOrderStatus(OrderStatus.order_placed.getDisplayName());
		OrderKeyInformationVO keyOrderInformation = generalOrder.getKeyOrderInformation();
		keyOrderInformation.setOrderStatus(OrderStatus.order_placed.getDisplayName());
		generalOrder.setKeyOrderInformation(keyOrderInformation);
		Order savedOrder = orderService.saveOrder(generalOrder);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.convertValue(savedOrder, DateBasedOrderVO.class);
		
	}

	@Override
	public DateBasedOrderVO updateDateBasedOrder(DateBasedOrderVO order) throws Exception {
		Order generalOrder = mapper.convertValue(order, Order.class);
		generalOrder.setOrderType(OrderType.DateBasedSubscriptionOrder.getDisplayName());
		generalOrder.setOrderStatus(orderRepo.findById(order.getOrderId()).get().getOrderStatus());
		Order updatedOrder = orderService.updateOrder(generalOrder);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper.convertValue(updatedOrder, DateBasedOrderVO.class);
	}

	@Override
	public Page<Order> findAllDateBasedOrders(Integer publisherId, Integer customerId, Pageable page) {
		return orderRepo.findAllOrderOfGiveType(publisherId, customerId, OrderType.DateBasedSubscriptionOrder.getDisplayName(), page);
	}

}
