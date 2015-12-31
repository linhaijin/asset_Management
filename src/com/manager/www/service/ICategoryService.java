package com.manager.www.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.commons.util.Pager;
import com.manager.www.vo.Category;

/**
 * @author djx
 * @date 2015-12-31
 * @description
 */
public interface ICategoryService extends IBaseDAO<Category, Serializable>{

	//保存
	public boolean saveupdateCategory(Category entity) ;
    //delete
    public boolean deleteCategoryById(Serializable id) ;
    //update
    public boolean updateCategory(Category entity) ;
    //find
    public Category findCategoryById(Serializable id) ;
	
	public Pager findByHQLQuery(Category entity, Pager pager) ;
    public Pager findBySQLQuery(Category entity, Pager pager) ;
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) ;
    
    public List findCategoryList(String kehuID);
    public List<Category> findAllCategoryList();
}
