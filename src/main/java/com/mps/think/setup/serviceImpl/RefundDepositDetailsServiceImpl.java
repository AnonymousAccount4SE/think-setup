package com.mps.think.setup.serviceImpl;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RefundDepositDetails;
import com.mps.think.setup.repo.RefundDepositDetailsRepo;
import com.mps.think.setup.service.RefundDepositDetailsService;
import com.mps.think.setup.vo.RefundDepositDetailsVO;

@Service
public class RefundDepositDetailsServiceImpl implements RefundDepositDetailsService {

	@Autowired
	RefundDepositDetailsRepo refundDepositDetailsRepo;
	
	@Autowired
	ObjectMapper mapper;
	
	@Override
	public RefundDepositDetails saveRefundDepositDetails(RefundDepositDetailsVO refundDepositDetailsService) {
		RefundDepositDetails detailsToSave = mapper.convertValue(refundDepositDetailsService, RefundDepositDetails.class);
		detailsToSave.setSequence(refundDepositDetailsRepo.getAllRefundDepositDetailsCount(refundDepositDetailsService.getCustomer().getCustomerId()) + 1);
		return refundDepositDetailsRepo.saveAndFlush(detailsToSave);
	}

	@Override
	public RefundDepositDetails updateRefundDepositDetails(RefundDepositDetailsVO refundDepositDetailsService) {
		RefundDepositDetails detailsToUpdate = mapper.convertValue(refundDepositDetailsService, RefundDepositDetails.class);
		detailsToUpdate.setSequence(refundDepositDetailsRepo.findById(refundDepositDetailsService.getId()).get().getSequence());
		return refundDepositDetailsRepo.saveAndFlush(detailsToUpdate);
	}

	@Override
	public RefundDepositDetails findRefundDepositDetailsById(Integer id) throws RuntimeException {
		Optional<RefundDepositDetails> detail = refundDepositDetailsRepo.findById(id);
		if (detail.isPresent()) return detail.get();
		throw new EntityNotFoundException();
	}

	@Override
	public Page<RefundDepositDetails> findAllDepositDetails(Integer pubId, Pageable page) {
		return refundDepositDetailsRepo.findByPublisherId(pubId, page);
	}

	@Override
	public RefundDepositDetails deleteRefundDepositDetails(Integer id) {
		RefundDepositDetails detailsToDlt = findRefundDepositDetailsById(id);
		if (detailsToDlt != null) refundDepositDetailsRepo.delete(detailsToDlt);
		return detailsToDlt;
	}

	@Override
	public Page<RefundDepositDetails> findAllRefundDepositDetailsForCustomer(Integer customerId, Pageable page) {
		return refundDepositDetailsRepo.findByCustomerCustomerId(customerId, page);
	}


}
