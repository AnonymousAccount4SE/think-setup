package com.mps.think.setup.serviceImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddEffort;
import com.mps.think.setup.repo.AddEffortRepo;
import com.mps.think.setup.service.AddEffortService;
import com.mps.think.setup.vo.AddEffortVO;

@Service
public class AddEffortServiceImpl implements AddEffortService{
	
	@Autowired
	private AddEffortRepo addEffortRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<AddEffort> getAllAddEffort() {
		return addEffortRepo.findAll();
	}

	@Override
	public AddEffort saveAddEffort(AddEffortVO addEffort) {
		return addEffortRepo.saveAndFlush(mapper.convertValue(addEffort, AddEffort.class));
	}

	@Override
	public AddEffort updateAddEffort(AddEffortVO addEffort) {
		return addEffortRepo.saveAndFlush(mapper.convertValue(addEffort, AddEffort.class));
	}

	@Override
	public AddEffort findbyAddEffortId(Integer id) {
		return addEffortRepo.findById(id).get();
	}

	@Override
	public AddEffort deleteByAddEffortId(Integer id) {
		AddEffort delete = findbyAddEffortId(id);
		addEffortRepo.delete(delete);
		return delete;
	}

	@Override
	public List<AddEffort> findAllAddEffortForRenewalId(Integer id) {
		return addEffortRepo.findByRdidId(id);
	}



}
