package com.mps.think.setup.Strip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mps.think.setup.Strip.ChargeRequest.Currency;
import com.mps.think.setup.model.Order;
import com.mps.think.setup.model.PaymentBreakdown;
import com.mps.think.setup.repo.AddOrderRepo;
import com.mps.think.setup.vo.PublicKey;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@RestController
public class ChargeController {

	@Autowired
	StripeService paymentsService;
	
	@Autowired
	AddOrderRepo addOrderRepo;

//	@PostMapping("/charge")
//	public Charge charge(ChargeRequest chargeRequest, Model model) throws StripeException {
//		chargeRequest.setDescription("Example charge");
//		chargeRequest.setCurrency(Currency.EUR);
//		Charge charge = paymentsService.charge(chargeRequest);
//		model.addAttribute("id", charge.getId());
//		model.addAttribute("status", charge.getStatus());
//		model.addAttribute("chargeId", charge.getId());
//		model.addAttribute("balance_transaction", charge.getBalanceTransaction());
//		System.out.println(chargeRequest.toString());
//		System.out.println(charge.toString());
//		return charge;
//	}

	@ExceptionHandler(StripeException.class)
	public String handleError(Model model, StripeException ex) {
		model.addAttribute("error", ex.getMessage());
		return "result" + ex.getMessage();
	}

	@PostMapping("/chargeAPI")
	public ResponseEntity<?> chargeAPI(@RequestBody ChargeRequest chargeRequest) throws StripeException {
		chargeRequest.setDescription("Example charge");
		if (chargeRequest.getCurrency().EUR.toString() == "EUR") {
			chargeRequest.setCurrency(Currency.EUR);
		}else {
		chargeRequest.setCurrency(Currency.USD);
		}
		Charge charge = paymentsService.charge(chargeRequest);
		PublicKey pk = new PublicKey();
		pk.setId(charge.getId());
		pk.setStatus(charge.getStatus());
		pk.setBalanceTransaction(charge.getBalanceTransaction());
		
		Order orderDetails = addOrderRepo.findById(chargeRequest.getOrderId()).get();
//		Order od=new Order();
//		od.setOrderId(orderDetails.getOrderId());
//		PaymentBreakdown pb=new PaymentBreakdown();
//		pb.setId(orderDetails.getPaymentBreakdown().getId());
//		pb.setPaymentStatus(orderDetails.getPaymentBreakdown().getPaymentStatus());
//		od.setPaymentBreakdown(pb);
//		addOrderRepo.saveAndFlush(od);
		PaymentBreakdown paymentBreakdown = orderDetails.getPaymentBreakdown();
		if(charge.getStatus().equals("succeeded")) {
		paymentBreakdown.setPaymentStatus("Paid");
		orderDetails.setPaymentBreakdown(paymentBreakdown);
		addOrderRepo.saveAndFlush(orderDetails);
		}
		
		System.out.println(chargeRequest.toString());
		System.out.println(charge.toString());
		return ResponseEntity.ok(pk);
	}

	@PostMapping("/refundAPI")
	public ResponseEntity<?> refundAPI(String chargeId,Integer orderId) throws StripeException {
//		Stripe.apiKey = "sk_test_FQFXEQMTnWlgu1ckpre5Ka4000VeYdxCdU";
//		Map<String, Object> params = new HashMap<>();
//		params.put("charge", chargeId);cus_NYjc8h13frsnR1
//		Refund refund = Refund.create(params);
		Refund refund = paymentsService.refund(chargeId);
		System.out.println(refund.toString());
		Order orderDetails = addOrderRepo.findById(orderId).get();
		PaymentBreakdown paymentBreakdown = orderDetails.getPaymentBreakdown();
		if(refund.getStatus().equals("succeeded")) {
		paymentBreakdown.setPaymentStatus("No-Payment-Refunded");
		orderDetails.setPaymentBreakdown(paymentBreakdown);
		addOrderRepo.saveAndFlush(orderDetails);
		}
		return ResponseEntity.ok(refund);
	}

}