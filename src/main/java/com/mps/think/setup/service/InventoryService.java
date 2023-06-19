package com.mps.think.setup.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mps.think.setup.model.AdjustmentTypes;
import com.mps.think.setup.model.InventoryIssueMapping;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.model.InventoryProductMapping;
import com.mps.think.setup.model.LocationAreaDetails;
import com.mps.think.setup.model.VendorDetails;
import com.mps.think.setup.vo.AdjustmentTypeVO;
import com.mps.think.setup.vo.InventoryIssueMappingVO;
import com.mps.think.setup.vo.InventoryMapperVO;
import com.mps.think.setup.vo.InventoryProductMappingVO;
import com.mps.think.setup.vo.LocationAreaDetailsVO;
import com.mps.think.setup.vo.VendorDetailsVO;

@Service
public interface InventoryService {
	
	public InventoryMapper saveInventory(InventoryMapperVO inventory);
	public InventoryMapper updateInventory(InventoryMapperVO inventory);
	public Page<InventoryMapper> getAllInventory(Integer publisherId, Pageable page);
	public InventoryMapper getInventoryById(Integer inventoryId);
	public List<InventoryMapper> getAllInventoryMapper();

	public VendorDetails createVendor(VendorDetailsVO vendor);
	public VendorDetails updateVendor(VendorDetailsVO vendor);
	public Page<VendorDetails> getVendor(Integer publisherId, Pageable page);
	public AdjustmentTypes createAdjustmentType(AdjustmentTypeVO type);
	public AdjustmentTypes updateAdjustmentType(AdjustmentTypeVO type);
	public Page<AdjustmentTypes> getAdjustmentTypes(Integer publisherId, Pageable page);
	public LocationAreaDetails createLocationArea(LocationAreaDetailsVO location);
	public LocationAreaDetails updateLocationArea(LocationAreaDetailsVO location);
	public Page<LocationAreaDetails> getLocationArea(Integer publisherId, Pageable page);

	public List<InventoryProductMapping> createProductLinks(List<InventoryProductMappingVO> product);
	public Page<InventoryProductMapping> getInventoryProductLinks(Integer inventoryId, Pageable page);
	
	public List<InventoryIssueMapping> createIssueLinks(List<InventoryIssueMappingVO> issue);
	public Page<InventoryIssueMapping> getInventoryIssueLinks(Integer inventoryId, Pageable page);
	
}
