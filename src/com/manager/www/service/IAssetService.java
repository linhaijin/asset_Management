package com.manager.www.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.commons.util.Pager;
import com.manager.www.vo.Asset;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
public interface IAssetService extends IBaseDAO<Asset, Serializable>{

	//保存
	public boolean saveupdateAsset(Asset entity) ;
    //delete
    public boolean deleteAssetById(Serializable id) ;
    //update
    public boolean updateAsset(Asset entity) ;
    //find
    public Asset findAssetById(Serializable id) ;
	
	public Pager findByHQLQuery(Asset entity, Pager pager) ;
    public Pager findBySQLQuery(Asset entity, Pager pager) ;
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) ;
    
    public List findAssetList(String kehuID);
    public List<Asset> findAllAssetList();
}
