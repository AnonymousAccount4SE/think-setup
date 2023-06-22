package com.mps.think.setup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mps.think.setup.model.TaxHandling;
import com.mps.think.setup.vo.TaxHandlingVO;


@Service
public interface TaxHandlingService {
	
	public List<TaxHandling> getAllTaxHandling();
	
	public TaxHandling saveAddTaxHandling(TaxHandlingVO taxHandlingVO);

	public TaxHandling updateAddTaxHandling(TaxHandlingVO taxHandlingVO);

	public TaxHandling findbyAddTaxHandlingId(Integer id);
	
	public TaxHandling deleteByTaxHandlingId(Integer id);

}
