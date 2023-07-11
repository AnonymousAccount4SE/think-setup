package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Nth;
import com.mps.think.setup.model.OutputSort;
import com.mps.think.setup.vo.NthVO;


@Service
public interface NthService {
	
	public List<Nth> getAllNth();
	
	public Nth saveNth(NthVO nth);

	public Nth updateNth(NthVO nth);

	public Nth findbyNthId(Integer id);
	
	public Nth deleteByNthId(Integer id);
	
	public List<Nth> findAllNthByPubId(Integer id);

}
