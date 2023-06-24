package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mps.think.setup.model.PaymentInformation;
import com.mps.think.setup.vo.PaymentInformationVO;

public interface PaymentInformationService {
	
	public Page<PaymentInformation> getallPaymentInformationForPublisher(Integer pub, Pageable page);
	
	public Page<PaymentInformation> getallPaymentInformationForCustomer(Integer customerId, Pageable page);
	
	public List<PaymentInformation> savePayInfo(List<PaymentInformationVO> paymentInformationVO);
	
	public PaymentInformation findByPaymentInfoId(Integer  id);
	
	public Page<PaymentInformation> getPaymentInformationByOrderId(Integer orderId, Pageable page);

	public List<PaymentInformation> getAllPaymentInformation();
	
	public  List<String> findAllColumnForPaymentInfo();

}
