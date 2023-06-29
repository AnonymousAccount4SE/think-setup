package com.mps.think.setup.service;

import org.springframework.stereotype.Service;

import com.mps.think.setup.vo.DashboardCountsVO;

@Service
public interface DashboardService {

	public DashboardCountsVO getDashboardCountsForPublisher(Integer publisherId) throws Exception;
	
}
