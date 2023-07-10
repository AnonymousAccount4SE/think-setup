package com.mps.think.setup.serviceImpl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.CancelOrder;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.MakePayment;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentInformation;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.CancelOrderRepo;
import com.mps.think.setup.repo.CustomerDetailsRepo;
import com.mps.think.setup.repo.MakePaymentRepo;
import com.mps.think.setup.repo.PaymentInformationRepo;
import com.mps.think.setup.repo.SalesByRegionRepo;
import com.mps.think.setup.service.ReportsService;
import com.mps.think.setup.vo.CancelSubscirptionReportView;
import com.mps.think.setup.vo.CreditCardDeclinedView;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.DailyCashReportView;
import com.mps.think.setup.vo.DailyCreditCardAndPaymentReportView;
import com.mps.think.setup.vo.EnumModelVO;
import com.mps.think.setup.vo.OrderAddressMappingVO;
import com.mps.think.setup.vo.RefundProcessReportView;
import com.mps.think.setup.vo.SalesByMonthView;
import com.mps.think.setup.vo.SalesByRegionVO;
import com.mps.think.setup.vo.SalesListByOrderView;
import com.mps.think.setup.vo.TopNCustomersReportView;
import com.mps.think.setup.vo.EnumModelVO.CustomerStatus;

@Service
public class ReportsServiceImpl implements ReportsService {

	@Autowired
	private AddOrderRepo orderRepo;
	
	@Autowired
	private CustomerDetailsRepo customerDetailsRepo;
	
	@Autowired
	private CancelOrderRepo cancelOrderRepo;
	
	@Autowired
	private AddOrderRepo addOrderRepo;
	
	@Autowired
	private PaymentInformationRepo paymentInfoRepo;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Autowired
	private MakePaymentRepo makePaymentRepo;
	
	@Autowired
	private SalesByRegionRepo salesByRegionRepo;

	@Override
	public Page<Order> getAllOrderReports(Integer pubId, String orderStatus, Date ordersFrom, Date ordersTill, Integer customerId,
			String customerName, Pageable page) {
		if (ordersFrom == null) ordersFrom = new Date(0);
		if (ordersTill == null) ordersTill = new Date();
		return orderRepo.findAllOrdersForReport(pubId, orderStatus, ordersFrom, ordersTill, customerId, customerName, page);
	}

	@Override
	public Page<CustomerDetails> getAllCustomerSearchReport(Integer pubId, Integer customerId, String fname, String lname,
			String initialName, String email, String company, String department, String country, String state,
			String city, Integer zipCode, Pageable page) {
	
		return customerDetailsRepo.findCustomerSearchReport(pubId, customerId, fname, lname, initialName, email,
				                                             company, department, country, state, city, zipCode, page);
	}

	@Override
	public Page<CancelSubscirptionReportView> getAllCancelledSubscriptions(Integer pubId, Date orderFrom, Date orderTill, String currencyType,
			Pageable page) {
		Page<CancelOrder> allCancelledSubscriptions = cancelOrderRepo.findAllCancelledSubscriptions(pubId, orderFrom, orderTill, currencyType, "subscription" , page);
		List<CancelSubscirptionReportView> output = new ArrayList<>();
		
		allCancelledSubscriptions.toList().forEach(c -> {
			CancelSubscirptionReportView obj = new CancelSubscirptionReportView();
			obj.setOrderId(c.getOrderid().getOrderId());
			obj.setOrderCode(c.getOrderid().getKeyOrderInformation().getOrderCode().getOrderCodes().getOrderCode());
			obj.setCancelDate(c.getDate());
			obj.setCustomerFname(c.getOrderid().getCustomerId().getFname());
			obj.setCustomerLname(c.getOrderid().getCustomerId().getLname());
			obj.setPaymentInfo(c.getOrderid().getPaymentBreakdown());
			obj.setCancelReason(c.getCancelReasonsId().getCancelReason());
			obj.setTotalIssues(c.getOrderid().getOrderItemsAndTerms().getNumOfIssues());
			obj.setIssuesServed(c.getOrderid().getOrderItemsAndTerms().getIssue());
			obj.setCustomerId(c.getOrderid().getCustomerId().getCustomerId());
			output.add(obj);
		});
		
		return new PageImpl<>(output, allCancelledSubscriptions.getPageable(), allCancelledSubscriptions.getTotalElements());
		
	}

