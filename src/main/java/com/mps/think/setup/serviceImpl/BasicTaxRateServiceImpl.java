package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.repo.BasicTaxRateRepo;
import com.mps.think.setup.service.BasicTaxRateService;
import com.mps.think.setup.vo.BasicTaxRateVO;
@Service
public class BasicTaxRateServiceImpl implements BasicTaxRateService {
	
	@Autowired
	BasicTaxRateRepo basicTaxRateRepo;
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<BasicTaxRate> findAllbasicTaxRatebyId() {
		return basicTaxRateRepo.findAll();
	}
	
	@Override
	public BasicTaxRate findbasicTaxRatebyId(Integer id) {
		return basicTaxRateRepo.findById(id).get();
	}

	@Override
	public BasicTaxRate saveBasicTaxRate(BasicTaxRateVO basicTaxRateVo) {
		BasicTaxRate basicTaxRate = mapper.convertValue(basicTaxRateVo, BasicTaxRate.class);
		basicTaxRate = basicTaxRateRepo.saveAndFlush(basicTaxRate);
	    return basicTaxRate;
	}

	@Override
	public BasicTaxRate updateBasicTaxRate(BasicTaxRateVO basicTaxRateVo) {
		BasicTaxRate basicTaxRate = mapper.convertValue(basicTaxRateVo, BasicTaxRate.class);
		basicTaxRate = basicTaxRateRepo.saveAndFlush(basicTaxRate);
	    return basicTaxRate;
	}
}
