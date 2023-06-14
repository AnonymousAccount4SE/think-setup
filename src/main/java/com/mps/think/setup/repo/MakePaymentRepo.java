package com.mps.think.setup.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.MakePayment;
@Repository
public interface MakePaymentRepo extends JpaRepository<MakePayment, Integer>{
	
	List<MakePayment> findByPublisherId(Integer pubId);
	MakePayment findByOrderOrderId(Integer orderId);
	
	@Query("SELECT mp FROM MakePayment mp JOIN mp.order o JOIN o.paymentBreakdown p JOIN o.customerId ci WHERE (mp.publisher.id = :pubId OR :pubId IS NULL) AND "
			+ "(:paymentStartDate IS NULL OR DATE(mp.createdAt) >= :paymentStartDate) AND "
			+ "(:paymentEndDate IS NULL OR DATE(mp.createdAt) <= :paymentEndDate)")
	Page<MakePayment> findAllCreditCardDeclinedViewReport(
			@Param("pubId") Integer pubId,
			@Param("paymentStartDate") Date paymentStartDate,
			@Param("paymentEndDate") Date paymentEndDate, Pageable page);
	
	
	@Query("SELECT mp FROM MakePayment mp JOIN mp.order o JOIN o.paymentBreakdown p JOIN o.customerId ci WHERE (mp.publisher.id = :pubId OR :pubId IS NULL) AND "
			+ "(:paymentStartDate IS NULL OR DATE(mp.createdAt) >= :paymentStartDate) AND "
			+ "(:paymentEndDate IS NULL OR DATE(mp.createdAt) <= :paymentEndDate)")
	Page<MakePayment> findAllDailyCreditCardAndPaymentReport(
			@Param("pubId") Integer pubId, 
			@Param("paymentStartDate") Date paymentStartDate,
			@Param("paymentEndDate") Date paymentEndDate, Pageable page);
		
	

}
