package com.manager.www.vo;

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
	private String Name;         //姓名
	private Integer status = 1;  //状态,0离职1在职
	private Integer gender;      //性别,男1女0
	private String job;          //职务
	private String pwd;          //密码

	// Constructors

	/** default constructor */
	public Employee() {
	}

	/** full constructor */
	public Employee(String userName, String pwd, Integer status, Integer gender) {
		this.userName = userName;
		this.pwd = pwd;
		this.status = status;
		this.gender = gender;
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

	@Column(name = "userName", length = 50)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "pwd", length = 50)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}
}