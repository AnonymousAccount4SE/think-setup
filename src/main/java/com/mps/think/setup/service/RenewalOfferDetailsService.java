package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.RenewalOfferDetails;
import com.mps.think.setup.vo.RenewalOfferDetailsVO;

public interface RenewalOfferDetailsService {
	
	public List<RenewalOfferDetails> findAllRenewalOfferDetails();

	public RenewalOfferDetails saveRenewalOfferDetails(RenewalOfferDetailsVO renewalOfferDetailsVO);

	public RenewalOfferDetails updateRenewalOfferDetails(RenewalOfferDetailsVO renewalOfferDetailsVO);
	
	public RenewalOfferDetails deleteRenewalOfferDetails(Integer renewalOfferDetailsId);

	public RenewalOfferDetails findbyRenewalOfferDetailsId(Integer renewalOfferDetailsId);

	public List<RenewalOfferDetails> getAllRenewalOfferDetails();
	
	public List<RenewalOfferDetails> findAllRenewalOfferDetailsByAddRenewalsId(Integer id);

}
