package com.mps.think.setup.Strip;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import com.stripe.model.Token;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    String secretKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = secretKey;
    }

    public Charge charge(ChargeRequest chargeRequest)
            throws AuthenticationException, InvalidRequestException, APIConnectionException, CardException, APIException {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", chargeRequest.getAmount());
        chargeParams.put("currency", chargeRequest.getCurrency());
        chargeParams.put("description", chargeRequest.getDescription());
        chargeParams.put("source", chargeRequest.getStripeToken());
        return Charge.create(chargeParams);
    }
    
	public Refund refund(String chargeId) throws AuthenticationException, InvalidRequestException,
			APIConnectionException, CardException, APIException {
		Map<String, Object> params = new HashMap<>();
		params.put("charge", chargeId);
		Refund refund = Refund.create(params);
		return refund;
	}
	
	public Token token(String cardNumber,String expMonthYear,Integer cvc)throws AuthenticationException, InvalidRequestException,
	APIConnectionException, CardException, APIException { 
		String[] str=expMonthYear.split("@");
	Map<String, Object> card = new HashMap<>();
	card.put("number", cardNumber);
	card.put("exp_month", Integer.parseInt(str[0]));
	card.put("exp_year",Integer.parseInt(str[1]));
	card.put("cvc", cvc);
	Map<String, Object> params = new HashMap<>();
	params.put("card", card);

	Token tokens = Token.create(params);
	return tokens;
	}
}