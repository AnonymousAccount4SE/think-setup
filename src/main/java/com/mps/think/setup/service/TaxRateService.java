package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.TaxRate;
import com.mps.think.setup.vo.TaxRateVO;

public interface TaxRateService {

	public List<TaxRate> findAllTaxType();

	public TaxRateVO saveTaxRate(TaxRateVO taxRateVO);

	public TaxRateVO updateTaxRate(TaxRateVO taxRateVO);

	public TaxRate findbyTaxRate(Integer taxId);
	
	public TaxRate deleteByTaxRateId(Integer taxId);
	
}
