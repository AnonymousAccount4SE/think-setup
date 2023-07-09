package com.mps.think.setup.serviceImpl;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

	@Override
	public Map<Integer, Map<String,Integer>> getOrdersPerMonthForPublisher(Integer pubId,Integer year) throws Exception {
		 List<String[]> orderList= addOrderRepo.getOrdersPerMonthForPublisher(pubId);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
	        Map<Integer, Map<String,Integer>> yearMonthList = new HashMap<>();
	        Map<String,Integer> monthList=new HashMap<String,Integer>();
  	        	 for(String[] allOrders:orderList) {
	        		  String date=allOrders[1];
	        		  LocalDateTime dateTime = LocalDateTime.parse(date,formatter); 
 	        	        Month month = dateTime.getMonth();
 	        	       int years = dateTime.getYear();
 	        	      if (years==year) {
 	        	      String key =" " + month+" ";
 	                 monthList.put(key, monthList.getOrDefault(key, 0) + 1);
 	        	      }
 	        	 }
	             monthList.values().stream().mapToInt(Integer::intValue).sum();
	             yearMonthList.put(year, monthList);
 		
		return yearMonthList; 
	}

}
