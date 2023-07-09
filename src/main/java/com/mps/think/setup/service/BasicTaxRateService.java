package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.vo.BasicTaxRateVO;

public interface BasicTaxRateService {

	BasicTaxRate findbasicTaxRatebyId(Integer id);
	
	public BasicTaxRate saveBasicTaxRate(BasicTaxRateVO basicTaxRate);

	BasicTaxRate updateBasicTaxRate(BasicTaxRateVO basicTaxRateVo);

	List<BasicTaxRate> findAllbasicTaxRatebyId();

}
