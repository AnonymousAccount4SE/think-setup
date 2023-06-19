package com.mps.think.setup.vo;

public class InventoryProductMappingVO {

	private Integer id;
	
	private ProductInformationVO product;
	
	private InventoryMapperVO inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductInformationVO getProduct() {
		return product;
	}

	public void setProduct(ProductInformationVO product) {
		this.product = product;
	}

	public InventoryMapperVO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryMapperVO inventory) {
		this.inventory = inventory;
	}
	
}
