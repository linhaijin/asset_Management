package com.manager.www.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manager.www.commons.dao.BaseDao;
import com.manager.www.commons.util.Pager;
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
  //save
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean saveupdateEmployee(Employee entity) {
        return this.saveEntity(entity);
    }
    //delete
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean deleteEmployeeById(Serializable id) {
        return this.deleteEntityById(id);
    }
    //update
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean updateEmployee(Employee entity) {
        //这里的验证条件自己添加吧
        return this.updateEntity(entity);
    }
    //find
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public Employee findEmployeeById(Serializable id) {
        return this.findById(id);
    }
    
    
    @Transactional(readOnly=true)
    public Pager findByHQLQuery(Employee entity, Pager pager) {
        StringBuffer sb=new StringBuffer("  from Employee where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
    
    @Transactional(readOnly=true)
    public Pager findBySQLQuery(Employee entity, Pager pager) {
        StringBuffer sb=new StringBuffer("from Employee  where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return    this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
	/* (non-Javadoc)
	 * @see com.yunfang.yunhe.commons.service.IBaseService#findByHQLQuery(java.util.Map, com.yunfang.yunhe.commons.util.Pager)
	 */
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) {
		StringBuffer sb=new StringBuffer("select * from Employee where 1=1 ");
        if(map!=null){
        	if(map.get("number")!=null){
        		sb.append(" and number='"+map.get("number").toString()+"'");
        	}
        }
        sb.append("  order by GuJiaShiDian desc");
		  return this.findBySQLQuery(sb.toString(), pager);
	}
	
    /*
     * (non-Javadoc)
     * @see com.yunfang.yunhe.commons.service.IEmployeeService#findEmployeeList(java.lang.String)
     */
	public List findEmployeeList(String number){
        String sql="select * from Employee p where 1=1";
        if(StringUtils.isNotBlank(number)){
            sql+=" and p.number='"+number+"'";
        }
        return this.findAlllist(sql);
    }
	
	/*
	 * 获取所有员工信息
     * (non-Javadoc)
     */
	public List<Employee> findAllEmployeeList(){
        String sql="select * from Employee";
        return this.findAlllist(sql);
    }
	
}
