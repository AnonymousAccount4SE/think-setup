package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.DayEndProcess;
import com.mps.think.setup.repo.DayEndProcessRepo;
import com.mps.think.setup.service.DayEndProcessService;
import com.mps.think.setup.vo.DayEndProcessVO;

@Service
public class DayEndProcessServiceImpl implements DayEndProcessService {

	@Autowired
	private DayEndProcessRepo dayEndProcessRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public DayEndProcess saveDayEndProcess(DayEndProcessVO dayEndProcess) {
		return dayEndProcessRepo.saveAndFlush(mapper.convertValue(dayEndProcess, DayEndProcess.class));
	}

	@Override
	public DayEndProcess updateDayEndProcess(DayEndProcessVO dayEndProcess) {
		return dayEndProcessRepo.saveAndFlush(mapper.convertValue(dayEndProcess, DayEndProcess.class));
	}

	@Override
	public DayEndProcess fetchById(Integer id) {
		return dayEndProcessRepo.findById(id).get();
	}
	
	@Override
	public DayEndProcess fetchByPubId(Integer id) {
		return dayEndProcessRepo.findByPubIdId(id);
	}
}
