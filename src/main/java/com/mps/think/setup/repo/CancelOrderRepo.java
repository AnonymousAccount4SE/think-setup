package com.mps.think.setup.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.CancelOrder;
import com.mps.think.setup.model.Order;

@Repository
public interface CancelOrderRepo extends JpaRepository<CancelOrder ,Integer> {
	
	List<CancelOrder> findByOrderidOrderId(Integer id);
	
	@Query("SELECT c FROM CancelOrder c JOIN c.orderid o JOIN o.paymentBreakdown p WHERE o.orderType LIKE :orderType AND "
			+ "(:currencyType IS NULL OR p.currency = :currencyType) "
			+ "AND (:ordersFrom IS NULL OR c.date >= :ordersFrom) AND "
			+ "(:ordersTill IS NULL OR c.date <= :ordersTill)")
	public Page<CancelOrder> findAllCancelledSubscriptions(
			  @Param("ordersFrom") Date ordersFrom, 
			  @Param("ordersTill") Date ordersTill, 
			  @Param("currencyType") String currencyType, String orderType, Pageable page);	  

}
