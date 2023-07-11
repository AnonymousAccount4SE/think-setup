package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Nth;
import com.mps.think.setup.repo.NthRepo;
import com.mps.think.setup.service.NthService;
import com.mps.think.setup.vo.NthVO;

@Service
public class NthServiceImpl implements NthService {
	
	@Autowired
	private NthRepo nthRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<Nth> getAllNth() {
		return nthRepo.findAll();
	}

	@Override
	public Nth saveNth(NthVO nth) {
		return nthRepo.saveAndFlush(mapper.convertValue(nth , Nth.class));
	}

	@Override
	public Nth updateNth(NthVO nth) {
		return nthRepo.saveAndFlush(mapper.convertValue(nth , Nth.class));
	}

	@Override
	public Nth findbyNthId(Integer id) {
		 return nthRepo.findById(id).get();
	}

	@Override
	public Nth deleteByNthId(Integer id) {
		Nth delete = findbyNthId(id);
		nthRepo.delete(delete);
		return delete;
	}

	@Override
	public List<Nth> findAllNthByPubId(Integer id) {
		return nthRepo.findByPubIdId(id);
	}

}
