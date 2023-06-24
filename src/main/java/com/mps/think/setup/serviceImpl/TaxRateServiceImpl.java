package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.Publisher;
import com.mps.think.setup.model.TaxRate;
import com.mps.think.setup.repo.TaxRateRepo;
import com.mps.think.setup.service.TaxRateService;
import com.mps.think.setup.vo.TaxRateVO;

@Service
public class TaxRateServiceImpl implements TaxRateService {
	@Autowired
	TaxRateRepo taxRateRepo;

	@Override
	public List<TaxRate> findAllTaxType() {
		return taxRateRepo.findAll();
	}

	@Override
	public TaxRateVO saveTaxRate(TaxRateVO taxRateVO) {
		TaxRate taxRate = new TaxRate();
		taxRate.setState(taxRateVO.getState());
		taxRate.setCountry(taxRateVO.getCountry());
		taxRate.setTaxidPrefix(taxRateVO.getTaxidPrefix());
		taxRate.setTaxHandling(taxRateVO.getTaxHandling());
		taxRate.setTaxid_format(taxRateVO.getTaxid_format());
		taxRate.setTaxId(taxRateVO.getTaxId());
		taxRate.setAltStateCode(taxRateVO.getAltStateCode());
		taxRate.setNoTaxMessage1(taxRateVO.getNoTaxMessage1());
		taxRate.setNoTaxMessage2(taxRateVO.getNoTaxMessage2());
		Publisher publisher = new Publisher();
		publisher.setId(taxRateVO.getPubId().getId());
		taxRate.setPubId(publisher);
		taxRate = taxRateRepo.save(taxRate);
		taxRateVO.setTaxId(taxRate.getTaxId());
		return taxRateVO;
	}

	@Override
	public TaxRateVO updateTaxRate(TaxRateVO taxRateVO) {
		TaxRate taxRate = new TaxRate();
		taxRate.setState(taxRateVO.getState());
		taxRate.setCountry(taxRateVO.getCountry());
		taxRate.setTaxidPrefix(taxRateVO.getTaxidPrefix());
		taxRate.setTaxHandling(taxRateVO.getTaxHandling());
		taxRate.setTaxid_format(taxRateVO.getTaxid_format());
		taxRate.setTaxId(taxRateVO.getTaxId());
		taxRate.setAltStateCode(taxRateVO.getAltStateCode());
		taxRate.setNoTaxMessage1(taxRateVO.getNoTaxMessage1());
		taxRate.setNoTaxMessage2(taxRateVO.getNoTaxMessage2());
		Publisher publisher = new Publisher();
		publisher.setId(taxRateVO.getPubId().getId());
		taxRate.setPubId(publisher);
		taxRate = taxRateRepo.save(taxRate);
		return taxRateVO;
	}

	@Override
	public TaxRate findbyTaxRate(Integer taxId) {
		return taxRateRepo.findById(taxId).get();
	}

	@Override
	public TaxRate deleteByTaxRateId(Integer taxId) {
		TaxRate delete = taxRateRepo.findByTaxId(taxId);
		taxRateRepo.delete(delete);
		return delete;
	}


	

}
