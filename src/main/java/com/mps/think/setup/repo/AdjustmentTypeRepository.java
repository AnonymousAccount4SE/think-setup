package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.AdjustmentTypes;

@Repository
public interface AdjustmentTypeRepository extends JpaRepository<AdjustmentTypes, Integer> {
	
	public Page<AdjustmentTypes> findByPublisherId(Integer publisherId, Pageable page);

}
