package com.mps.think.setup.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.MultiLineItemOrder;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.model.OrderAuxiliaryInformation;
import com.mps.think.setup.model.OrderCategory;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.vo.EnumModelVO.OrderStatus;
import com.mps.think.setup.vo.OrderSuspendView;
import com.mps.think.setup.model.OrderDeliveryOptions;
import com.mps.think.setup.model.OrderItems;
import com.mps.think.setup.model.OrderKeyInformation;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.vo.OrderVO;

@Service
public interface AddOrderService {
	
	public List<String> findAllColumnForOrders();
	
	public Order saveOrder(OrderVO order) throws Exception;
	public Page<Order> getAllOrders(Pageable page) throws Exception;
	public Order getOrderById(Integer orderId) throws Exception;
	public Page<Order> getAllOrderByCustomerId(Integer customerId, Pageable page) throws Exception;
	public List<Order> getAllOrderByCustomerIdAndOrderId(Integer customerId,Integer orderId) throws Exception;
	public Order updateOrder(Order order) throws Exception;
	public List<Order> getAllOrdersByOrderClassId(Integer ocId) throws Exception;
	
	public Page<Order> getAllorderForPublisher(Pageable page,Integer pubId) throws Exception;

	public Page<Order> getSearchedOrders(Integer pubId, Integer customerId, String keyword, Pageable page);
	
	List<OrderCodesSuper> getRecentTwoOrderOfCustomer(Integer customerId) throws Exception;
	
	void setAllOrdersOfCustomerInActive(Integer customerId);
	
//	List<Order> getOrdersById(Integer id);
	
	Page<Order> getOrdersById(Integer id, Pageable page);
	
	Order getSubOrderById(Integer id);
	public List<Order> getAllOrder();
	public List<OrderCategory> getAllOrderCategory();
	public List<OrderAddressMapping> getAllOrderAddressMapping();
	public List<OrderAuxiliaryInformation> getAllOrderAuxiliaryInformation();
	public List<OrderDeliveryOptions> getAllOrderDeliveryOptions();
	public List<OrderItems> getAllOrderItems();
	public List<OrderKeyInformation> getAllOrderKeyInformation();
	public List<PaymentBreakdown> getAllPaymentBreakdown();
	public List<MultiLineItemOrder> getAllMultiLineItemOrder();
	
	List<Order> updateOrderPaymentStatus(LinkedHashMap<String, String> OrderPaymentStatus);
	
	List<Order> updateOrderStatus(LinkedHashMap<String, String> OrderStatus);

	public void makeAddressOrderNonDeliverable(Integer addressId);
	
	Page<Order> getAllNonRenewedOrders(Integer pubId, Integer customerId, Integer orderId, Pageable page);
	
	Page<Order> getAllOrderForPayAnotherOrder(Integer pubId, Integer customerId, Integer orderId, Pageable page);
	
}
