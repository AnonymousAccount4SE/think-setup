package com.mps.think.setup.service;

import com.mps.think.setup.model.BasicJurisdictionTaxRate;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;

public interface BasicJurisdictionTaxRateService {

	BasicJurisdictionTaxRate savebasicJurisdictionTaxRate(BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO);

	BasicJurisdictionTaxRate findbasicJurisdictionTaxRatebyId(Integer jurisdictionsId);
	

}
