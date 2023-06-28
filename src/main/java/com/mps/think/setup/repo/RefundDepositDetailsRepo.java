package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RefundDepositDetails;

@Repository
public interface RefundDepositDetailsRepo extends JpaRepository<RefundDepositDetails, Integer> {

	@Query(value = "SELECT COUNT(*) FROM refund_deposite_details WHERE customer_id = :customerId", nativeQuery = true)
	Integer getAllRefundDepositDetailsCount(@Param("customerId") Integer customerId);
	
	Page<RefundDepositDetails> findByPublisherId(Integer pubId, Pageable page);
	
	Page<RefundDepositDetails> findByCustomerCustomerId(Integer customerId, Pageable page);
	
	@Query(value = "SELECT * FROM refund_deposite_details r WHERE r.customer_id = :customerId ORDER BY r.sequence DESC LIMIT 1", nativeQuery = true)
	RefundDepositDetails getRecentRefundDepositDetails(@Param("customerId") Integer customerId);
	
}
