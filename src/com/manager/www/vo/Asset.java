package com.manager.www.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "asset", catalog = "assetmanagement")
public class Asset implements java.io.Serializable {

	// Fields

	private String id;           //ID
	private String number;       //资产编号
	private String name;         //资产名称
	private String status;       //状态,0空闲1在用
	private String uses;         //用途
	private Date entryTime;      //购买时间
	private String category;     //类别
	private String remarks;      //备注

	// Constructors

	/** default constructor */
	public Asset() {
	}

	/** full constructor */
	public Asset(String id, String name, String number, String uses, String remarks, String status, String category, Date entryTime) {
		this.id = id;
		this.name = name;
		this.uses = uses;
		this.number = number;
		this.status = status;
		this.category = category;
		this.entryTime = entryTime;
		this.remarks = remarks;
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

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "number", length = 50)
	public String getNumber() {
		return this.number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	@Column(name = "remarks", length = 50)
	public String getRemarks() {
		return this.remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "uses", length = 50)
	public String getUses() {
		return this.uses;
	}

	public void setUses(String uses) {
		this.uses = uses;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "category", length = 50)
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Column(name = "entryTime")
	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
}