	@Override
	public Page<Order> getAllCustomerSalesList(Integer pubId, Date oredrStart, Date orderEnd, String orderType,
			Pageable page) {
		if (oredrStart == null) oredrStart = new Date(0);
		if (orderEnd == null) orderEnd = new Date();
		return addOrderRepo.findAllCustomerSalesList(pubId, oredrStart, orderEnd, orderType != null ? orderType.trim() : null, page);
	}

	@Override
	public Page<DailyCashReportView> getAllDailyCashReport(Integer pubId, Date paymentStart, Date paymentEnd, Pageable page) {
		if (paymentStart == null) paymentStart = new Date(0);
		if (paymentEnd == null) paymentEnd = new Date();
//		return paymentInfoRepo.findAllDailyCashReport(paymentStart, paymentEnd, page);
		
		Page<PaymentInformation> allPaymentInformation = paymentInfoRepo.findAllDailyCashReport(pubId, paymentStart, paymentEnd, page);
		List<DailyCashReportView> output1 = new ArrayList<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		allPaymentInformation.toList().forEach(c -> {
			DailyCashReportView obj = new DailyCashReportView();
			obj.setOrderId(c.getOrder().getOrderId());
			obj.setCommission(c.getOrder().getPaymentBreakdown().getCommission());
			obj.setCurrency(c.getOrder().getPaymentBreakdown().getCurrency());
			obj.setCustomerId(c.getOrder().getCustomerId().getCustomerId());
			obj.setNetAmount(c.getOrder().getPaymentBreakdown().getNetAmount());
			obj.setPaymentDate(c.getCreatedAt());
			List<OrderAddressMappingVO> add = new ArrayList<>();
			c.getOrder().getOrderAddresses().forEach(a -> {
				OrderAddressMappingVO addVO = mapper.convertValue(a, OrderAddressMappingVO.class);
				add.add(addVO);
			});
			obj.setAddresses(add);
			obj.setShippingCharge(c.getOrder().getPaymentBreakdown().getShippingCharge());
			obj.setTaxAmount(c.getOrder().getPaymentBreakdown().getTax());
			obj.setTotalAmount(c.getOrder().getPaymentBreakdown().getGrossAmount());
			output1.add(obj);
		});
		
		return new PageImpl<>(output1, allPaymentInformation.getPageable(), allPaymentInformation.getTotalElements());
		
	}

	@Override
	public Page<RefundProcessReportView> getAllRefundProcessReport(Integer pubId, Date startRefund, Date endRefund, Pageable page) {
		if (startRefund == null) startRefund = new Date(0);
		if (endRefund == null) endRefund = new Date();
		
		Page<CancelOrder> allRefundProcessReport = cancelOrderRepo.findAllRefundProcessReport(pubId, startRefund, endRefund , page);
		List<RefundProcessReportView> refund = new ArrayList<>();
		
		allRefundProcessReport.toList().forEach(c -> {
			RefundProcessReportView obj = new RefundProcessReportView();
			obj.setOrderNumber(c.getCancelorderId());
			obj.setRefundAmount(c.getRefundamount());
			
			refund.add(obj);
		});
		
		return new PageImpl<>(refund, allRefundProcessReport.getPageable(), allRefundProcessReport.getTotalElements());
		
	}

