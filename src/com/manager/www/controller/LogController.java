package com.manager.www.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.commons.annotation.SystemControllerLog;
import com.manager.www.commons.util.JsonUtil;
import com.manager.www.commons.util.Pager;
import com.manager.www.service.ILogService;
import com.manager.www.vo.Log;

/**
 * 
 * @author liuzc
 * @data 2015-11-13
 */

@Controller
@RequestMapping(value="LogController")
public class LogController {
	@Resource
	private ILogService logService;
	
	@RequestMapping("findlogList")
	@SystemControllerLog(description="分页获取全部日志")
	public ModelAndView gindlogList(HttpServletRequest request,HttpServletResponse response,PrintWriter printWriter,Log log){
		Map<String, String> column_map = new HashMap<String, String>();
		String curPage;
		String pageSize;
		curPage = request.getParameter("curPage");
		pageSize = request.getParameter("pageSize");
		pageSize = "100000";
		Pager pager = new Pager();
		if (StringUtils.isNotBlank(curPage)) {
			pager.setCurPage(Integer.parseInt(curPage));
		}
		if (StringUtils.isNotBlank(pageSize)) {
			pager.setPageSize(Integer.parseInt(pageSize));
		}
		List<Log> list_log=logService.findByHQLQuery(log,pager).getList();
		//JSONObject jsonObject=JSONObject.fromObject(list_log.get(0).getParams());
	//	System.out.println(jsonObject.get("id"));
		//System.out.println(jsonObject);
		return new ModelAndView("logcenter/logcenter")
		.addObject("list_log", list_log)
		.addObject("column_map", column_map);
	}
}
