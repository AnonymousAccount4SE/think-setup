package com.mps.think.setup.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mps.think.setup.model.InventoryProductMapping;

@Repository
public interface InventoryProductMappingRepo extends JpaRepository<InventoryProductMapping, Integer> {

	public Page<InventoryProductMapping> findByInventoryInventoryId(Integer inventoryId, Pageable page);
	
}
