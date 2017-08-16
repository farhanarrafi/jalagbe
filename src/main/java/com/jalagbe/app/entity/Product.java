package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product", catalog = "jalagbe_db")
public class Product extends BaseEntity implements Serializable {

    @ManyToOne(targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category categoryId;

    @Column(name = "PRODUCT_CODE", unique = true, nullable = false)
    private Integer productCode;

    @Column(name = "PRODUCT_NAME",  nullable = false)
	private String productName;

    @Column(name = "QUANTITY",  nullable = false)
	private Integer quantity;

    @Column(name = "ORIGINAL_PRICE",  nullable = false)
	private Integer originalPrice;

    @Column(name = "DISCOUNT_PRICE_",  nullable = false)
	private Integer discountPrice;

    @Column(name = "FEATURE", nullable = false)
	private String feature;

    @Column(name = "DESCRIPTION", nullable = false)
	private String description;

    @Column(name = "AVAILABILITY", nullable = false)
	private Integer availability;

    public Product(Category categoryId, Integer productCode, String productName, Integer quantity, Integer originalPrice, Integer discountPrice, String feature, String description, Integer availability) {
        this.categoryId = categoryId;
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.feature = feature;
        this.description = description;
        this.availability = availability;
    }

    public Product(Long id, String createdOn, String updatedOn, Category categoryId, Integer productCode, String productName, Integer quantity, Integer originalPrice, Integer discountPrice, String feature, String description, Integer availability) {
        super(id, createdOn, updatedOn);
        this.categoryId = categoryId;
        this.productCode = productCode;
        this.productName = productName;
        this.quantity = quantity;
        this.originalPrice = originalPrice;
        this.discountPrice = discountPrice;
        this.feature = feature;
        this.description = description;
        this.availability = availability;
    }

    public Product() {
		super();
	}

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getQuntity() {
		return quantity;
	}

	public void setQuntity(Integer quntity) {
		this.quantity = quntity;
	}

	public Integer getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(Integer originalPrice) {
		this.originalPrice = originalPrice;
	}

	public Integer getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Integer discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Category getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Category categoryId) {
		this.categoryId = categoryId;
	}

}
