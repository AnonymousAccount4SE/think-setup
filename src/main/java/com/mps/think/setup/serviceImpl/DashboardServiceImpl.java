package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.service.DashboardService;
import com.mps.think.setup.vo.DashboardCountsVO;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private AddOrderRepo addOrderRepo;

	@Autowired
	private CustomerDetailsRepo customerDetailsRepo;

	@Override
	public DashboardCountsVO getDashboardCountsForPublisher(Integer publisherId) throws Exception {
		DashboardCountsVO counts = new DashboardCountsVO();
		counts.setOrderCount(addOrderRepo.countByCustomerIdPublisherId(publisherId).intValue());
		counts.setCustomerCount(customerDetailsRepo.countByPublisherId(publisherId).intValue());
		return counts;
	}

}
