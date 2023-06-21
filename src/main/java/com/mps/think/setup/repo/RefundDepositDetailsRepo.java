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
	
}
