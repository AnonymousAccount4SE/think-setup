package com.mps.think.setup.service;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.DayEndProcess;
import com.mps.think.setup.vo.DayEndProcessVO;

@Service
public interface DayEndProcessService {
	
	public DayEndProcess fetchById(Integer id);
	
	public DayEndProcess fetchByPubId(Integer id);

	public DayEndProcess saveDayEndProcess(DayEndProcessVO dayEndProcess);
	
	public DayEndProcess updateDayEndProcess(DayEndProcessVO dayEndProcess);
	
}
