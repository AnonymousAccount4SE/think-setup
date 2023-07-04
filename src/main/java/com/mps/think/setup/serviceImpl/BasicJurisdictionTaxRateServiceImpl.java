package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.service.JurisdictionsService;
import com.mps.think.setup.model.BasicJurisdictionTaxRate;
import com.mps.think.setup.model.Jurisdictions;
import com.mps.think.setup.repo.BasicJurisdictionTaxRateRepo;
import com.mps.think.setup.service.BasicJurisdictionTaxRateService;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;
@Service
public class BasicJurisdictionTaxRateServiceImpl implements BasicJurisdictionTaxRateService {

	@Autowired
	BasicJurisdictionTaxRateRepo basicJurisdictionTaxRateRepo;
	@Autowired
	JurisdictionsService JurisdictionsService;
	@Autowired
	private ObjectMapper mapper;
	


	@Override
	public BasicJurisdictionTaxRate findbasicJurisdictionTaxRatebyId(Integer id) {
		return basicJurisdictionTaxRateRepo.findById(id).get();
	}
	
	@Override
	public List<BasicJurisdictionTaxRate> findbasicJurisdictionTaxRateByPubId(Integer pubId) {
		List<BasicJurisdictionTaxRate> basicJurisdictionTaxRate = new ArrayList<BasicJurisdictionTaxRate>();
		List<Jurisdictions> jurisdictions = JurisdictionsService.findAllJurisdictionsForPublisher(pubId);
		for(Jurisdictions data : jurisdictions) {
			data.getId();
			BasicJurisdictionTaxRate basicJurisdiction = basicJurisdictionTaxRateRepo.findByjurisdictionsId(data.getId());
			basicJurisdictionTaxRate.add(basicJurisdiction);
		}
		
		return basicJurisdictionTaxRate;
	}

	@Override
	public BasicJurisdictionTaxRate savebasicJurisdictionTaxRate(BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		return basicJurisdictionTaxRateRepo.saveAndFlush(mapper.convertValue(basicJurisdictionTaxRateVO, BasicJurisdictionTaxRate.class));
	}

	@Override
	public BasicJurisdictionTaxRate updatebasicJurisdictionTaxRate(
			BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		BasicJurisdictionTaxRate newBasicJurisdictionTaxRate = mapper.convertValue(basicJurisdictionTaxRateVO, BasicJurisdictionTaxRate.class);
		newBasicJurisdictionTaxRate = basicJurisdictionTaxRateRepo.saveAndFlush(newBasicJurisdictionTaxRate);
	    return newBasicJurisdictionTaxRate;
	}

}