	@Override
	public Page<CustomerDetailsVO> getAllCustomerDetatilsReport(Integer pubId, String status, Pageable page) {
		EnumModelVO.CustomerStatus csStatus = null;
		CustomerStatus[] values = CustomerStatus.values();
		for (CustomerStatus cs : values) {
			if (cs.getCustomerStatus().equalsIgnoreCase(status)) {
				csStatus = cs;
				break;
			}
		}
		Page<CustomerDetails> allCustomerDetails = customerDetailsRepo.findAllCustomerDetatilsReport(pubId, csStatus , page);
		List<CustomerDetailsVO> cdr = new ArrayList<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		allCustomerDetails.toList().forEach(c -> cdr.add(mapper.convertValue(c, CustomerDetailsVO.class)));
		return new PageImpl<>(cdr, allCustomerDetails.getPageable(), allCustomerDetails.getTotalElements());
	}

	@Override
	public Page<CustomerDetailsVO> getAllAgencyDetailsReport(Integer pubId, String status, Pageable page) {
		EnumModelVO.CustomerStatus csStatus = null;
		CustomerStatus[] values = CustomerStatus.values();
		for (CustomerStatus cs : values) {
			if (cs.getCustomerStatus().equalsIgnoreCase(status)) {
				csStatus = cs;
				break;
			}
	}
		
		Page<CustomerDetails> allAgencyDetailsReport = customerDetailsRepo.findAllAgencyDetailsReport(pubId, csStatus , page);
		List<CustomerDetailsVO> cdr = new ArrayList<>();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		allAgencyDetailsReport.toList().forEach(c -> cdr.add(mapper.convertValue(c, CustomerDetailsVO.class)));
		return new PageImpl<>(cdr, allAgencyDetailsReport.getPageable(), allAgencyDetailsReport.getTotalElements());
	}

	@Override
	public Page<SalesListByOrderView> getAllSalesListByOrderViewReport(Integer pubId, Date orderStartDate,
			Date orderEndDate, String orderType, Pageable page) {
		if (orderStartDate == null) orderStartDate = new Date(0);
		if (orderEndDate == null) orderEndDate = new Date();
//		return paymentInfoRepo.findAllDailyCashReport(paymentStart, paymentEnd, page);
		
		Page<Order> allSalesListByOrderViewReport = addOrderRepo.findAllSalesListByOrderViewReport(pubId, orderStartDate, orderEndDate, orderType, page);
		List<SalesListByOrderView> sov = new ArrayList<>();
		
		allSalesListByOrderViewReport.toList().forEach(c -> {
			SalesListByOrderView obj = new SalesListByOrderView();
			obj.setOrderId(c.getOrderId());
			obj.setOrderDate(c.getKeyOrderInformation().getOrderDate());
			obj.setFname(c.getCustomerId().getFname());
			obj.setLname(c.getCustomerId().getLname());
			obj.setInitialName(c.getCustomerId().getInitialName());
			obj.setNetAmount(c.getPaymentBreakdown().getNetAmount());
			obj.setTax(c.getPaymentBreakdown().getTax());
			obj.setCommission(c.getPaymentBreakdown().getCommission());
			obj.setGrossAmount(c.getPaymentBreakdown().getGrossAmount());
			obj.setOrderStatus(c.getOrderStatus());
			obj.setPaymentStatus(c.getPaymentBreakdown().getPaymentStatus());
			
			sov.add(obj);
		});
		
		return new PageImpl<>(sov, allSalesListByOrderViewReport.getPageable(), allSalesListByOrderViewReport.getTotalElements());
		
	}

