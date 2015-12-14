package com.manager.www.service;

import java.io.Serializable;
import java.util.List;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.vo.Assets;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
public interface IAssetsService extends IBaseDAO<Assets, Serializable>{

	//保存
	public boolean saveAssets (Assets entity);
	//修改
	public boolean updateAssets (Assets id);
	//删除
	public boolean deleteAssets (Assets entity);
	//查询
	public List<Assets> findAssets ();
	
}
