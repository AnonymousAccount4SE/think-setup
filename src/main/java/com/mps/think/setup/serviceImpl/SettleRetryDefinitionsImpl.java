package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.InstallmentPlan;
import com.mps.think.setup.model.SettleRetryDefinitions;
import com.mps.think.setup.model.SetupInstallments;
import com.mps.think.setup.repo.SettleRetryDefinitionsRepo;
import com.mps.think.setup.service.SettleRetryDefinitionsService;
import com.mps.think.setup.vo.SettleRetryDefinitionsVO;

@Service
public class SettleRetryDefinitionsImpl implements SettleRetryDefinitionsService{

 	@Autowired
	private ObjectMapper mapper;
	
	
	@Autowired
	private SettleRetryDefinitionsRepo settleRetryDefinitionsRepo;
	
	@Override
	public List<SettleRetryDefinitions> getAllSettleRetryDefinitions() {
		return settleRetryDefinitionsRepo.findAll();
	}

	@Override
	public SettleRetryDefinitions saveSettleRetryDefinitions(SettleRetryDefinitionsVO settleRetryDefinitions) {
		return 	settleRetryDefinitionsRepo.saveAndFlush(mapper.convertValue(settleRetryDefinitions, SettleRetryDefinitions.class));
 	}

	@Override
	public SettleRetryDefinitions updateSettleRetryDefinitions(SettleRetryDefinitionsVO settleRetryDefinitions) {
 		ObjectMapper obj = new ObjectMapper();
 		SettleRetryDefinitions settleRetryDef = obj.convertValue(settleRetryDefinitions, SettleRetryDefinitions.class);
 		SettleRetryDefinitions settleRetry = settleRetryDefinitionsRepo.saveAndFlush(settleRetryDef);
		return settleRetry;
	}

	@Override
	public SettleRetryDefinitions getSettleRetryDefinitionsByid(Integer id) {
		return settleRetryDefinitionsRepo.findById(id).get();
	}

	@Override
	public SettleRetryDefinitions deleteSettleRetryDefinitionsById(Integer id) {
		SettleRetryDefinitions remove = settleRetryDefinitionsRepo.findById(id).get();
		if (remove != null) {
			settleRetryDefinitionsRepo.delete(remove);
		}
		return remove;

	}

	@Override
	public List<SettleRetryDefinitions> getAllSettleRetryDefinitionsForPublisher(Integer pubId) {
		return settleRetryDefinitionsRepo.findSettleRetryDefinitionsByPublisherId(pubId);
	}

	
}
