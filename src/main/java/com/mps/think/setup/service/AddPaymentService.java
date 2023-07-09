package com.mps.think.setup.service;

import java.util.List;
import java.util.Optional;

import com.mps.think.setup.model.AddPayment;
import com.mps.think.setup.vo.AddPaymentVO;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;

public interface AddPaymentService {
	
	public List<AddPayment> findAllPaymentForPublisher(Integer pubId);
	
	public AddPayment savePayment(AddPaymentVO paymentVO) throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException;
	
	public AddPayment updatePayment(AddPaymentVO paymentVO);
	
	public AddPayment findbyPaymentId(Integer id);
	
	public List<AddPayment> findByCustomerDetailsCustomerId(Integer customerId);

	public List<AddPayment> getAllAddPayment();

}
