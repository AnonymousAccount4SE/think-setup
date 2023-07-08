package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

		List<PaymentInformation> list = new ArrayList<>();
		for (PaymentInformationVO pInfo : paymentInformationVO) {
			PaymentInformation cdata = paymentInformationRepo
					.saveAndFlush(mapper.convertValue(pInfo, PaymentInformation.class));
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
		if (paymentInformationRepo.paidAmount(orderId) == null) {
			due = paymentInformationRepo.netAmount(orderId);
		} else {
			due = paymentInformationRepo.netAmount(orderId) - paymentInformationRepo.paidAmount(orderId);
		}
		return due;
	}

	@Override
	public double refundAmount(Integer orderId) {
	    double refundAmount = 0.0;
	    double eachIssuePrice = 0.0;
	    try {
	        double netAmount = paymentInformationRepo.netAmount(orderId);
	        double paidAmount = paymentInformationRepo.paidAmount(orderId);
	        int totalIssueOrder = paymentInformationRepo.totalIssueOrder(orderId);
	        int totalLiabilityIssue = paymentInformationRepo.totaLiabilityIssue(orderId);
	        
	        if (netAmount <= paidAmount && totalIssueOrder > 0) {
	            eachIssuePrice = netAmount / totalIssueOrder;
	            refundAmount = eachIssuePrice * totalLiabilityIssue;
	        } else {
	            eachIssuePrice = netAmount / totalIssueOrder;
	            int deliveredIssue = totalIssueOrder - totalLiabilityIssue;
	            double temp = eachIssuePrice * deliveredIssue;
	            refundAmount = paidAmount - temp;
	            
	            if (refundAmount <= 0) {
	                refundAmount = 0.0;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return refundAmount;
	}

	@Override
	public List<PaymentInformation> getPaymentInfoForOrder(Integer orderId) {
		return paymentInformationRepo.findByOrderOrderId(orderId);
	}

//	public double refundAmount(Integer orderId) {
//		double refundAmount,temp;
//		double eachIssuePrice;
//		if (paymentInformationRepo.netAmount(orderId) <= paymentInformationRepo.paidAmount(orderId)
//				&& paymentInformationRepo.totalIssueOrder(orderId) > 0) {
//			eachIssuePrice = paymentInformationRepo.netAmount(orderId)
//					/ paymentInformationRepo.totalIssueOrder(orderId);
//			refundAmount = eachIssuePrice * paymentInformationRepo.totaLiabilityIssue(orderId);
//			
//		}else {
//			eachIssuePrice = paymentInformationRepo.netAmount(orderId)
//					/ paymentInformationRepo.totalIssueOrder(orderId);
//			Integer deliveredIssue=paymentInformationRepo.totalIssueOrder(orderId)-paymentInformationRepo.totaLiabilityIssue(orderId);
//			temp=eachIssuePrice *deliveredIssue;
//			refundAmount =paymentInformationRepo.paidAmount(orderId)-temp; 
//			if(refundAmount<=0) {
//				refundAmount=0.0;
//			}
//		}
//		return refundAmount;
//	}

}
