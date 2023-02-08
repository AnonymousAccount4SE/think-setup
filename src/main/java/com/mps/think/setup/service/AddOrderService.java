package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.vo.OrderVO;

@Service
public interface AddOrderService {
	
	public Order saveOrder(OrderVO order) throws Exception;
	public List<Order> getAllOrders() throws Exception;
	public Order getOrderById(Integer orderId) throws Exception;
	public List<Order> getAllOrderByCustomerId(Integer customerId) throws Exception;
	public Order updateOrder(OrderVO order) throws Exception;
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception;

	public Page<Order> getSearchedOrders(String keyword, Pageable page);
	
}
