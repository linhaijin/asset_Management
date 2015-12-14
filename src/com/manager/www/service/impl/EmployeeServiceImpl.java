package com.manager.www.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.www.commons.dao.BaseDao;
import com.manager.www.service.IEmployeeService;
import com.manager.www.vo.Employee;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
@Service
@Transactional
public class EmployeeServiceImpl  extends BaseDao<Employee> implements IEmployeeService{

    
    public EmployeeServiceImpl() {
        this.setClazz(Employee.class);
    }
	@Override
	public boolean saveEmployee(Employee entity) {
		// TODO Auto-generated method stub
		return this.saveEmployee(entity);
		
	}

	@Override
	public boolean updateEmployee(Employee id) {
		// TODO Auto-generated method stub
		return this.updateEmployee(id);
	}

	@Override
	public boolean deleteEmployee(Employee entity) {
		// TODO Auto-generated method stub
		return this.deleteEmployee(entity);
	}

	@Override
	public List<Employee> findEmployee() {
		// TODO Auto-generated method stub
		return this.findEmployee();
	}


}
