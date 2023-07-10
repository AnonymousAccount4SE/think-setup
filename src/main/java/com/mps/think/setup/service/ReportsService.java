package com.mps.think.setup.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.vo.CancelSubscirptionReportView;
import com.mps.think.setup.vo.CreditCardDeclinedView;
import com.mps.think.setup.vo.CustomerDetailsVO;
import com.mps.think.setup.vo.DailyCashReportView;
import com.mps.think.setup.vo.DailyCreditCardAndPaymentReportView;
import com.mps.think.setup.vo.RefundProcessReportView;
import com.mps.think.setup.vo.SalesByMonthView;
import com.mps.think.setup.vo.SalesByRegionVO;
import com.mps.think.setup.vo.SalesListByOrderView;
import com.mps.think.setup.vo.TopNCustomersReportView;

public interface ReportsService {

	Page<Order> getAllOrderReports(Integer pubId, String orderStatus, Date ordersFrom, Date ordersTill, Integer customerId,
			String customerName, Pageable page);
	
	Page<CustomerDetails>getAllCustomerSearchReport(Integer pubId, Integer customerId, String fname, String lname, String initialName,
			String email, String company, String department, String country, String state, String city, Integer zipCode, Pageable page);
	
    Page<CancelSubscirptionReportView> getAllCancelledSubscriptions(Integer pubId, Date orderFrom, Date orderTill, String currencyType, Pageable page);
    
	Page<Order> getAllCustomerSalesList(Integer pubId, Date oredrStart, Date orderEnd, String orderType, Pageable page);
	
	Page<DailyCashReportView> getAllDailyCashReport(Integer pubId, Date paymentStart, Date paymentEnd, Pageable page);
	
	Page<RefundProcessReportView> getAllRefundProcessReport(Integer pubId, Date startRefund, Date endRefund, Pageable page);

	Page<CustomerDetailsVO> getAllCustomerDetatilsReport(Integer pubId, String status, Pageable page);
	
	Page<CustomerDetailsVO> getAllAgencyDetailsReport(Integer pubId, String status, Pageable page);
	
	Page<SalesListByOrderView> getAllSalesListByOrderViewReport(Integer pubId, Date orderStartDate, Date orderEndDate, String orderType, Pageable page);
    
	Page<CreditCardDeclinedView>getAllCreditCardDeclinedViewReport(Integer pubId, Date paymentStartDate, Date paymentEndDate, Pageable page);
	
	Page<DailyCreditCardAndPaymentReportView>getAllDailyCreditCardAndPaymentReport(Integer pubId, Date paymentStartDate, Date paymentEndDate, Pageable page);

	Page<SalesByMonthView> getAllSalesByMonthReport(Integer pubId, Integer volYear, Date paymentStartDate1, Date paymentEndDate1, PageRequest of);

	Page<SalesByRegionVO> getAllSalesByRegionReport(Integer pubId, Integer volYear, String orderClass, String region,
			Date paymentStartDate1, Date paymentEndDate1, PageRequest of);

	Page<TopNCustomersReportView> getAllTopNCustomersReport(Integer pubId, Integer volYear, String customerType, String country,
			String region, Date paymentStartDate1, Date paymentEndDate1, PageRequest of);
	

	

}
