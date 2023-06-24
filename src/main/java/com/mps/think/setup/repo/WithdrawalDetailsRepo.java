package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.WithdrawalDetails;

@Repository
public interface WithdrawalDetailsRepo extends JpaRepository<WithdrawalDetails, Integer> {

	Page<WithdrawalDetails> findByPublisherId(Integer id, Pageable page);
	
	Page<WithdrawalDetails> findByCustomerCustomerId(Integer customerId, Pageable page);
	
}
