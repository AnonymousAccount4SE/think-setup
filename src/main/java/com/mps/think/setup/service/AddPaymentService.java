package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import com.mps.think.setup.model.AddPayment;
import com.mps.think.setup.vo.AddPaymentVO;

public interface AddPaymentService {
	
	public List<AddPayment> findAllPaymentForPublisher(Integer pubId);
	
	public AddPayment savePayment(AddPaymentVO paymentVO);
	
	public AddPayment updatePayment(AddPaymentVO paymentVO);
	
	public AddPayment findbyPaymentId(Integer id);
	
	public List<AddPayment> findByCustomerDetailsCustomerId(Integer customerId);

	public List<AddPayment> getAllAddPayment();

}
