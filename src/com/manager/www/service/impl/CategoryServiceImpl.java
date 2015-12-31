package com.manager.www.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manager.www.commons.dao.BaseDao;
import com.manager.www.commons.util.Pager;
import com.manager.www.service.ICategoryService;
import com.manager.www.vo.Category;

/**
 * @author djx
 * @date 2015-12-31
 * @description
 */
@Service
@Transactional
public class CategoryServiceImpl  extends BaseDao<Category> implements ICategoryService{

    
    public CategoryServiceImpl() {
        this.setClazz(Category.class);
    }
  //save
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean saveupdateCategory(Category entity) {
        return this.saveOrUpdate(entity);
    }
    //delete
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean deleteCategoryById(Serializable id) {
        return this.deleteEntityById(id);
    }
    //update
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean updateCategory(Category entity) {
        //这里的验证条件自己添加吧
        return this.updateEntity(entity);
    }
    //find
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public Category findCategoryById(Serializable id) {
        return this.findById(id);
    }

	@Transactional(readOnly=true)
    public Pager findByHQLQuery(Category entity, Pager pager) {
        StringBuffer sb=new StringBuffer("  from Category where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
    
    @Transactional(readOnly=true)
    public Pager findBySQLQuery(Category entity, Pager pager) {
        StringBuffer sb=new StringBuffer("from Category  where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return    this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
	/* (non-Javadoc)
	 * @see com.yunfang.yunhe.commons.service.IBaseService#findByHQLQuery(java.util.Map, com.yunfang.yunhe.commons.util.Pager)
	 */
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) {
		StringBuffer sb=new StringBuffer("select * from Category where 1=1 ");
        if(map!=null){
        	if(map.get("number")!=null){
        		sb.append(" and number='"+map.get("number").toString()+"'");
        	}
        }
        sb.append("  order by GuJiaShiDian desc");
		  return this.findBySQLQuery(sb.toString(), pager);
	}
	
    /*
     * 根据条件获取资产信息
     * (non-Javadoc)
     * @see com.manager.www.service.ICategoryService#findCategoryList(java.lang.String)
     */
	public List findCategoryList(String number){
        String sql="select * from Category p where 1=1";
        if(StringUtils.isNotBlank(number)){
            sql+=" and p.number='"+number+"'";
        }
        return this.findAlllist(sql);
    }
	
	
	/*
	 * 获取所有资产信息LIST
	 * (non-Javadoc)
	 * @see com.manager.www.service.ICategoryService#findAllCategoryList()
	 */
	public List<Category> findAllCategoryList(){
        String sql="select * from Category";
        return this.findAlllist(sql);
    }

}
