package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.VendorDetails;

@Repository
public interface VendorRepository extends JpaRepository<VendorDetails, Integer> {
	
	public Page<VendorDetails> findByPublisherId(Integer publisherId, Pageable page);

}
