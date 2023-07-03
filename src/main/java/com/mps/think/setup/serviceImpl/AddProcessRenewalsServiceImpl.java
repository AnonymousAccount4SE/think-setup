package com.mps.think.setup.serviceImpl;

import java.util.List;
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
	public AddProcessRenewals saveAddProcessRenewals (AddProcessRenewalsVO addRenewalProcess) {
		return adddProcessRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalProcess, AddProcessRenewals.class));
	}
	
	@Override
	public List<AddProcessRenewals> getAllAddProcessRenewalsForPublisher(Integer pubId) {
		return adddProcessRenewalsRepo.findByPubIdId(pubId);
	}

	@Override
	public AddProcessRenewals updateAddProcessRenewals(AddProcessRenewalsVO addRenewalProcess) {
		return adddProcessRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalProcess, AddProcessRenewals.class));
	}

	@Override
	public AddProcessRenewals findbyAddProcessRenewalsId(Integer id) {
		return adddProcessRenewalsRepo.findById(id).get();
	}

	@Override
	public AddProcessRenewals deleteByAddProcessRenewalsId(Integer id) {
		AddProcessRenewals delete = findbyAddProcessRenewalsId(id);
		adddProcessRenewalsRepo.delete(delete);
		return delete;
	}

	@Override
	public List<AddProcessRenewals> getAllAddProcessRenewals() {
		return adddProcessRenewalsRepo.findAll();
	}

}
