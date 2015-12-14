package com.manager.www.service;

import java.io.Serializable;
import java.util.List;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.vo.Employee;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
public interface IEmployeeService extends IBaseDAO<Employee, Serializable>{

	//保存
	public boolean saveEmployee (Employee entity);
	//修改
	public boolean updateEmployee (Employee id);
	//删除
	public boolean deleteEmployee (Employee entity);
	//查询
	public List<Employee> findEmployee ();
	
}
