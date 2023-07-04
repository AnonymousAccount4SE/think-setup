package com.mps.think.setup.service;

import java.util.List;

import com.mps.think.setup.model.BasicCommodityTaxRate;
import com.mps.think.setup.vo.BasicCommodityTaxRateVO;

public interface BasicCommodityTaxRateService {

	
	BasicCommodityTaxRate saveBasicCommodityTaxRateDetails(BasicCommodityTaxRateVO BasicCommodityTaxRateVO);
	
	BasicCommodityTaxRate getbasicCommodityTaxRateById(Integer commodityCodesId);
	
	List<BasicCommodityTaxRate> getbasicCommodityTaxRateByPubId(Integer pubId);

	BasicCommodityTaxRate updatebasicCommodityTaxRate(BasicCommodityTaxRateVO basicCommodityTaxRateVO);

}
