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
import com.manager.www.service.IAssetService;
import com.manager.www.vo.Asset;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
@Service
@Transactional
public class AssetServiceImpl  extends BaseDao<Asset> implements IAssetService{

    
    public AssetServiceImpl() {
        this.setClazz(Asset.class);
    }
  //save
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean saveupdateAsset(Asset entity) {
        return this.saveOrUpdate(entity);
    }
    //delete
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean deleteAssetById(Serializable id) {
        return this.deleteEntityById(id);
    }
    //update
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public boolean updateAsset(Asset entity) {
        //这里的验证条件自己添加吧
        return this.updateEntity(entity);
    }
    //find
    @Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
    public Asset findAssetById(Serializable id) {
        return this.findById(id);
    }

	@Transactional(readOnly=true)
    public Pager findByHQLQuery(Asset entity, Pager pager) {
        StringBuffer sb=new StringBuffer("  from Asset where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
    
    @Transactional(readOnly=true)
    public Pager findBySQLQuery(Asset entity, Pager pager) {
        StringBuffer sb=new StringBuffer("from Asset  where 1=1 ");
        ArrayList values=new ArrayList();
        if(entity!=null){
        }
        return    this.findByHQLQuery(sb.toString(), values.toArray(), pager);
    }
	/* (non-Javadoc)
	 * @see com.yunfang.yunhe.commons.service.IBaseService#findByHQLQuery(java.util.Map, com.yunfang.yunhe.commons.util.Pager)
	 */
    public Pager findBySQLQuery(Map<String, Object> map, Pager pager) {
		StringBuffer sb=new StringBuffer("select * from Asset where 1=1 ");
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
     * @see com.manager.www.service.IAssetService#findAssetList(java.lang.String)
     */
	public List findAssetList(String number){
        String sql="select * from Asset p where 1=1";
        if(StringUtils.isNotBlank(number)){
            sql+=" and p.number='"+number+"'";
        }
        return this.findAlllist(sql);
    }
	
	
	/*
	 * 获取所有资产信息LIST
	 * (non-Javadoc)
	 * @see com.manager.www.service.IAssetService#findAllAssetList()
	 */
	public List<Asset> findAllAssetList(){
        String sql="select * from Asset";
        return this.findAlllist(sql);
    }

}
