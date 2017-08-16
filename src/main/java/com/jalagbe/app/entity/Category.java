package com.jalagbe.app.entity;

import com.jalagbe.app.entity.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "category" , catalog = "jalagbe_db", uniqueConstraints = {
		@UniqueConstraint(columnNames = "CATEGORY_NAME")})
public class Category extends BaseEntity implements Serializable {

    /**
    * class/DB table fields
    * */

    @Column(name = "CATEGORY_NAME", unique = true, nullable = false, length = 20)
	private String categoryName;

    @ManyToOne(targetEntity=Category.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
	private Category parentId;


    /**
     * contractors
     * */

	public Category(){
		super();
	}

    public Category(String categoryName, Category parentId) {
        this.categoryName = categoryName;
        this.parentId = parentId;
    }

    public Category(Long id, String createdOn, String updatedOn, String categoryName, Category parentId) {
        super(id, createdOn, updatedOn);
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
	
	
}
