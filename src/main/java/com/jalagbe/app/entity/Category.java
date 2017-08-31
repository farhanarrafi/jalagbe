package com.jalagbe.app.entity;


import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "category" , catalog = "jalagbe_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CATEGORY_NAME")})
public class Category implements Serializable {

    /**
    * class/DB table fields
    * */
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "category_seq", sequenceName = "category_seq", allocationSize    = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	private Long id;

	@Column(name = "CREATED_ON", nullable = false)
	private String createdOn;

	@Column(name = "UPDATED_ON",  nullable = false)
	private String updatedOn;

    @Column(name = "CATEGORY_NAME", unique = true, nullable = false, length = 20)
	private String categoryName;

    @ManyToOne(targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
	private Category parentId;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "categoryId")
    @Cascade(CascadeType.ALL)
    @Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
    private CategoryImage categoryImage;

    /**
     * contractors
     * */

	public Category(){
		super();
	}

    public Category(Long id, String createdOn, String updatedOn, String categoryName, Category parentId) {
		this.id = id;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.categoryName = categoryName;
        this.parentId = parentId;
    }


    /**
     * setter and getter
     * */

    public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Category getParentId() {
		return parentId;
	}
	public void setParentId(Category parentId) {
		this.parentId = parentId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

    public CategoryImage getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(CategoryImage categoryImage) {
        this.categoryImage = categoryImage;
    }
}
