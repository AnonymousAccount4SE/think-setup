package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.CustomerAddresses;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.AddressesRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.service.CustomerDetailsService;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.EnumModelVO;
import com.mps.think.setup.vo.RecentAddressVO;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;
import com.mps.think.setup.vo.EnumModelVO.Status;
import com.mps.think.setup.vo.OrderAddressMappingVO;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {

	@Autowired
	private CustomerDetailsRepo customerRepo;

	@Autowired
	private AddOrderService orderService;

	@Autowired
	private AddOrderRepo orderRepo;

	@Autowired
	private AddressesRepo addressRepo;
	
	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<CustomerDetails> getAllCustomerDetails() {
		return customerRepo.findAll();
	}

//	@Override
//	public Page<CustomerDetails> getAllCustomerDetailsForSearch(String firstName, String lastName, Pageable page) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public CustomerDetails saveCustomerDetails(CustomerDetailsVO customerDetails) {
//		ObjectMapper mapper = new ObjectMapper();
		CustomerDetails newCustomer = mapper.convertValue(customerDetails, CustomerDetails.class);
		newCustomer.setCustomerStatus(CustomerStatus.Active);
		newCustomer.setDateUntilDeactivation(null);
		CustomerDetails cdata = customerRepo.saveAndFlush(newCustomer);
		return cdata;
	}

	@Override
	public CustomerDetails updateCustomerDetails(CustomerDetailsVO customerDetails) {
//		ObjectMapper mapper = new ObjectMapper();
		CustomerDetails updatedCustomer = mapper.convertValue(customerDetails, CustomerDetails.class);
		CustomerDetails cdata = customerRepo.saveAndFlush(updatedCustomer);
		return cdata;
	}

	@Override
	public CustomerDetails findbyCustomerDetailsId(Integer customerId) {
		return customerRepo.findById(customerId).get();
	}

	@Override
	public CustomerDetails deleteCustomer(Integer customerId) {
		CustomerDetails customerToDelete = findbyCustomerDetailsId(customerId);
		customerRepo.delete(customerToDelete);
		return customerToDelete;
	}

	@Override
	public Page<CustomerDetails> getAllCustomerDetailsForSearch(Integer pubId, String search, Pageable page) {
		// TODO Auto-generated method stub
		return customerRepo.getAllCustomerDetailsForSearchSingle(pubId, search, page);
	}

	@Override
	public Page<CustomerDetails> findAllCustomerByPubId(Integer pubId, Pageable page) {
		return customerRepo.findByPublisherId(pubId, page);
	}

	public Map<Integer, List<OrderCodesSuper>> fetchRecentTwoOrderCode(Integer customerId) throws Exception {
		Map<Integer, List<OrderCodesSuper>> response = new HashMap<>();
		response.put(customerId, orderService.getRecentTwoOrderOfCustomer(customerId));
		return response;
	}

	@Override
	public List<Map<Integer, List<OrderCodesSuper>>> getAllCustomerRecentOrderCodeForPub(Integer pubId) {
		Integer numCustomers = customerRepo.countCustomersInPublisher(pubId);
		if (numCustomers < 1) {
			return new ArrayList<>(0);
		}
		return customerRepo
				.findByPublisherId(pubId, PageRequest.of(0, numCustomers)).stream().map(c -> {
					try {
						return fetchRecentTwoOrderCode(c.getCustomerId());
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}).collect(Collectors.toList());
	}

	@Override
	public Order getRecentOrderOfCustomer(Integer customerId) throws Exception {
		List<Order> orders = orderService
				.getAllOrderByCustomerId(customerId, PageRequest.of(0, 1, Sort.by("orderId").descending())).toList();
		if (!orders.isEmpty()) {
			return orders.get(0);
		}
//		throw new NoSuchElementException("customer does not have any order");
		return null;
	}

	@Override
	public Integer countOfOrdersForGivenCustomerInYear(Integer customerId, String year) {
		return orderRepo.findOrderCountForCustomerInYear(customerId, year).size();
	}

	@Override
	public Page<CustomerDetails> getAllCustomerAgentForSearch(Integer publisher ,String agencyname, Pageable page) {
		return customerRepo.getAllCustomerAgentForSearch(publisher, agencyname, page);
	}
	
	public CustomerDetails updateCustomerStatus(CustomerDetailsVO customerVO) {

		Optional<CustomerDetails> customerDetails = customerRepo.findById(customerVO.getCustomerId());
		if (!customerDetails.isPresent()) {
			return null;
		}
		CustomerDetails customer = customerDetails.get();
		if (customerVO.getCustomerStatus().equals(CustomerStatus.Hold)) {
			customer.setCustomerStatus(CustomerStatus.Hold);
			customer.setDateUntilDeactivation(customerVO.getDateUntilDeactivation());
			customer.setCurrCustomerStatusCause(customerVO.getCurrCustomerStatusCause());
			customerRepo.saveAndFlush(customer);
		} else if (customerVO.getCustomerStatus().equals(CustomerStatus.Inactive)) {
			customer.setCustomerStatus(CustomerStatus.Inactive);
			customer.setCurrCustomerStatusCause(customerVO.getCurrCustomerStatusCause());
			customer.setDateUntilDeactivation(new Date());
			customerRepo.saveAndFlush(customer);
			// set all the orders of curr customer inactive
			orderService.setAllOrdersOfCustomerInActive(customerVO.getCustomerId());
			// set all the address of curr customer inactive
			List<Addresses> customerAddresses = customer.getCustomerAddresses().stream().map(ca -> ca.getAddress()).collect(Collectors.toList());
			customerAddresses.forEach(a -> a.setStatus(Status.Inactive));
			addressRepo.saveAllAndFlush(customerAddresses);
		}
		
		return customer;
		
	}

	@Override
	public Page<OrderAddressMapping> getAllRecentAddressFromCustomerOrders(Integer customerId, Pageable page) {
		return customerRepo.findAllRecentAddressOfCustomerBasedOnOrder(customerId, page);
	}

	@Override
	public Page<CustomerDetails> getOtherCustomerAddresses(Integer publisherId, Integer customerId, Pageable page) {
		return customerRepo.findOtherCustomer(publisherId, customerId, page);
	}
	
	public String fetchCustomerName(CustomerDetails customer) {
		String name = customer.getFname();
		name += customer.getLname() != null ? " " + customer.getLname() : "";
		return name.trim();
	}
	
	public CustomerDetails getCustomerByAddressId(Integer addressId) {
		List<Integer> customers = customerRepo.findCustomerNameFromAddressId(addressId);
		if (customers.isEmpty()) return null;
		Optional<CustomerDetails> cus = customerRepo.findById(customers.get(0));
		return cus.isPresent() ? cus.get() : null;
	}

	@Override
	public Page<RecentAddressVO> getRecentAddressWithTheirCustomer(Integer customerId,
			Pageable page) throws Exception {
		Page<OrderAddressMapping> givenCustomerOrdersAddresses = customerRepo.findAllRecentAddressOfCustomerBasedOnOrder(customerId, page);		
		List<RecentAddressVO> output = new ArrayList<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		for (OrderAddressMapping oam : givenCustomerOrdersAddresses) {
			CustomerDetails cus1 = oam.getOrder().getCustomerId();
			CustomerDetails cus2 = oam.getOrder().getOtherAddressCustomer();
			RecentAddressVO recentAdd = new RecentAddressVO();
			recentAdd.setOrderAddressMapping(mapper.convertValue(oam, OrderAddressMappingVO.class));
			if (customerRepo.checkGivenAddressIsOfCustomer(cus1.getCustomerId(), oam.getAddress().getAddressId()) > 0) {
				recentAdd.setCustomerName(fetchCustomerName(cus1));
			} else if (cus2 != null && customerRepo.checkGivenAddressIsOfCustomer(cus2.getCustomerId(), oam.getAddress().getAddressId()) > 0) {
				recentAdd.setCustomerName(fetchCustomerName(cus2));
			} else {
				CustomerDetails randomCustomer = getCustomerByAddressId(oam.getAddress().getAddressId());
				recentAdd.setCustomerName(randomCustomer != null ? fetchCustomerName(randomCustomer) : "");
			}
			
			/*
			 	we can remove comment out from below code and remove the above redundant code.
			 	
			*/
			
//			CustomerDetails randomCustomer = getCustomerByAddressId(oam.getAddress().getAddressId());
//			recentAdd.setCustomerName(randomCustomer != null ? fetchCustomerName(randomCustomer) : "");
			
			output.add(recentAdd);
		}
		return new PageImpl<>(output, givenCustomerOrdersAddresses.getPageable(), givenCustomerOrdersAddresses.getTotalElements());
	}

}





