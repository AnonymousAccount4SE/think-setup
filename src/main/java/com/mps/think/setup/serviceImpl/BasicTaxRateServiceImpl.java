package com.mps.think.setup.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.repo.BasicTaxRateRepo;
import com.mps.think.setup.service.BasicTaxRateService;
@Service
public class BasicTaxRateServiceImpl implements BasicTaxRateService {
	
	@Autowired
	BasicTaxRateRepo basicTaxRateRepo;

	@Override
	public BasicTaxRate findbasicTaxRatebyId(Integer id) {
		Optional<BasicTaxRate> jl = basicTaxRateRepo.findById(id);
		if (!jl.isPresent()) {
			throw new NotFoundException("BasicTaxRate Id : " + id + " does not exist!");
		}
		return jl.get();
	}

}
