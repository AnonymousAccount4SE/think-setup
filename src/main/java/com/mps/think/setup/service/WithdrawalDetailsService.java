package com.mps.think.setup.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.WithdrawalDetails;
import com.mps.think.setup.vo.WithdrawalDetailsVO;

public interface WithdrawalDetailsService {

	WithdrawalDetails saveWithdrawalDetails(WithdrawalDetailsVO withdrawalDetails);
	
	WithdrawalDetails updateWithdrawalDetails(WithdrawalDetailsVO withdrawalDetails);
	
	WithdrawalDetails findWithdrawalDetailsById(Integer id);
	
	Page<WithdrawalDetails> findAllWithdrawalDetailsForPublisher(Integer pubId, Pageable page);
	
	Page<WithdrawalDetails> findWithdrawalDetailsForCustomer(Integer customerId, Pageable page);
	
	WithdrawalDetails deleteWithdrawalDetails(Integer id);
	
}
