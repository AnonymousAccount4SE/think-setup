package com.mps.think.setup.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Order;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.service.DashboardService;
import com.mps.think.setup.utils.AppConstants.ExtractFilterTableName;
import com.mps.think.setup.vo.DashboardCountsVO;
import com.mps.think.setup.vo.EnumModelVO.OrderType;

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

	@Override
	public Map<String, Integer> getOrderTypesCountForPublisher(Integer pubId) throws Exception {
		Map<String, Integer> ordertypeCount=new HashMap<>();
		 List<String[]> orderList= addOrderRepo.getOrderTypesCountForPublisher(pubId);
		for(OrderType data:OrderType.values()) {
			int count = 0;
        	 for(String[] allOrders:orderList) {
        		 if(allOrders[1]!=null && data.getDisplayName().equalsIgnoreCase(allOrders[1])  ) {
        			count++;
        		 }
        	 }
        	 ordertypeCount.put(data.getDisplayName(), count);
         }
		return ordertypeCount;
		 
	}

}
