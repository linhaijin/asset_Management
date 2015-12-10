/**
 * 
 */
package com.manager.www.service;

import java.io.Serializable;

import com.manager.www.commons.dao.IBaseDAO;
import com.manager.www.commons.util.Pager;
import com.manager.www.vo.Log;


/**
 * @author djx
 * @date 2015-8-12
 * @description
 */
public interface ILogService extends IBaseDAO<Log, Serializable>{
	public void add(Log log);
	public Pager findByHQLQuery(Log entity, Pager pager);
}
