package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.BasicTaxRate;

@Repository
public interface BasicTaxRateRepo extends JpaRepository<BasicTaxRate, Integer> {

	@Query(value="SELECT * FROM basic_tax_rate_id where tax_rate_id=:taxRateId",nativeQuery = true)
	public List<BasicTaxRate> findByTaxRateId(@Param("taxRateId") Integer taxRateId);

}
