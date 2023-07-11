package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.OutputValue;
import com.mps.think.setup.repo.OutputValueRepo;
import com.mps.think.setup.service.OutputValueService;
import com.mps.think.setup.vo.OutputValueVO;

@Service
public class OutputValueServiceImpl implements OutputValueService {
	
	@Autowired
	private OutputValueRepo outputValueRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<OutputValue> getAllOutputValue() {
		return outputValueRepo.findAll();
	}

	@Override
	public OutputValue saveOutputValue(OutputValueVO outputValue) {
		return outputValueRepo.saveAndFlush(mapper.convertValue(outputValue, OutputValue.class));
	}

	@Override
	public OutputValue updateOutputValue(OutputValueVO outputValue) {
		return outputValueRepo.saveAndFlush(mapper.convertValue(outputValue, OutputValue.class));
	}

	@Override
	public OutputValue findbyOutputValueId(Integer id) {
		return outputValueRepo.findById(id).get();
	}

	@Override
	public OutputValue deleteByOutputValueId(Integer id) {
		OutputValue delete = findbyOutputValueId(id);
		outputValueRepo.delete(delete);
		return delete;
	}

	@Override
	public List<OutputValue> findAllOutputValueByPubId(Integer id) {
		return outputValueRepo.findByPubIdId(id);
	}

}
