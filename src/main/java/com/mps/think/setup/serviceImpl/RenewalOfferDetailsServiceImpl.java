package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.RenewalOfferDetails;
import com.mps.think.setup.repo.RenewalOfferDetailsRepo;
import com.mps.think.setup.service.RenewalOfferDetailsService;
import com.mps.think.setup.vo.RenewalOfferDetailsVO;

@Service
public class RenewalOfferDetailsServiceImpl implements RenewalOfferDetailsService {

	@Autowired
	RenewalOfferDetailsRepo offerDetailsRepo;

	@Autowired
	ObjectMapper mapper;

	@Override
	public List<RenewalOfferDetails> findAllRenewalOfferDetails() {
		return offerDetailsRepo.findAll();
	}

	@Override
	public RenewalOfferDetails saveRenewalOfferDetails(RenewalOfferDetailsVO renewalOfferDetailsVO) {
		return offerDetailsRepo.saveAndFlush(mapper.convertValue(renewalOfferDetailsVO, RenewalOfferDetails.class));
	}

	@Override
	public RenewalOfferDetails updateRenewalOfferDetails(RenewalOfferDetailsVO renewalOfferDetailsVO) {
		return offerDetailsRepo.saveAndFlush(mapper.convertValue(renewalOfferDetailsVO, RenewalOfferDetails.class));
	}

	@Override
	public RenewalOfferDetails deleteRenewalOfferDetails(Integer renewalOfferDetailsId) {
		RenewalOfferDetails details = offerDetailsRepo.findById(renewalOfferDetailsId).get();
		offerDetailsRepo.deleteById(renewalOfferDetailsId);
		return details;
	}

	@Override
	public RenewalOfferDetails findbyRenewalOfferDetailsId(Integer renewalOfferDetailsId) {
		Optional<RenewalOfferDetails> details = offerDetailsRepo.findById(renewalOfferDetailsId);
		return details.get();
	}

	@Override
	public List<RenewalOfferDetails> getAllRenewalOfferDetails() {
		return offerDetailsRepo.findAll();
	}

	@Override
	public Page<List<RenewalOfferDetails>> findAllRenewalOfferDetailsByAddRenewalsId(Integer id, Pageable page) {
		// TODO Auto-generated method stub
		return offerDetailsRepo.findByAddRenewalId(id, page);
	}

//	@Override
//	public Page<RenewalOfferDetails> findAllRenewalOfferDetailsByAddRenewalsId(Integer id, Pageable page) {
//		return offerDetailsRepo.findByAddRenewalId(id, page);
//	}

//	@Override
//	public List<RenewalOfferDetails> findAllRenewalOfferDetailsByAddRenewalsId(Integer id) {
//		return offerDetailsRepo.findByAddRenewalId(id);
//	}

}
