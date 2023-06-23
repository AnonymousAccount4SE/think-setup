package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.Comparator;
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
import com.mps.think.setup.model.MultiLineItemOrder;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderAddressMapping;
import com.mps.think.setup.model.OrderCodesSuper;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.AddressesRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.IssueGenerationRepo;
import com.mps.think.setup.repo.PaymentInformationRepo;
import com.mps.think.setup.service.AddOrderService;
import com.mps.think.setup.service.CustomerDetailsService;
import com.mps.think.setup.utils.AppConstants;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.CustomerWithTwoOrderCodes;
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
	private PaymentInformationRepo piRepo;
	
	@Autowired
	private IssueGenerationRepo iRepo;

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
		CustomerDetails newCustomer = mapper.convertValue(customerDetails, CustomerDetails.class);

		if (customerDetails.getPaymentThreshold() == null
				|| customerDetails.getPaymentThreshold().getPaymentThresholdId() == 0) {
			newCustomer.setPaymentThreshold(null);
		}

		newCustomer.setCustomerStatus(CustomerStatus.Active);
		newCustomer.setDateUntilDeactivation(null);
		
		setAddressesNamesSameAsCustomer(newCustomer);
		
		CustomerDetails cdata = customerRepo.saveAndFlush(newCustomer);
		return cdata;
	}

	@Override
	public CustomerDetails updateCustomerDetails(CustomerDetailsVO customerDetails) {
		CustomerDetails updatedCustomer = mapper.convertValue(customerDetails, CustomerDetails.class);

		if (customerDetails.getPaymentThreshold() == null
				|| customerDetails.getPaymentThreshold().getPaymentThresholdId() == 0) {
			updatedCustomer.setPaymentThreshold(null);
		}
		
		setAddressesNamesSameAsCustomer(updatedCustomer);

		CustomerDetails cdata = customerRepo.saveAndFlush(updatedCustomer);
		return cdata;
	}
	
	private void setAddressesNamesSameAsCustomer(CustomerDetails customer) {
		customer.getCustomerAddresses().forEach(ca -> {
			if(Boolean.TRUE.equals(ca.getAddress().getSameAsCustomer())) {
				Addresses address = ca.getAddress();
				address.setSalutation(customer.getSalutation());
				address.setFirstName(customer.getFname());
				address.setMiddleName(customer.getInitialName());
				address.setLastName(customer.getLname());
				address.setSuffix(customer.getSuffix());
				addressRepo.saveAndFlush(address);
			}
		});
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
		if (search != null && search.contains("=")) return searchCustomerUsingKeyValue(pubId.equals(0) ? null : pubId, search, page);
		return customerRepo.getAllCustomerDetailsForSearchSingle(pubId.equals(0) ? null : pubId, search, page);
	}

	@Override
	public Page<CustomerDetails> findAllCustomerByPubId(Integer pubId, Pageable page) {
		return customerRepo.findByPublisherId(pubId, page);
	}

	public List<OrderCodesSuper> fetchRecentTwoOrderCode(Integer customerId) throws Exception {
		return orderService.getRecentTwoOrderOfCustomer(customerId);
	}

	@Override
	public Map<Integer, List<OrderCodesSuper>> getAllCustomerRecentOrderCodeForPub(Integer pubId) {
		Map<Integer, List<OrderCodesSuper>> output = new HashMap<>();
		customerRepo.findByPublisherId(pubId).stream().forEach(c -> {
			try {
				output.put(c.getCustomerId(), fetchRecentTwoOrderCode(c.getCustomerId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return output;
	}

	@Override
	public Order getRecentOrderOfCustomer(Integer customerId) throws Exception {
		Optional<Order> order = orderRepo.findByCustomerIdCustomerId(customerId).stream()
				.max(Comparator.comparingInt(Order::getOrderId));
		if (order.isPresent()) {
			return order.get();
		}
		return null;
	}

	@Override
	public Integer countOfOrdersForGivenCustomerInYear(Integer customerId, String year) {
		return orderRepo.findOrderCountForCustomerInYear(customerId, year).size();
	}

	@Override
	public List<String> getAllCustomerAgentForSearch(Integer publisher, String agencyname) {
		return customerRepo.getAllCustomerAgentForSearch(publisher, agencyname);
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
			List<Addresses> customerAddresses = customer.getCustomerAddresses().stream().map(ca -> ca.getAddress())
					.collect(Collectors.toList());
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
		if (customers.isEmpty())
			return null;
		Optional<CustomerDetails> cus = customerRepo.findById(customers.get(0));
		return cus.isPresent() ? cus.get() : null;
	}

	/*
	 * the code below using if else-if and else for every OrderAddressMapping,
	 * though we can only use the code of else block to fetch the customer by
	 * providing the addressId but as per out condition an order can hold its
	 * customer addresses + one other customer addresses so if and else-if condition
	 * will check those tow specific customer addresses only but, if any unknown
	 * address comes out the else condition is there to find the particular customer
	 * by using that address's id (which will perform a little longer operation) so
	 * almost every time the code will go through if and else-if condition only and
	 * it is more efficient to find customer if there is only 2 customers.
	 * 
	 */

	@Override
	public Page<RecentAddressVO> getRecentAddressWithTheirCustomer(Integer customerId, Pageable page) throws Exception {
		Page<OrderAddressMapping> givenCustomerOrdersAddresses = customerRepo
				.findAllRecentAddressOfCustomerBasedOnOrder(customerId, page);
		List<RecentAddressVO> output = new ArrayList<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		for (OrderAddressMapping oam : givenCustomerOrdersAddresses) {
			CustomerDetails cus1 = oam.getOrder().getCustomerId();
			CustomerDetails cus2 = oam.getOrder().getOtherAddressCustomer();
			RecentAddressVO recentAdd = new RecentAddressVO();
			recentAdd.setOrderAddressMapping(mapper.convertValue(oam, OrderAddressMappingVO.class));
			if (customerRepo.checkGivenAddressIsOfCustomer(cus1.getCustomerId(), oam.getAddress().getAddressId()) > 0) {
				recentAdd.setCustomerName(fetchCustomerName(cus1));
			} else if (cus2 != null && customerRepo.checkGivenAddressIsOfCustomer(cus2.getCustomerId(),
					oam.getAddress().getAddressId()) > 0) {
				recentAdd.setCustomerName(fetchCustomerName(cus2));
			} else {
				CustomerDetails randomCustomer = getCustomerByAddressId(oam.getAddress().getAddressId());
				recentAdd.setCustomerName(randomCustomer != null ? fetchCustomerName(randomCustomer) : "");
			}
			output.add(recentAdd);
		}
		return new PageImpl<>(output, givenCustomerOrdersAddresses.getPageable(),
				givenCustomerOrdersAddresses.getTotalElements());
	}

	@Override
	public List<List<String>> findAllColumn() {
		List<List<String>> arraylist = new ArrayList<>();
		arraylist.add(customerRepo.findAllColumn());
		arraylist.add(orderRepo.findAllColumnForOrders());
		arraylist.add(addressRepo.findAllColumnforAddresses());
		arraylist.add(piRepo.findAllColumnForPaymentInfo());
		arraylist.add(iRepo.findAllIssueColumn());
		return arraylist;
	}

	@Override
	public List<CustomerAddresses> getAllCustomerAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	
//	CustomerStatus getCustomerStatus(String status) {
//		for (CustomerStatus cs : CustomerStatus.values()) {
//			if (cs.getCustomerStatus().equalsIgnoreCase(status)) return cs;
//		}
//		return null;
//	}
	
	// name, fax, email, department, countrycode, company, mobile, agnecycode,
	// agencyname, status, ordercode
	public Page<CustomerDetails> searchCustomerUsingKeyValue(Integer pubId, String searchStream, Pageable page) {
		String[] inputSplit = searchStream.trim().split(" " + AppConstants.customerSearchSeperator + " ");
		Map<String, Object> keys = new HashMap<>();
		for (String keyValue : inputSplit) {
			String k = keyValue.split("=")[0].trim();
			Object v = keyValue.split("=")[1];
			keys.put(k.toLowerCase(), v);
		}
		return customerRepo.searchCustomerByKeys(pubId,
				keys.getOrDefault("name", null) != null ? ((String) keys.get("name")).trim() : null,
				keys.getOrDefault("fax", null) != null ? ((String) keys.get("fax")).trim() : null,
				keys.getOrDefault("email", null) != null ? ((String) keys.get("email")).trim() : null,
				keys.getOrDefault("department", null) != null ? ((String) keys.get("department")).trim() : null,
				keys.getOrDefault("countrycode", null) != null ? ((String) keys.get("countrycode")).trim() : null,
				keys.getOrDefault("company", null) != null ? ((String) keys.get("company")).trim() : null,
				keys.getOrDefault("mobile", null) != null ? ((String) keys.get("mobile")).trim() : null,
				keys.getOrDefault("agnecycode", null) != null ? ((String) keys.get("agnecycode")).trim() : null,
				keys.getOrDefault("agencyname", null) != null ? ((String) keys.get("agencyname")).trim() : null,
				keys.getOrDefault("status", null) != null ? ((String) keys.get("status")).trim() : null, page);
	}

	@Override
	public Page<CustomerWithTwoOrderCodes> getAllCustomerWithRecentTwoOrderCodes(Integer pubId, Pageable page) throws Exception {
		Page<CustomerDetails> customers = findAllCustomerByPubId(pubId, page);
		List<CustomerWithTwoOrderCodes> output = new ArrayList<>();
		for (CustomerDetails c : customers) {
			CustomerWithTwoOrderCodes customerNOrderCodes = new CustomerWithTwoOrderCodes();
			customerNOrderCodes.setCustomer(c);
			customerNOrderCodes.setOrderCodes(fetchRecentTwoOrderCode(c.getCustomerId()).stream().map(o -> o.getOrderCodes()).collect(Collectors.toList()));
			output.add(customerNOrderCodes);
		}
		return new PageImpl<>(output, customers.getPageable(), customers.getTotalElements());
	}
//	@Override
//	public List<CustomerAddresses> getAllCustomerAddresses() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Page<CustomerWithTwoOrderCodes> getSearchedCustomersWithTwoRecentOrderCodes(Integer pubId, String keyword, Pageable page) throws Exception {
		Page<CustomerDetails> allCustomerDetailsForSearch = getAllCustomerDetailsForSearch(pubId, keyword, page);
		List<CustomerWithTwoOrderCodes> output = new ArrayList<>();
		for (CustomerDetails cd : allCustomerDetailsForSearch) {
			CustomerWithTwoOrderCodes cusAndOrderCodes = new CustomerWithTwoOrderCodes();
			cusAndOrderCodes.setCustomer(cd);
			cusAndOrderCodes.setOrderCodes(fetchRecentTwoOrderCode(cd.getCustomerId()).stream().map(oc -> oc.getOrderCodes()).collect(Collectors.toList()));
			output.add(cusAndOrderCodes);
		}
		return new PageImpl<>(output, allCustomerDetailsForSearch.getPageable(), allCustomerDetailsForSearch.getTotalElements());
	}

}
