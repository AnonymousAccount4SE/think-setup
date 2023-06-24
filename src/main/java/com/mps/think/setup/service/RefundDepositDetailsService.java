package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.RefundDepositDetails;
import com.mps.think.setup.vo.RefundDepositDetailsVO;

public interface RefundDepositDetailsService {

	RefundDepositDetails saveRefundDepositDetails(RefundDepositDetailsVO refundDepositDetailsService);
	
	RefundDepositDetails updateRefundDepositDetails(RefundDepositDetailsVO refundDepositDetailsService);
	
	RefundDepositDetails findRefundDepositDetailsById(Integer id) throws RuntimeException;
	
	Page<RefundDepositDetails> findAllDepositDetails(Integer pubId, Pageable page);
	
	Page<RefundDepositDetails> findAllRefundDepositDetailsForCustomer(Integer customerId, Pageable page);
	
	RefundDepositDetails deleteRefundDepositDetails(Integer id);
	
}
