package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.vo.OrderVO;

@Service
public class AddOrderServiceImpl implements AddOrderService {

	@Autowired
	private AddOrderRepo addOrderRepo;

	@Override
	public Order saveOrder(OrderVO order) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		Order newOrder = mapper.convertValue(order, Order.class);
		return addOrderRepo.saveAndFlush(newOrder);
	}

	@Override
	public List<Order> getAllOrders() throws Exception {
		return addOrderRepo.findAll();
	}

	@Override
	public Order getOrderById(Integer orderId) throws Exception {
		return addOrderRepo.findById(orderId).get();
	}

	@Override
	public List<Order> getAllOrderByCustomerId(Integer customerId) throws Exception {
//		return addOrderRepo.findAllByCustomerId(customerId);
		return addOrderRepo.findByCustomerIdCustomerId(customerId);
	}

	@Override
	public Order updateOrder(OrderVO order) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		return addOrderRepo.saveAndFlush(mapper.convertValue(order, Order.class));
	}

	@Override
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception {
		return addOrderRepo.findByOrderClassOcId(ocId);
	}

	@Override
	public Page<Order> getSearchedOrders(String keyword, Pageable page) {
		return addOrderRepo.findOrdersBySearch(keyword, page);
	}

}
