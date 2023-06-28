package com.mps.think.setup.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.BasicJurisdictionTaxRate;

@Repository
public interface BasicJurisdictionTaxRateRepo extends JpaRepository<BasicJurisdictionTaxRate, Integer> {

//	@Query(value="SELECT * FROM basic_jurisdiction_tax_rate where commodity_codes_id=:commodityCodesId",nativeQuery = true)
	BasicJurisdictionTaxRate findByjurisdictionsId(Integer jurisdictionsId);

}
