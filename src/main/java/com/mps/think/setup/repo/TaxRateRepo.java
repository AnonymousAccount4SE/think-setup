package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.TaxRate;
import com.mps.think.setup.model.TaxType;
@Repository
public interface TaxRateRepo extends JpaRepository<TaxRate, Integer> {
	
	public TaxRate findByTaxId(Integer id);

	List<TaxRate> findByPubIdId(Integer pubId);

	@Query(value="SELECT * FROM tax_rate where pub_id=:pubId",nativeQuery = true)
	public List<TaxRate> findAllTaxTypeBypubId(Integer pubId);
	
}