	@Override
	public Page<CreditCardDeclinedView> getAllCreditCardDeclinedViewReport(Integer pubId, Date paymentStartDate,
			Date paymentEndDate, Pageable page) {
		if (paymentStartDate == null) paymentStartDate = new Date(0);
		if (paymentEndDate == null) paymentEndDate = new Date();

		
		Page<MakePayment> allCreditCardDeclinedViewReport = makePaymentRepo.findAllCreditCardDeclinedViewReport(pubId, paymentStartDate, paymentEndDate,  page);
		List<CreditCardDeclinedView> ccdv = new ArrayList<>();
		
		allCreditCardDeclinedViewReport.toList().forEach(c -> {
			CreditCardDeclinedView obj = new CreditCardDeclinedView();
			obj.setPaymentDate(c.getCreatedAt());
			obj.setOrderId(c.getOrder().getOrderId());
			obj.setCreditCardNumber(c.getCard());
			obj.setCreditCardExpiryDate(c.getExpiryDate());
			obj.setBaseAmount(c.getBaseAmount());
			obj.setNameOfCustomer(c.getNameOfCustomer());
			obj.setCustomerNumber(c.getOrder().getCustomerId().getCustomerId());
			obj.setCurrency(c.getOrder().getPaymentBreakdown().getCurrency());
			obj.setLocalAmount(c.getOrder().getPaymentBreakdown().getCurrencyType());
			
			ccdv.add(obj);
			
	});
		return new PageImpl<>(ccdv, allCreditCardDeclinedViewReport.getPageable(), allCreditCardDeclinedViewReport.getTotalElements());
		
		
	}

	@Override
	public Page<DailyCreditCardAndPaymentReportView> getAllDailyCreditCardAndPaymentReport(Integer pubId,
			Date paymentStartDate, Date paymentEndDate, Pageable page) {
		if (paymentStartDate == null) paymentStartDate = new Date(0);
		if (paymentEndDate == null) paymentEndDate = new Date();

		
		Page<MakePayment> allDailyCreditCardAndPaymentReport = makePaymentRepo.findAllDailyCreditCardAndPaymentReport(pubId, paymentStartDate, paymentEndDate,  page);
		List<DailyCreditCardAndPaymentReportView> dccdv = new ArrayList<>();
		
		allDailyCreditCardAndPaymentReport.toList().forEach(c -> {
			DailyCreditCardAndPaymentReportView obj = new DailyCreditCardAndPaymentReportView();
			obj.setOrderNumber(c.getOrder().getOrderId());
			obj.setPaymentDate(c.getCreatedAt());
			obj.setCustomerNumber(c.getOrder().getCustomerId().getCustomerId());
			obj.setNameOfCustomer(c.getNameOfCustomer());
			obj.setOrderDate(c.getOrder().getCreatedAt());
			obj.setPaymentAmount(c.getAmountToBePaid());
			obj.setCurrency(c.getOrder().getPaymentBreakdown().getCurrency());
			obj.setPaymentBaseAmount(c.getBaseAmount());
			obj.setBundleQuantity(c.getOrder().getOrderItemsAndTerms().getCopiesPerIssue());
		
			dccdv.add(obj);
	});
		return new PageImpl<>(dccdv, allDailyCreditCardAndPaymentReport.getPageable(), allDailyCreditCardAndPaymentReport.getTotalElements());
		
}

	@Override
	public Page<SalesByMonthView> getAllSalesByMonthReport(Integer pubId, Integer volYear,Date paymentStartDate, Date paymentEndDate,
			PageRequest page) {
		if (paymentStartDate == null) paymentStartDate = new Date(0);
		if (paymentEndDate == null) paymentEndDate = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

 		Page<Object[]> allSalesByMonthReport = addOrderRepo.getAllSalesByMonthReport(pubId,volYear, paymentStartDate, paymentEndDate,  page);
  		List<SalesByMonthView> monthlySales = new ArrayList<>();
		for(Object[] allSalesByMonth :allSalesByMonthReport) {
 			SalesByMonthView obj = new SalesByMonthView();
 		    Timestamp createdAtTimestamp = (Timestamp) allSalesByMonth[1];
  		    LocalDateTime createdAt = createdAtTimestamp.toLocalDateTime();

   	        String month = createdAt.getMonth().toString();
  	       int years = createdAt.getYear();
			obj.setOrderClass((String)allSalesByMonth[6]);
			obj.setMonth(month);
			obj.setYear(years);
			obj.setBaseAmount((BigDecimal)allSalesByMonth[3]);
			obj.setBaseCurrency((String)allSalesByMonth[4]);
			obj.setOrderCategory((String)allSalesByMonth[7]);
			obj.setSubscriptionCategory((String)allSalesByMonth[5]); 
			
			monthlySales.add(obj);
	}
 		
		return new PageImpl<>(monthlySales, allSalesByMonthReport.getPageable(), allSalesByMonthReport.getTotalElements());

 	}

