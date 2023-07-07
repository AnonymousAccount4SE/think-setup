package com.mps.think.setup.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.model.CommodityCodes;
import com.mps.think.setup.repo.BasicCommodityTaxRateRepo;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.service.CommodityCodesService;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;

@Service
public class BasicCommodityTaxRateServiceImpl implements BasicCommodityTaxRateService {

	@Autowired
	BasicCommodityTaxRateRepo basicCommodityTaxRateRepo;
	@Autowired
	CommodityCodesService commodityCodesService;
	@Autowired
	private ObjectMapper mapper;
	
	@Override
	public List<BasicCommodityTaxRate> findAllbasicCommodityTaxRate() {
		return basicCommodityTaxRateRepo.findAll();
	}
	@Override
	public BasicCommodityTaxRate getbasicCommodityTaxRateById(Integer commodityCodesId) {
		return basicCommodityTaxRateRepo.findBycommodityCodesId(commodityCodesId);
	}
	
	@Override
	public List<BasicCommodityTaxRate> getbasicCommodityTaxRateByPubId(Integer pubId) {
		List<CommodityCodes> commodityCodes = commodityCodesService.findAllCommodityCodesForPublisher(pubId);
		List<BasicCommodityTaxRate> basicCommodityTaxRate= new ArrayList<BasicCommodityTaxRate>();
		for(CommodityCodes data:commodityCodes) {
			data.getId();
			BasicCommodityTaxRate BasicCommodity = basicCommodityTaxRateRepo.findBycommodityCodesId(data.getId());
			basicCommodityTaxRate.add(BasicCommodity);
		}
		return basicCommodityTaxRate;
	}

	@Override
	public BasicCommodityTaxRate saveBasicCommodityTaxRateDetails(BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
		return basicCommodityTaxRateRepo.saveAndFlush(mapper.convertValue(basicCommodityTaxRateVO, BasicCommodityTaxRate.class));
	}

	@Override
	public BasicCommodityTaxRate updatebasicCommodityTaxRate(BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
		return basicCommodityTaxRateRepo.saveAndFlush(mapper.convertValue(basicCommodityTaxRateVO, BasicCommodityTaxRate.class));
	}

}
