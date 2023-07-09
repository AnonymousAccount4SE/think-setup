package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddProcess;
import com.mps.think.setup.model.Addprocessmapping;
import com.mps.think.setup.repo.AddProcessRepo;
import com.mps.think.setup.service.AddProcessService;
import com.mps.think.setup.vo.AddProcessVO;

@Service
public class AddProcessServiceImpl implements AddProcessService {
	
	@Autowired
	private AddProcessRepo addProcessRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<AddProcess> getAllProcess() {
		return addProcessRepo.findAll();
	}

	@Override
	public AddProcess saveProcess(AddProcessVO process) {
	return addProcessRepo.saveAndFlush(mapper.convertValue(process, AddProcess.class));
	}

	@Override
	public AddProcess updateProcess(AddProcessVO process) {
		return  addProcessRepo.saveAndFlush(mapper.convertValue(process, AddProcess.class));
	}

	@Override
	public AddProcess findbyProcessId(Integer process_id) {
		Optional<AddProcess> cr = addProcessRepo.findById(process_id);
		return cr.get();
	}

	@Override
	public AddProcess deleteByProcessId(Integer process_id) {
		AddProcess delete = findbyProcessId(process_id);
		addProcessRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Addprocessmapping> getAllAddprocessmapping() {
		List<List<Addprocessmapping>> collect = addProcessRepo.findAll().stream().map(a -> a.getAddprocessmapping()).collect(Collectors.toList());
		List<Addprocessmapping> output = new ArrayList<>();
		for (List<Addprocessmapping> s : collect) {
			output.addAll(s);
		}
		return output;
	}

	@Override
	public List<AddProcess> findAllAddProcessForPublisher(Integer pubId) {
		return addProcessRepo.findByPubIdId(pubId);
	}

	
	
//	@Override
//	public List<AddProcess> findAllAddProcessByPId(Integer pid) {
//		return addProcessRepo.findByprocesstypeidPid(pid);
//	}

}
