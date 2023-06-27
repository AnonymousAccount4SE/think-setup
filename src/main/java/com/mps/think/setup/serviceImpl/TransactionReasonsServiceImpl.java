package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.InstallmentPlan;
import com.mps.think.setup.model.TransactionReasons;
 import com.mps.think.setup.repo.TransactionReasonsRepo;
import com.mps.think.setup.service.TransactionReasonsService;
 import com.mps.think.setup.vo.TransactionReasonsVO;

 
@Service
public class TransactionReasonsServiceImpl implements TransactionReasonsService{

	@Autowired
	TransactionReasonsRepo transactionReasonsRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public List<TransactionReasons> findAllTransactionReasons() {
		List<TransactionReasons> transactionReasonsList = transactionReasonsRepo.findAll();
		if (transactionReasonsList.isEmpty()) {
			throw new NotFoundException("No Transaction Reason present!");
		}
		return transactionReasonsList;
		 
	}

	@Override
	public TransactionReasons saveTransactionReasons(TransactionReasonsVO transactionReasonsVO) {
		return 	transactionReasonsRepo.saveAndFlush(mapper.convertValue(transactionReasonsVO, TransactionReasons.class));
 	}

	@Override
	public TransactionReasons updateTransactionReasons(TransactionReasonsVO transactionReasonsVO) {
		ObjectMapper obj = new ObjectMapper();
		TransactionReasons transactionReasons = obj.convertValue(transactionReasonsVO, TransactionReasons.class);
		TransactionReasons addedTransactionReasons = transactionReasonsRepo.saveAndFlush(transactionReasons);
		return addedTransactionReasons;
	}

	@Override
	public TransactionReasons findbyTransactionReasonsId(Integer transactionReasonsId) {
		return transactionReasonsRepo.findById(transactionReasonsId).get();
	}

	@Override
	public TransactionReasons deleteByTransactionReasonsId(Integer transactionReasonsId) {
		TransactionReasons remove = transactionReasonsRepo.findById(transactionReasonsId).get();
		if (remove != null) {
			transactionReasonsRepo.delete(remove);
		}
		return remove;
	}

	@Override
	public List<TransactionReasons> getAllTransactionReasonsForPublisher(Integer pubId) {
		return transactionReasonsRepo.findTransactionReasonsByPublisherId(pubId);
	}
	
}
