package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import com.mps.think.setup.model.PaymentInformation;
import com.mps.think.setup.vo.PaymentInformationVO;

public interface PaymentInformationService {
	
	public List<PaymentInformation> getallPaymentInformationForPublisher(Integer pub);
	
	public List<PaymentInformation> getallPaymentInformationForCustomer(Integer customerId);
	
	public PaymentInformation savePayInfo(PaymentInformationVO paymentInformationVO);
	
	public Optional<PaymentInformation> findByPaymentInfoId(Integer  id);
	
	public PaymentInformation getPaymentInformationByOrderId(Integer orderId);

}
