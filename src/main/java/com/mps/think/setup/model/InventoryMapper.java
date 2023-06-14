package com.mps.think.setup.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "inventory_mapper")
@Entity
public class InventoryMapper extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4168999931737545425L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventory_id")
	private Integer inventoryId;
	
	@OneToOne
	@JoinColumn(name = "publisher_id", referencedColumnName = "id" )
	private Publisher publisher;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "general_information_id", referencedColumnName = "id" )
	private InventoryGeneralInformation generalInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "unit_information_id", referencedColumnName = "id" )
	private InventoryUnitInformation unitInformation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_settings_id", referencedColumnName = "id" )
	private InventoryOrderSettings orderSettings;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "inventory_totals_id", referencedColumnName = "id" )
	private InventoryTotals inventoryTotals;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "storage_location_id", referencedColumnName = "id" )
	private InventoryStorageLocations primaryStorageLocation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "bulk_inventory_totals_id", referencedColumnName = "id" )
	private InventoryBulkTotals bulkInventoryTotals;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "vendor_information_id", referencedColumnName = "id" )
	private InventoryVendorDetails vendorInformation;

	public Integer getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}

	public InventoryGeneralInformation getGeneralInformation() {
		return generalInformation;
	}

	public void setGeneralInformation(InventoryGeneralInformation generalInformation) {
		this.generalInformation = generalInformation;
	}

	public InventoryUnitInformation getUnitInformation() {
		return unitInformation;
	}

	public void setUnitInformation(InventoryUnitInformation unitInformation) {
		this.unitInformation = unitInformation;
	}

	public InventoryOrderSettings getOrderSettings() {
		return orderSettings;
	}

	public void setOrderSettings(InventoryOrderSettings orderSettings) {
		this.orderSettings = orderSettings;
	}

	public InventoryTotals getInventoryTotals() {
		return inventoryTotals;
	}

	public void setInventoryTotals(InventoryTotals inventoryTotals) {
		this.inventoryTotals = inventoryTotals;
	}

	public InventoryStorageLocations getPrimaryStorageLocation() {
		return primaryStorageLocation;
	}

	public void setPrimaryStorageLocation(InventoryStorageLocations primaryStorageLocation) {
		this.primaryStorageLocation = primaryStorageLocation;
	}

	public InventoryBulkTotals getBulkInventoryTotals() {
		return bulkInventoryTotals;
	}

	public void setBulkInventoryTotals(InventoryBulkTotals bulkInventoryTotals) {
		this.bulkInventoryTotals = bulkInventoryTotals;
	}

	public InventoryVendorDetails getVendorInformation() {
		return vendorInformation;
	}

	public void setVendorInformation(InventoryVendorDetails vendorInformation) {
		this.vendorInformation = vendorInformation;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "InventoryMapper [inventoryId=" + inventoryId + ", generalInformation=" + generalInformation
				+ ", unitInformation=" + unitInformation + ", orderSettings=" + orderSettings + ", inventoryTotals="
				+ inventoryTotals + ", primaryStorageLocation=" + primaryStorageLocation + ", bulkInventoryTotals="
				+ bulkInventoryTotals + "]";
	}

}
