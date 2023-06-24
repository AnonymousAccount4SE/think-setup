package com.mps.think.setup.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.mps.think.setup.Strip.StripeService;
import com.mps.think.setup.model.AddPayment;
import com.mps.think.setup.model.CustomerDetails;
import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.repo.AddPaymentRepo;
import com.mps.think.setup.service.AddPaymentService;
import com.mps.think.setup.utils.IntegerToRoman;
import com.mps.think.setup.vo.AddPaymentVO;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Token;

@Service
public class AddPaymentServiceImpl implements AddPaymentService {

	@Autowired
	AddPaymentRepo addPaymentRepo;
	@Autowired
	StripeService stripeService;

	@Override
	public List<AddPayment> findAllPaymentForPublisher(Integer pubId) {
		return addPaymentRepo.findByPublisherId(pubId);
	}

	@Override
	public AddPayment savePayment(AddPaymentVO paymentVO) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		AddPayment addPayment = new AddPayment();
		if (paymentVO.isSelectCreditCard()) {
			addPayment.setTypeOfPaymentAccount(paymentVO.getTypeOfPaymentAccount());
			addPayment.setSelectCreditCard(paymentVO.isSelectCreditCard());
			addPayment.setCreditCard(paymentVO.getCreditCard());
			addPayment.setCardType(paymentVO.getCardType());
			addPayment.setNameOfCardHolder(paymentVO.getNameOfCardHolder());
			addPayment.setValidFrom(paymentVO.getValidFrom());
			addPayment.setValidTo(paymentVO.getValidTo());
			CustomerDetails customer = new CustomerDetails();
			customer.setCustomerId(paymentVO.getCustomerDetails().getCustomerId());
			addPayment.setCustomerDetails(customer);
			Publisher publisher = new Publisher();
			publisher.setId(paymentVO.getPublisher().getId());
			addPayment.setPublisher(publisher);
			AddPayment data = addPaymentRepo.save(addPayment);
			return data;
		} else if (paymentVO.isSelectCreditCardWithToken()) {
			String expMonthYear = IntegerToRoman.getMonthYear(paymentVO.getValidTo());
			Token tempToken = stripeService.token(paymentVO.getCreditCard(), expMonthYear, paymentVO.getCvc());
			addPayment.setTypeOfPaymentAccount(paymentVO.getTypeOfPaymentAccount());
			addPayment.setSelectCreditCardWithToken(paymentVO.isSelectCreditCardWithToken());
			addPayment.setToken(tempToken.getId());
			addPayment.setCreditCardLastDigit(IntegerToRoman.getLastFourDigits(paymentVO.getCreditCard()));
			addPayment.setCardType(paymentVO.getCardType());
			addPayment.setNameOfCardHolder(paymentVO.getNameOfCardHolder());
			addPayment.setValidFrom(paymentVO.getValidFrom());
			addPayment.setValidTo(paymentVO.getValidTo());
			CustomerDetails customer = new CustomerDetails();
			customer.setCustomerId(paymentVO.getCustomerDetails().getCustomerId());
			addPayment.setCustomerDetails(customer);
			Publisher publisher = new Publisher();
			publisher.setId(paymentVO.getPublisher().getId());
			addPayment.setPublisher(publisher);
			AddPayment data = addPaymentRepo.save(addPayment);
			return data;
		} else {
			return null;
		}
	}

	@Override
	public AddPayment updatePayment(AddPaymentVO paymentVO) {
		AddPayment addPayment = new AddPayment();
		if (true == paymentVO.isSelectCreditCard()) {
			addPayment.setId(paymentVO.getId());
			addPayment.setTypeOfPaymentAccount(paymentVO.getTypeOfPaymentAccount());
			addPayment.setSelectCreditCard(paymentVO.isSelectCreditCard());
			addPayment.setCreditCard(paymentVO.getCreditCard());
			addPayment.setCardType(paymentVO.getCardType());
			addPayment.setNameOfCardHolder(paymentVO.getNameOfCardHolder());
			addPayment.setValidFrom(paymentVO.getValidFrom());
			addPayment.setValidTo(paymentVO.getValidTo());
			CustomerDetails customer = new CustomerDetails();
			customer.setCustomerId(paymentVO.getCustomerDetails().getCustomerId());
			addPayment.setCustomerDetails(customer);
			Publisher publisher = new Publisher();
			publisher.setId(paymentVO.getPublisher().getId());
			addPayment.setPublisher(publisher);
			AddPayment data = addPaymentRepo.save(addPayment);
			return data;
		}
		addPayment.setId(paymentVO.getId());
		addPayment.setTypeOfPaymentAccount(paymentVO.getTypeOfPaymentAccount());
		addPayment.setSelectCreditCardWithToken(paymentVO.isSelectCreditCardWithToken());
		addPayment.setToken(paymentVO.getToken());
		addPayment.setCreditCardLastDigit(paymentVO.getCreditCardLastDigit());
		addPayment.setCardType(paymentVO.getCardType());
		addPayment.setNameOfCardHolder(paymentVO.getNameOfCardHolder());
		addPayment.setValidFrom(paymentVO.getValidFrom());
		addPayment.setValidTo(paymentVO.getValidTo());
		CustomerDetails customer = new CustomerDetails();
		customer.setCustomerId(paymentVO.getCustomerDetails().getCustomerId());
		addPayment.setCustomerDetails(customer);
		Publisher publisher = new Publisher();
		publisher.setId(paymentVO.getPublisher().getId());
		addPayment.setPublisher(publisher);
		AddPayment data = addPaymentRepo.save(addPayment);
		return data;
	}

	@Override
	public AddPayment findbyPaymentId(Integer id) {
		return addPaymentRepo.findById(id).get();
	}

	@Override
	public List<AddPayment> findByCustomerDetailsCustomerId(Integer customerId) {
		List<AddPayment> data = addPaymentRepo.findByCustomerDetailsCustomerId(customerId);
//		if(null==data){
//		 throw new NoSuchElementException("plz add payment details");
//		}
		return data;
	}

	@Override
	public List<AddPayment> getAllAddPayment() {
		return addPaymentRepo.findAll();
	}

}
