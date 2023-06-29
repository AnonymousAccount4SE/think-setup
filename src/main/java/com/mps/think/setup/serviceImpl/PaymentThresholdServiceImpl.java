package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.model.PaymentThreshold;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.repo.PaymentThresholdRepo;
import com.mps.think.setup.service.PaymentThresholdService;
import com.mps.think.setup.vo.EnumModelVO.PaymentStatus;
import com.mps.think.setup.vo.PaymentThresholdVO;

@Service
public class PaymentThresholdServiceImpl implements PaymentThresholdService {

	@Autowired
	PaymentThresholdRepo paymentThresholdRepo;

	@Autowired
	AddOrderRepo addOrderRepo;

	@Override
	public List<PaymentThreshold> getAllPaymentThresholdForPublisher(Integer pubId) {
		return paymentThresholdRepo.findByPublisherId(pubId);
	}

	@Override
	public PaymentThreshold savePaymentThreshold(PaymentThresholdVO paymentThresholdVO) {
		ObjectMapper obj = new ObjectMapper();
		PaymentThreshold pThreshold = obj.convertValue(paymentThresholdVO, PaymentThreshold.class);
		PaymentThreshold threshold = paymentThresholdRepo.saveAndFlush(pThreshold);
		return threshold;
	}

	@Override
	public PaymentThreshold updatePaymentThreshold(PaymentThresholdVO paymentThresholdVO) {
		ObjectMapper obj = new ObjectMapper();
		PaymentThreshold pThreshold = obj.convertValue(paymentThresholdVO, PaymentThreshold.class);
		PaymentThreshold threshold = paymentThresholdRepo.saveAndFlush(pThreshold);
		return threshold;
	}

	@Override
	public PaymentThreshold findByPaymentThresholdId(Integer id) {
		return paymentThresholdRepo.findById(id).get();
	}


	@Override
	public List<HashMap<String, String>> definePayment(LinkedHashMap<Integer, String> amount,
			Integer paymentThresholdId) {
		List<HashMap<String, String>> list = new ArrayList<>();

		Optional<PaymentThreshold> threshold = paymentThresholdRepo.findById(paymentThresholdId);
		if (threshold.isPresent()) {
			for (Map.Entry<Integer, String> entry : amount.entrySet()) {
				HashMap<String, String> payment = new HashMap<>();
				String[] str = entry.getValue().split(",");
				double invoiceAmount = Double.parseDouble(str[0]);
				double paidAmount = Double.parseDouble(str[1]);

				double paidPercentage = (paidAmount * 100) / invoiceAmount;
				double unPaidAmount = Math.abs(invoiceAmount - paidAmount);

				String paymentStatus;

				if (paidPercentage == 100) {
//					paymentStatus = "Paid";
					paymentStatus = PaymentStatus.PAID.getDisplayName();
				} else if (paidPercentage == 0) {
//					paymentStatus = "No Payment";
					paymentStatus = PaymentStatus.NO_PAYMENT.getDisplayName();
				} else if (paidPercentage <= threshold.get().getPartialThreshold()) {
//					paymentStatus = "Partial Payment";
					paymentStatus = PaymentStatus.PARTIAL_PAYMENT.getDisplayName();
				} else if (paidPercentage < threshold.get().getUnderThreshold()) {
					if ((int) unPaidAmount <= threshold.get().getMaxUnderpaymentForPartial()) {
//						paymentStatus = "Paid - Underpayment";
						paymentStatus = PaymentStatus.PAID_UNDERPAYMENT.getDisplayName();
					} else {
//						paymentStatus = "Underpayment";
						paymentStatus = PaymentStatus.UNDERPAYMENT.getDisplayName();
					}
				} else if (paidPercentage <= threshold.get().getOverThreshold()) {
					if ((int) unPaidAmount <= threshold.get().getMaxUnderpaymentForFull()) {
//						paymentStatus = "Paid - Overpayment";
						paymentStatus = PaymentStatus.PAID_OVERPAYMENT.getDisplayName();
					} else if ((int) unPaidAmount > threshold.get().getMaxUnderpaymentForPartial()) {
//						paymentStatus = "Partial Payment";
						paymentStatus = PaymentStatus.PARTIAL_PAYMENT.getDisplayName();
					} else {
//						paymentStatus = "Underpayment";
						paymentStatus = PaymentStatus.UNDERPAYMENT.getDisplayName();
					}
				} else if (paidPercentage <= threshold.get().getRefundThreshold()) {
					if ((int) unPaidAmount <= threshold.get().getMaxOverpaymentForFull()) {
//						paymentStatus = "Paid - Overpayment";
						paymentStatus = PaymentStatus.PAID_OVERPAYMENT.getDisplayName();
					} else if ((int) unPaidAmount > threshold.get().getMaxOverpaymentForRefund()) {
//						paymentStatus = "Refund payments";
						paymentStatus = PaymentStatus.REFUND_PAYMENTS.getDisplayName();
					} else {
//						paymentStatus = "Overpayment";
						paymentStatus = PaymentStatus.OVERPAYMENT.getDisplayName();
					}
				} else {
//					paymentStatus = "Refund payments";
					paymentStatus = PaymentStatus.REFUND_PAYMENTS.getDisplayName();
				}

				payment.put("paymentStatus", entry.getKey() + "," + paymentStatus);
				list.add(payment);
			}
		}

		return list;
	}

	@Override
	public PaymentThreshold DeletePaymentThreshold(Integer id) {
		PaymentThreshold remove = paymentThresholdRepo.findById(id).get();
		if (remove != null) {
			paymentThresholdRepo.delete(remove);
		}
		return remove;
	}

	@Override
	public List<PaymentThreshold> defaultStatus(PaymentThresholdVO paymentThresholdVO) {
		List<PaymentThreshold> list = paymentThresholdRepo.findByPublisherId(paymentThresholdVO.getPublisher().getId());
		ObjectMapper obj = new ObjectMapper();
		PaymentThreshold pThresholdnew, thresh;
		List<PaymentThreshold> response = new ArrayList<>();
		for (PaymentThreshold pthreshold : list) {
			if (Objects.equals(paymentThresholdVO.getPaymentThresholdId(), pthreshold.getPaymentThresholdId())) {
				pThresholdnew = obj.convertValue(pthreshold, PaymentThreshold.class);
				pThresholdnew.setStatus(true);
				thresh = paymentThresholdRepo.saveAndFlush(pThresholdnew);
				response.add(thresh);
			} else {
				pThresholdnew = obj.convertValue(pthreshold, PaymentThreshold.class);
				pThresholdnew.setStatus(false);
				thresh = paymentThresholdRepo.saveAndFlush(pThresholdnew);
				response.add(thresh);
			}
		}
		return response;
	}

	@Override
	public List<PaymentThreshold> getAllPaymentThreshold() {
		return paymentThresholdRepo.findAll();
	}
}
