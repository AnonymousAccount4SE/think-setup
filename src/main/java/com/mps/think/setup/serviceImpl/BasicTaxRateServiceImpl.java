package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.repo.BasicTaxRateRepo;
import com.mps.think.setup.service.BasicTaxRateService;
import com.mps.think.setup.vo.BasicTaxRateVO;
@Service
public class BasicTaxRateServiceImpl implements BasicTaxRateService {
	
	@Autowired
	BasicTaxRateRepo basicTaxRateRepo;

	@Override
	public BasicTaxRate findbasicTaxRatebyId(Integer id) {
		return basicTaxRateRepo.findById(id).get();
	}

	@Override
	public BasicTaxRate saveBasicTaxRate(BasicTaxRateVO basicTaxRate) {
		return null;
		// TODO Auto-generated method stub
//		return basicTaxRateRepo.save(basicTaxRate);
	}

}
