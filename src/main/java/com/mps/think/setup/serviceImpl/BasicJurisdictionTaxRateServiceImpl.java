package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.BasicJurisdictionTaxRate;
import com.mps.think.setup.repo.BasicJurisdictionTaxRateRepo;
import com.mps.think.setup.service.BasicJurisdictionTaxRateService;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;
@Service
public class BasicJurisdictionTaxRateServiceImpl implements BasicJurisdictionTaxRateService {

	@Autowired
	BasicJurisdictionTaxRateRepo basicJurisdictionTaxRateRepo;
	@Autowired
	private ObjectMapper mapper;
	


	@Override
	public BasicJurisdictionTaxRate findbasicJurisdictionTaxRatebyId(Integer id) {
		return basicJurisdictionTaxRateRepo.findById(id).get();
	}
	
	@Override
	public List<BasicJurisdictionTaxRate> findbasicJurisdictionTaxRateByPubId(Integer pubId) {
		return basicJurisdictionTaxRateRepo.findbasicJurisdictionTaxRateByPubId(pubId);
	}

	@Override
	public BasicJurisdictionTaxRate savebasicJurisdictionTaxRate(BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO) {
		return basicJurisdictionTaxRateRepo.saveAndFlush(mapper.convertValue(basicJurisdictionTaxRateVO, BasicJurisdictionTaxRate.class));
	}

}
