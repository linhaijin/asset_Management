package com.manager.www.service.impl;

import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.www.commons.dao.BaseDao;
import com.manager.www.service.IAssetsService;
import com.manager.www.vo.Assets;

/**
 * @author djx
 * @date 2015-8-17
 * @description
 */
@Service
@Transactional
public class AssetsServiceImpl  extends BaseDao<Assets> implements IAssetsService{

    
    public AssetsServiceImpl() {
        this.setClazz(Assets.class);
    }
	@Override
	public boolean saveAssets(Assets entity) {
		// TODO Auto-generated method stub
		return this.saveAssets(entity);
		
	}

	@Override
	public boolean updateAssets(Assets id) {
		// TODO Auto-generated method stub
		return this.updateAssets(id);
	}

	@Override
	public boolean deleteAssets(Assets entity) {
		// TODO Auto-generated method stub
		return this.deleteAssets(entity);
	}

	@Override
	public List<Assets> findAssets() {
		// TODO Auto-generated method stub
		return this.findAssets();
	}


}
