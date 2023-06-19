package com.mps.think.setup.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.Addresses;
import com.mps.think.setup.model.CustomerAddresses;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.CustomerWithTwoOrderCodes;
import com.mps.think.setup.vo.RecentAddressVO;

public interface CustomerDetailsService {
	
	public List<CustomerDetails> getAllCustomerDetails();
	
//	public Page<CustomerDetails> getAllCustomerDetailsForSearch(String firstName, String lastName, Pageable page);
	public Page<CustomerDetails> getAllCustomerDetailsForSearch(Integer pubId, String search,  Pageable page);

	public CustomerDetails saveCustomerDetails(CustomerDetailsVO customerDetails);

	public CustomerDetails updateCustomerDetails(CustomerDetailsVO customerDetails);

	public CustomerDetails findbyCustomerDetailsId(Integer customerId);
	
	public Page<CustomerDetails> findAllCustomerByPubId(Integer pubId, Pageable page);
	
	public CustomerDetails deleteCustomer(Integer pubId);
	
	Map<Integer, List<OrderCodesSuper>> getAllCustomerRecentOrderCodeForPub(Integer pubId);

	Order getRecentOrderOfCustomer(Integer customerId) throws Exception;
	
	Integer countOfOrdersForGivenCustomerInYear(Integer customerId, String year);
	
	public List<String> getAllCustomerAgentForSearch(Integer publisher, String agencyname);

	CustomerDetails updateCustomerStatus(CustomerDetailsVO customer);
	
	Page<OrderAddressMapping> getAllRecentAddressFromCustomerOrders(Integer customerId, Pageable page);
	
	Page<CustomerDetails> getOtherCustomerAddresses(Integer publisherId, Integer customerId, Pageable page);
	
	Page<RecentAddressVO> getRecentAddressWithTheirCustomer(Integer customerId, Pageable page) throws Exception;

	public List<CustomerAddresses> getAllCustomerAddresses();
	
	Page<CustomerWithTwoOrderCodes> getAllCustomerWithRecentTwoOrderCodes(Integer pubId, Pageable page) throws Exception;
	public  List<List<String>> findAllColumn();
	
	Page<CustomerWithTwoOrderCodes> getSearchedCustomersWithTwoRecentOrderCodes(Integer pubId, String keyword, Pageable page) throws Exception;

}
