package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddProcessRenewals;
import com.mps.think.setup.repo.AddProcessRenewalsRepo;
import com.mps.think.setup.service.AddProcessRenewalsService;
import com.mps.think.setup.vo.AddProcessRenewalsVO;

@Service
public class AddProcessRenewalsServiceImpl implements AddProcessRenewalsService{

	@Autowired
	AddProcessRenewalsRepo adddProcessRenewalsRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public AddProcessRenewals saveAddProcessRenewals (AddProcessRenewalsVO addRenewalPprocess) {
		return adddProcessRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalPprocess, AddProcessRenewals.class));
	}

}
