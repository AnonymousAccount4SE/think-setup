package com.mps.think.setup.service;

import com.mps.think.setup.model.AddEffort;
import com.mps.think.setup.model.BasicTaxRate;
import com.mps.think.setup.vo.AddEffortVO;
import com.mps.think.setup.vo.BasicTaxRateVO;

public interface BasicTaxRateService {

	BasicTaxRate findbasicTaxRatebyId(Integer id);
	
	public BasicTaxRate saveBasicTaxRate(BasicTaxRateVO basicTaxRate);

}
