package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.WithdrawalDetails;
import com.mps.think.setup.repo.WithdrawalDetailsRepo;
import com.mps.think.setup.service.WithdrawalDetailsService;
import com.mps.think.setup.vo.WithdrawalDetailsVO;

@Service
public class WithdrawalDetailsServiceImpl implements WithdrawalDetailsService {

	@Autowired
	WithdrawalDetailsRepo withdrawalDetailsRepo;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public WithdrawalDetails saveWithdrawalDetails(WithdrawalDetailsVO withdrawalDetails) {
		WithdrawalDetails newEntry = mapper.convertValue(withdrawalDetails, WithdrawalDetails.class);
		return withdrawalDetailsRepo.saveAndFlush(newEntry);
	}

	@Override
	public WithdrawalDetails updateWithdrawalDetails(WithdrawalDetailsVO withdrawalDetails) {
		WithdrawalDetails entryToUpdate = mapper.convertValue(withdrawalDetails, WithdrawalDetails.class);
		return withdrawalDetailsRepo.saveAndFlush(entryToUpdate);
	}

	@Override
	public WithdrawalDetails findWithdrawalDetailsById(Integer id) {
		return withdrawalDetailsRepo.findById(id).get();
	}

	@Override
	public Page<WithdrawalDetails> findAllWithdrawalDetailsForPublisher(Integer pubId, Pageable page) {
		return withdrawalDetailsRepo.findByPublisherId(pubId, page);
	}

	@Override
	public WithdrawalDetails deleteWithdrawalDetails(Integer id) {
		WithdrawalDetails entryToDlt = findWithdrawalDetailsById(id);
		withdrawalDetailsRepo.delete(entryToDlt);
		return entryToDlt;
	}

	@Override
	public Page<WithdrawalDetails> findWithdrawalDetailsForCustomer(Integer customerId, Pageable page) {
		return withdrawalDetailsRepo.findByCustomerCustomerId(customerId, page);
	}

}
