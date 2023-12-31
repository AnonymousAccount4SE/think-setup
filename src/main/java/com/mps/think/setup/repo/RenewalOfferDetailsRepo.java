package com.mps.think.setup.repo;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mps.think.setup.model.RenewalOfferDetails;
@Repository
public interface RenewalOfferDetailsRepo extends JpaRepository<RenewalOfferDetails, Integer> {

//	Optional<RenewalOfferDetails> findByAddRenewalId(Integer id);
	
public List<RenewalOfferDetails> findByEffortRangeId(Integer id);
	
//	Page<List<RenewalOfferDetails>> findByAddRenewalId(Integer id, Pageable page);
	
}
