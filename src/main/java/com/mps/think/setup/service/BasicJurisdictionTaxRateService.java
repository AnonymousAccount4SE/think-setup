package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.BasicJurisdictionTaxRate;
import com.mps.think.setup.vo.BasicJurisdictionTaxRateVO;

public interface BasicJurisdictionTaxRateService {

	BasicJurisdictionTaxRate savebasicJurisdictionTaxRate(BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO);

	BasicJurisdictionTaxRate findbasicJurisdictionTaxRatebyId(Integer jurisdictionsId);
	
	List<BasicJurisdictionTaxRate> findbasicJurisdictionTaxRateByPubId(Integer pubId);

	public BasicJurisdictionTaxRate updatebasicJurisdictionTaxRate(BasicJurisdictionTaxRateVO basicJurisdictionTaxRateVO);

	List<BasicJurisdictionTaxRate> findbasicJurisdictionTaxRate();
	

}
