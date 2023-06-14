package com.mps.think.setup.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mps.think.setup.model.AdjustmentTypes;
import com.mps.think.setup.model.InventoryMapper;
import com.mps.think.setup.model.LocationAreaDetails;
import com.mps.think.setup.model.VendorDetails;
import com.mps.think.setup.repo.AdjustmentTypeRepository;
import com.mps.think.setup.repo.InventoryRepository;
import com.mps.think.setup.repo.LocationAreaRepository;
import com.mps.think.setup.repo.VendorRepository;
import com.mps.think.setup.service.InventoryService;
import com.mps.think.setup.vo.AdjustmentTypeVO;
import com.mps.think.setup.vo.InventoryMapperVO;
import com.mps.think.setup.vo.LocationAreaDetailsVO;
import com.mps.think.setup.vo.VendorDetailsVO;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private AdjustmentTypeRepository adjustmentTypeRepository;

	@Autowired
	private LocationAreaRepository locationAreaRepository;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public InventoryMapper saveInventory(InventoryMapperVO inventory) {
		return inventoryRepository.saveAndFlush(mapper.convertValue(inventory, InventoryMapper.class));
	}

	@Override
	public InventoryMapper updateInventory(InventoryMapperVO inventory) {
		return inventoryRepository.saveAndFlush(mapper.convertValue(inventory, InventoryMapper.class));
	}

	@Override
	public Page<InventoryMapper> getAllInventory(Integer publisherId, Pageable page) {
		return inventoryRepository.findByPublisherId(publisherId, page);
	}

	@Override
	public InventoryMapper getInventoryById(Integer inventoryId) {
		return inventoryRepository.findById(inventoryId).get();
	}

	@Override

	public List<InventoryMapper> getAllInventoryMapper() {
		return inventoryRepository.findAll();
		
	}
	public VendorDetails createVendor(VendorDetailsVO vendor) {
		return vendorRepository.saveAndFlush(mapper.convertValue(vendor, VendorDetails.class));
	}

	@Override
	public VendorDetails updateVendor(VendorDetailsVO vendor) {
		return vendorRepository.saveAndFlush(mapper.convertValue(vendor, VendorDetails.class));
	}

	@Override
	public Page<VendorDetails> getVendor(Integer publisherId, Pageable page) {
		return vendorRepository.findByPublisherId(publisherId, page);
	}

	@Override
	public AdjustmentTypes createAdjustmentType(AdjustmentTypeVO type) {
		return adjustmentTypeRepository.saveAndFlush(mapper.convertValue(type, AdjustmentTypes.class));
	}

	@Override
	public AdjustmentTypes updateAdjustmentType(AdjustmentTypeVO type) {
		return adjustmentTypeRepository.saveAndFlush(mapper.convertValue(type, AdjustmentTypes.class));
	}

	@Override
	public Page<AdjustmentTypes> getAdjustmentTypes(Integer publisherId, Pageable page) {
		return adjustmentTypeRepository.findByPublisherId(publisherId, page);
	}

	@Override
	public LocationAreaDetails createLocationArea(LocationAreaDetailsVO location) {
		return locationAreaRepository.saveAndFlush(mapper.convertValue(location, LocationAreaDetails.class));
	}

	@Override
	public LocationAreaDetails updateLocationArea(LocationAreaDetailsVO location) {
		return locationAreaRepository.saveAndFlush(mapper.convertValue(location, LocationAreaDetails.class));
	}

	@Override
	public Page<LocationAreaDetails> getLocationArea(Integer publisherId, Pageable page) {
		return locationAreaRepository.findByPublisherId(publisherId, page);

	}

}
