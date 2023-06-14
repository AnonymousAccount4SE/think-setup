package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InventoryMapper;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryMapper, Integer> {
	
	public Page<InventoryMapper> findByPublisherId(Integer publisherId, Pageable page);

}
