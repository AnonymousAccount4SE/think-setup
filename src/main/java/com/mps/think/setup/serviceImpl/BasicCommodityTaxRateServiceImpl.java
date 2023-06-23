package com.mps.think.setup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.repo.BasicCommodityTaxRateRepo;
import com.mps.think.setup.service.BasicCommodityTaxRateService;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;

@Service
public class BasicCommodityTaxRateServiceImpl implements BasicCommodityTaxRateService {

	@Autowired
	BasicCommodityTaxRateRepo basicCommodityTaxRateRepo;
	@Autowired
	private ObjectMapper mapper;
	@Override
	public BasicCommodityTaxRate getbasicCommodityTaxRateById(Integer commodityCodesId) {
		return basicCommodityTaxRateRepo.findBycommodityCodesId(commodityCodesId);
	}

	@Override
	public BasicCommodityTaxRate saveBasicCommodityTaxRateDetails(BasicCommodityTaxRateVO basicCommodityTaxRateVO) {
		return basicCommodityTaxRateRepo.saveAndFlush(mapper.convertValue(basicCommodityTaxRateVO, BasicCommodityTaxRate.class));
	}

}
