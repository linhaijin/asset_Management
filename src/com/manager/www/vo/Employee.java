package com.manager.www.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "employee", catalog = "assetmanagement")
public class Employee implements java.io.Serializable {

	// Fields

	private Integer id;          //ID
	private String number;       //员工编号
	private String name;         //姓名
	private String status;       //状态
	private String gender;       //性别
	private String job;          //职务
	private Date entryTime;      //入职时间
	private String remarks;      //备注

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(String name, String number, String job, String remarks, String status, String gender, Date entryTime) {
		this.name = name;
		this.job = job;
		this.number = number;
		this.status = status;
		this.gender = gender;
		this.entryTime = entryTime;
		this.remarks = remarks;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
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

	@Column(name = "job", length = 50)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "status")
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "gender")
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "entryTime")
	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
}