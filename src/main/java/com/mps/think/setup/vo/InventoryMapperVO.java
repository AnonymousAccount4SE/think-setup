package com.mps.think.setup.vo;

public class InventoryMapperVO {
	
	private Integer inventoryId;
	
	private PublisherVO publisher;
	
	private InventoryGeneralInformationVO generalInformation;
	
	private InventoryUnitInformationVO unitInformation;
	
	private InventoryOrderSettingsVO orderSettings;
	
	private InventoryTotalsVO inventoryTotals;
	
	private InventoryStorageLocationsVO primaryStorageLocation;
	
	private InventoryBulkTotalsVO bulkInventoryTotals;
	
	private InventoryVendorDetailsVO vendorInformation;

	public InventoryGeneralInformationVO getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(InventoryGeneralInformationVO generalInformation) {
		this.generalInformation = generalInformation;
	}

	public InventoryUnitInformationVO getUnitInformation() {
		return unitInformation;
	}

	public void setUnitInformation(InventoryUnitInformationVO unitInformation) {
		this.unitInformation = unitInformation;
	}

	public InventoryOrderSettingsVO getOrderSettings() {
		return orderSettings;
	}

	public void setOrderSettings(InventoryOrderSettingsVO orderSettings) {
		this.orderSettings = orderSettings;
	}

	public InventoryTotalsVO getInventoryTotals() {
		return inventoryTotals;
	}

	public void setInventoryTotals(InventoryTotalsVO inventoryTotals) {
		this.inventoryTotals = inventoryTotals;
	}

	public InventoryStorageLocationsVO getPrimaryStorageLocation() {
		return primaryStorageLocation;
	}

	public void setPrimaryStorageLocation(InventoryStorageLocationsVO primaryStorageLocation) {
		this.primaryStorageLocation = primaryStorageLocation;
	}

	public InventoryBulkTotalsVO getBulkInventoryTotals() {
		return bulkInventoryTotals;
	}

	public void setBulkInventoryTotals(InventoryBulkTotalsVO bulkInventoryTotals) {
		this.bulkInventoryTotals = bulkInventoryTotals;
	}

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public InventoryVendorDetailsVO getVendorInformation() {
		return vendorInformation;
	}

	public void setVendorInformation(InventoryVendorDetailsVO vendorInformation) {
		this.vendorInformation = vendorInformation;
	}

	public PublisherVO getPublisher() {
		return publisher;
	}

	public void setPublisher(PublisherVO publisher) {
		this.publisher = publisher;
	}

}
