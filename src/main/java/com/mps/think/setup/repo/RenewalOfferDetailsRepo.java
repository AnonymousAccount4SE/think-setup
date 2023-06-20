package com.mps.think.setup.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.RenewalOfferDetails;
@Repository
public interface RenewalOfferDetailsRepo extends JpaRepository<RenewalOfferDetails, Integer> {

//	Optional<RenewalOfferDetails> findByAddRenewalId(Integer id);
	
	public List<RenewalOfferDetails> findByAddRenewalId(Integer id);
	
}
