package com.manager.www.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "category", catalog = "assetmanagement")
public class Category implements java.io.Serializable {

	// Fields

	private String id;           //ID
	private String value;        //资产类别

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** full constructor */
	public Category(String id, String value) {
		this.id = id;
		this.value = value;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "value", length = 50)
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}