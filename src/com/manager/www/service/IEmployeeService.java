package com.manager.www.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.commons.util.Pager;
import com.manager.www.vo.Employee;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
public interface IEmployeeService extends IBaseDAO<Employee, Serializable>{

	public boolean saveupdateEmployee(Employee entity) ;
    //delete
    public boolean deleteEmployeeById(Serializable id) ;
    //update
    public boolean updateEmployee(Employee entity) ;
    //find
    public Employee findEmployeeById(Serializable id) ;
    public Pager findByHQLQuery(Employee entity, Pager pager) ;
    public Pager findBySQLQuery(Employee entity, Pager pager) ;
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) ;

    //根据客户ID查找对应的记录
    public List findEmployeeList(String kehuID);
    public List<Employee> findAllEmployeeList();
	
}
