package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.PaymentInformation;
import com.mps.think.setup.repo.PaymentInformationRepo;
import com.mps.think.setup.service.PaymentInformationService;
import com.mps.think.setup.vo.PaymentInformationVO;

@Service
public class PaymentInformationServiceImpl implements PaymentInformationService {

	@Autowired
	PaymentInformationRepo paymentInformationRepo;
	
	@Autowired
	ObjectMapper mapper;

	@Override
	public Page<PaymentInformation> getallPaymentInformationForPublisher(Integer pub, Pageable page) {
		return paymentInformationRepo.findByPublisherId(pub, page);
	}

	@Override
	public List<PaymentInformation> savePayInfo(List<PaymentInformationVO> paymentInformationVO) {
//		ObjectMapper mapper = new ObjectMapper();
//		PaymentInformation payInfo = mapper.convertValue(paymentInformationVO, PaymentInformation.class);
		
		List<PaymentInformation> list=new ArrayList<>();
		for(PaymentInformationVO pInfo:paymentInformationVO) {
		PaymentInformation cdata = paymentInformationRepo.saveAndFlush(mapper.convertValue(pInfo, PaymentInformation.class));
		list.add(cdata);
		}
		return list;
	}

	@Override
	public PaymentInformation findByPaymentInfoId(Integer id) {
		return paymentInformationRepo.findById(id).get();
	}

	@Override
	public Page<PaymentInformation> getallPaymentInformationForCustomer(Integer customerId, Pageable page) {
		return paymentInformationRepo.findByOrderCustomerIdCustomerId(customerId, page);
	}

	@Override
	public Page<PaymentInformation> getPaymentInformationByOrderId(Integer orderId, Pageable page) {
		return paymentInformationRepo.findByOrderOrderId(orderId, page);
	}

	@Override
	public List<PaymentInformation> getAllPaymentInformation() {
		return paymentInformationRepo.findAll();
	}

	@Override
	public List<String> findAllColumnForPaymentInfo() {
		return paymentInformationRepo.findAllColumnForPaymentInfo();
	}

	@Override
	public double dueAmount(Integer orderId) {
		double due;
		if(paymentInformationRepo.paidAmount(orderId) ==null) {
			due= paymentInformationRepo.netAmount(orderId);
		}else {
		due= paymentInformationRepo.netAmount(orderId)-paymentInformationRepo.paidAmount(orderId);
		}
		return due;
	}

	@Override
	public double refundAmount(Integer orderId) {
		double refundAmount;
		try {
			double eachIssuePrice=paymentInformationRepo.netAmount(orderId)/paymentInformationRepo.totalIssueOrder(orderId);
			refundAmount=eachIssuePrice*paymentInformationRepo.totaLiabilityIssue(orderId);
			return refundAmount;
		}catch (Exception e) {
			e.getStackTrace();
			return 0.0;
		}
	}

}
