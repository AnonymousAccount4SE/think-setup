package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.repo.BasicTaxRateRepo;
import com.mps.think.setup.service.BasicTaxRateService;
@Service
public class BasicTaxRateServiceImpl implements BasicTaxRateService {
	
	@Autowired
	BasicTaxRateRepo basicTaxRateRepo;

	@Override
	public BasicTaxRate findbasicTaxRatebyId(Integer id) {
		return basicTaxRateRepo.findById(id).get();
		
	}

}
