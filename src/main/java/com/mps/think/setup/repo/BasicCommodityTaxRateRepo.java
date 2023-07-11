package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.BasicCommodityTaxRate;

@Repository
public interface BasicCommodityTaxRateRepo extends JpaRepository<BasicCommodityTaxRate, Integer> {

	@Query(value="SELECT * FROM basic_commodity_tax_rate where commodity_codes_id=:commodityCodesId",nativeQuery = true)
	BasicCommodityTaxRate findBycommodityCodesId(Integer commodityCodesId);

	@Query(value="SELECT * FROM basic_commodity_tax_rate where tax_rate_id=:taxRateId",nativeQuery = true)
	public List<BasicCommodityTaxRate> findByTaxRateIdBasicCommodity(@Param("taxRateId") Integer taxRateId);

}
