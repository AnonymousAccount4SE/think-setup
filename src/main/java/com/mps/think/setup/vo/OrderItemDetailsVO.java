package com.mps.think.setup.vo;

import java.util.Date;

import com.mps.think.setup.model.CommodityCodes;

public class OrderItemDetailsVO {

	private Integer id;

//	private Integer publisherId;

	private Date effectiveDate;

	private String itemType;

	private String itemUrl;

	private String itemImage;

	private String price;

	private String shippingWeight;

	private String commodityCode;

	private CommodityCodes commodityCodes;

	private String graceQuanitity;

	private String media;

	private String edition;

	private String category;

	private String isbn;

	private String author;

	private String style;

	private String size;

	private String colour;

	private boolean electronicDelivery;

	private Date fulfilmentDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getItemUrl() {
		return itemUrl;
	}

	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getShippingWeight() {
		return shippingWeight;
	}

	public void setShippingWeight(String shippingWeight) {
		this.shippingWeight = shippingWeight;
	}

	public String getCommodityCode() {
		return commodityCode;
	}

	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode;
	}

	public String getGraceQuanitity() {
		return graceQuanitity;
	}

	public void setGraceQuanitity(String graceQuanitity) {
		this.graceQuanitity = graceQuanitity;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public boolean isElectronicDelivery() {
		return electronicDelivery;
	}

	public void setElectronicDelivery(boolean electronicDelivery) {
		this.electronicDelivery = electronicDelivery;
	}

	public Date getFulfilmentDate() {
		return fulfilmentDate;
	}

	public void setFulfilmentDate(Date fulfilmentDate) {
		this.fulfilmentDate = fulfilmentDate;
	}

	public CommodityCodes getCommodityCodes() {
		return commodityCodes;
	}

	public void setCommodityCodes(CommodityCodes commodityCodes) {
		this.commodityCodes = commodityCodes;
	}

}
