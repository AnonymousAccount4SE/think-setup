package com.mps.think.setup.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.mps.think.setup.vo.DashboardCountsVO;

@Service
public interface DashboardService {

	public DashboardCountsVO getDashboardCountsForPublisher(Integer publisherId) throws Exception;

	public Map<String, Integer> getOrderTypesCountForPublisher(Integer pubId) throws Exception;

	public Map<Integer, Map<String, Integer>> getOrdersPerMonthForPublisher(Integer pubId, Integer year)throws Exception;
	
}
