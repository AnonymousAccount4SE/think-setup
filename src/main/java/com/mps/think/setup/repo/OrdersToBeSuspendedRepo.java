package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.OrdersToBeSuspended;

@Repository
public interface OrdersToBeSuspendedRepo extends JpaRepository<OrdersToBeSuspended, Integer> {
	
	@Query("SELECT o.order, s FROM SuspendOrder s JOIN s.ordersToSuspend o WHERE o.isReinstated IS FALSE AND o.isSuspended IS FALSE")
	List<Object[]> findAllNonSuspendedAndNonReinstatedOrders();
	
	@Query("SELECT o.order, s FROM SuspendOrder s JOIN s.ordersToSuspend o WHERE o.isReinstated IS FALSE AND o.isSuspended IS TRUE")
	List<Object[]> findAllSuspendedAndNonReinstatedOrders();
	
	@Query(value = "SELECT * FROM orders_to_be_suspended o WHERE o.order_id = :orderId AND o.suspend_order_id = :suspendId", nativeQuery = true)
	OrdersToBeSuspended getOrdersToBeSuspendedForGivenOrderAndSuspendDetails(@Param("orderId") Integer orderId, 
			@Param("suspendId") Integer suspendId);
	
	@Query(value = "SELECT * FROM orders_to_be_suspended o WHERE o.order_id = :orderId AND o.is_reinstated IS FALSE AND o.is_suspended IS "
			+ "TRUE ORDER BY o.suspend_order_id DESC",
			nativeQuery = true)
	List<OrdersToBeSuspended> findPreviousSuspensionDetailsOfOrder(@Param("orderId") Integer orderId);
	
	@Query(value = "SELECT o.order_id, o.suspend_order_id FROM orders_to_be_suspended o JOIN multi_line_item_order m ON o.order_id = m.order_id WHERE m.parent_order_id = :parentOrderId",
			countQuery = "SELECT COUNT(*) FROM orders_to_be_suspended o JOIN multi_line_item_order m ON o.order_id = m.order_id WHERE m.parent_order_id = :parentOrderId",
			nativeQuery = true)
	Page<Object[]> findOrdersToReinstateForOrderId(@Param("parentOrderId") Integer parentOrderId, Pageable page);
	
}
