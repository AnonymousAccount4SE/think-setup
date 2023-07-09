package com.mps.think.setup.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.TaxHandling;
import com.mps.think.setup.repo.TaxHandlingRepo;
import com.mps.think.setup.service.TaxHandlingService;
import com.mps.think.setup.vo.TaxHandlingVO;

@Service
public class TaxHandlingServiceImpl implements TaxHandlingService {

	@Autowired
	private TaxHandlingRepo taxHandlingRepo;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public List<TaxHandling> getAllTaxHandling() {
		return taxHandlingRepo.findAll();
	}

	@Override
	public TaxHandling saveAddTaxHandling(TaxHandlingVO taxHandlingVO) {

		return taxHandlingRepo.saveAndFlush(mapper.convertValue(taxHandlingVO, TaxHandling.class));
	}

	@Override
	public TaxHandling updateAddTaxHandling(TaxHandlingVO taxHandlingVO) {
		return taxHandlingRepo.saveAndFlush(mapper.convertValue(taxHandlingVO, TaxHandling.class));

	}

	@Override
	public TaxHandling findbyAddTaxHandlingId(Integer id) {
		return taxHandlingRepo.findById(id).get();
	}

	@Override
	public TaxHandling deleteByTaxHandlingId(Integer id) {
		TaxHandling delete = findbyAddTaxHandlingId(id);
		taxHandlingRepo.delete(delete);
		return delete;
	}

	public List<TaxHandling> findbyAddTaxHandlingpubId(Integer pubId) {
		// TODO Auto-generated method stub
		return taxHandlingRepo.findBypubId(pubId);
	}
}
