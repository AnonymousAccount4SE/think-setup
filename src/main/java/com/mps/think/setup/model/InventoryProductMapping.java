package com.mps.think.setup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "inventory_product_mapping")
@Entity
public class InventoryProductMapping extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4915495582312362895L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id" )
	private ProductInformation product;
	
	@OneToOne
	@JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id" )
	private InventoryMapper inventory;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProductInformation getProduct() {
		return product;
	}

	public void setProduct(ProductInformation product) {
		this.product = product;
	}

	public InventoryMapper getInventory() {
		return inventory;
	}

	public void setInventory(InventoryMapper inventory) {
		this.inventory = inventory;
	}

}