	@Override
	public Page<SalesByRegionVO> getAllSalesByRegionReport(Integer pubId, Integer volYear, String orderClass,
			String region, Date paymentStartDate, Date paymentEndDate, PageRequest of) {
		 Page<SalesByRegionVO>  salesByRegionReport=salesByRegionRepo.getAllSalesByRegionReport(pubId,volYear,orderClass,region,paymentStartDate,paymentEndDate,of);
		 List<SalesByRegionVO> salesByRegionVO = new ArrayList<>();
			
		 salesByRegionReport.toList().forEach(c -> {
			 SalesByRegionVO obj = new SalesByRegionVO();	
			 obj.setOrderId(c.getOrderId());
				obj.setOrderCategory(c.getOrderCategory());
				obj.setBaseAmount(c.getBaseAmount());
				obj.setCurrency(c.getCurrency());
				obj.setSubscriptionCategory(c.getSubscriptionCategory());
				obj.setOrderClass(c.getOrderClass());
				obj.setrList(c.getrList());
				obj.setCustId(c.getCustId());
				obj.setFirstName(c.getFirstName());
 				obj.setLastName(c.getLastName());
				obj.setFirstAddress(c.getFirstAddress());
 				obj.setSecondAddress(c.getSecondAddress());
 				obj.setDepartment(c.getDepartment());
 				obj.setCity(c.getCity());
 				obj.setCountry(c.getCountry());
				obj.setZipCode(c.getZipCode());
 				obj.setStartDate(c.getStartDate());
 				obj.setEndDate(c.getEndDate());
 				obj.setOrderDate(c.getOrderDate());
				obj.setNetAmount(c.getNetAmount());
				obj.setQuantityOrdered(c.getQuantityOrdered());
				obj.setPaymentType(c.getPaymentType());
				
				salesByRegionVO.add(obj);
		 });
		 return new PageImpl<>(salesByRegionVO, salesByRegionReport.getPageable(), salesByRegionReport.getTotalElements());

	}

	/*@Override
	public Page<TopNCustomersReportView> getAllTopNCustomersReport(Integer pubId, Integer volYear, String customerType, String country,
			String region, Date paymentStartDate, Date paymentEndDate, PageRequest of) {
 		Page<Object[]> topNCustomersReportView = salesByRegionRepo.getAllTopNCustomersReport(pubId,volYear,customerType,country,region, paymentStartDate, paymentEndDate,  of);
		
 		List<TopNCustomersReportView> topNCustomersReportViewList = new ArrayList<>();
		for(Object[] topNCustomersReport :topNCustomersReportView) {
			TopNCustomersReportView obj = new TopNCustomersReportView();
 		
			obj.setCustId((String)topNCustomersReport[0]);
			obj.setCurrency((String)topNCustomersReport[1]);
			obj.setRevenueAmount((String)topNCustomersReport[2]);
			obj.setCustomerCategory((String)topNCustomersReport[3]);
			obj.setFirstName((String)topNCustomersReport[4]);
			obj.setLastName((String)topNCustomersReport[5]);
			obj.setCompany((String)topNCustomersReport[6]);
			obj.setDepartment((String)topNCustomersReport[7]);
			 
			obj.setFirstAddress((String)topNCustomersReport[8]);
			obj.setSecondAddress((String)topNCustomersReport[9]);
			obj.setState((String)topNCustomersReport[10]);
			obj.setCity((String)topNCustomersReport[11]);
			obj.setZip((String)topNCustomersReport[12]);

			topNCustomersReportViewList.add(obj);
		}
		return new PageImpl<>(topNCustomersReportViewList, topNCustomersReportView.getPageable(), topNCustomersReportView.getTotalElements());

	}*/
}
	

	

	
	



	
		