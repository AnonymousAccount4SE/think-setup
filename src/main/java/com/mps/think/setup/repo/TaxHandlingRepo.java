package com.mps.think.setup.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.TaxHandling;

@Repository
public interface TaxHandlingRepo extends JpaRepository<TaxHandling, Integer> {

	@Query(value="SELECT * FROM tax_handling where pub_id=:pubId",nativeQuery = true)
	List<TaxHandling> findBypubId(Integer pubId);

}
