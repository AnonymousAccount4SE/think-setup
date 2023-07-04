package com.mps.think.setup.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.repo.BasicTaxRateRepo;
import com.mps.think.setup.service.BasicTaxRateService;
import com.mps.think.setup.vo.BasicTaxRateVO;
@Service
public class BasicTaxRateServiceImpl implements BasicTaxRateService {
	
	@Autowired
	 private BasicTaxRateRepo basicTaxRateRepo;
	
	@Autowired
	private ObjectMapper mapper;


	@Override
	public BasicTaxRate findbasicTaxRatebyId(Integer id) {
		Optional<BasicTaxRate> jl = basicTaxRateRepo.findById(id);
		if (!jl.isPresent()) {
			throw new NotFoundException("BasicTaxRate Id : " + id + " does not exist!");
		}
		return jl.get();
	}


	@Override
	public BasicTaxRate saveBasicTaxRate(BasicTaxRateVO basicTaxRate) {
		// TODO Auto-generated method stub
		return basicTaxRateRepo.saveAndFlush(mapper.convertValue(basicTaxRate, BasicTaxRate.class));
	}

}
