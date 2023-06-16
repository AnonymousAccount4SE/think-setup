package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InventoryIssueMapping;

@Repository
public interface InventoryIssueMappingRepo extends JpaRepository<InventoryIssueMapping, Integer> {
	
	public Page<InventoryIssueMapping> findByInventoryInventoryId(Integer inventoryId, Pageable page);

}
