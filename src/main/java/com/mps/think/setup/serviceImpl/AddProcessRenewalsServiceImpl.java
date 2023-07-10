package com.mps.think.setup.serviceImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AddEffort;
import com.mps.think.setup.model.AddProcessRenewals;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.OrderClass;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.AddProcessRenewalsRepo;
import com.mps.think.setup.service.AddProcessRenewalsService;
import com.mps.think.setup.utils.AppConstants;
import com.mps.think.setup.utils.SendEmail;
import com.mps.think.setup.vo.AddProcessRenewalsVO;

@Service
public class AddProcessRenewalsServiceImpl implements AddProcessRenewalsService{

	@Autowired
	AddProcessRenewalsRepo adddProcessRenewalsRepo;
	
	@Autowired
	AddOrderRepo orderRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private SendEmail mailSender;
	
	@Override
	public AddProcessRenewals saveAddProcessRenewals (AddProcessRenewalsVO addRenewalProcess) throws Exception {
		AddProcessRenewals renewalProcess = adddProcessRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalProcess, AddProcessRenewals.class));
		CompletableFuture.runAsync(() -> {
			try {
				runRenewalProcess(renewalProcess);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return renewalProcess;
	}
	
	@Override
	public List<AddProcessRenewals> getAllAddProcessRenewalsForPublisher(Integer pubId) {
		return adddProcessRenewalsRepo.findByPubIdId(pubId);
	}

	@Override
	public AddProcessRenewals updateAddProcessRenewals(AddProcessRenewalsVO addRenewalProcess) {
		return adddProcessRenewalsRepo.saveAndFlush(mapper.convertValue(addRenewalProcess, AddProcessRenewals.class));
	}

	@Override
	public AddProcessRenewals findbyAddProcessRenewalsId(Integer id) {
		return adddProcessRenewalsRepo.findById(id).get();
	}

	@Override
	public AddProcessRenewals deleteByAddProcessRenewalsId(Integer id) {
		AddProcessRenewals delete = findbyAddProcessRenewalsId(id);
		adddProcessRenewalsRepo.delete(delete);
		return delete;
	}

	@Override
	public List<AddProcessRenewals> getAllAddProcessRenewals() {
		return adddProcessRenewalsRepo.findAll();
	}
	
	String getCustomerEmail(CustomerDetails customer) {
		if (customer.getEmail() != null) return customer.getEmail().trim();
		else if (customer.getSecondaryEmail() != null) return customer.getSecondaryEmail().trim();
		return null;
	}
	
	
	String getCustomerName(CustomerDetails customer) {
		String name = "";
		if (customer.getFname() != null) name.concat(customer.getFname());
		if (customer.getLname() != null) name.concat(" " + customer.getLname());
		return name.trim();
	}
	
	
//	Hello dear {name},\n Your order {orderId} will get expire in {noOfDays} days. Please Renew it.
	void runRenewalProcess(AddProcessRenewals process) throws Exception {
		List<OrderClass> orderClasses = process.getOrderClassRenProcessMapping().stream().map(o -> o.getOrderClass()).collect(Collectors.toList());
		List<AddEffort> efforts = process.getEffortsRenProcessMapping().stream().map(p -> p.getEffort()).collect(Collectors.toList());
		if (orderClasses.isEmpty()) return;
		for (OrderClass oc : orderClasses) {
			List<Order> ordersToConsiderForRenewal = orderRepo.findByOrderClassOcId(oc.getOcId());
			for (Order o : ordersToConsiderForRenewal) {
				String customerEmail = getCustomerEmail(o.getCustomerId());
				for (AddEffort effort : efforts) {
					Integer noofdays = Integer.parseInt(effort.getNoofdays());
					LocalDate validTill = o.getOrderItemsAndTerms().getValidTo().toInstant().atZone(ZoneId.systemDefault())
							.toLocalDate();
					LocalDate dateToCheckWith = validTill.minusDays(noofdays);
					LocalDate todaysDate = LocalDate.now();
					if ((dateToCheckWith.equals(todaysDate) || todaysDate.isAfter(dateToCheckWith)) && customerEmail != null) {
						String renewalOrderEmailBody = AppConstants.getRenewalOrderEmailBody();
						renewalOrderEmailBody = renewalOrderEmailBody.replace("{name}", getCustomerName(o.getCustomerId()));
						renewalOrderEmailBody = renewalOrderEmailBody.replace("{orderId}", o.getOrderId().toString());
						renewalOrderEmailBody = renewalOrderEmailBody.replace("{noOfDays}", noofdays.toString());
						mailSender.sendOrderRenewalMailToCustomer(customerEmail, renewalOrderEmailBody);
					}
				}
			}
		}
	}
	
	

}
