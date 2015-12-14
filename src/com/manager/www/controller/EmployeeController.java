package com.manager.www.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.commons.util.JsonUtil;
import com.manager.www.commons.util.WebConstants;
import com.manager.www.service.IEmployeeService;
import com.manager.www.service.IUserService;
import com.manager.www.vo.Employee;
import com.manager.www.vo.User;

/**
 * @author djx
 * @date 2015-11-19
 * @description
 */

@Controller
@RequestMapping(value="employeeController")
public class EmployeeController {
    @Resource
    IEmployeeService employeeService;
    
    @RequestMapping("/loadInfo")
    public void loadInfo(HttpServletRequest request, HttpServletResponse response,PrintWriter printWriter){
        Map<String,Object> result_map = new HashMap<String,Object>();
        try {
        	List<Employee> employeeList = employeeService.findEmployee();
        	for (int i=0;i<employeeList.size();i++){
        		
        	}
        } catch (Exception e) {
            result_map.put("success", false);
            result_map.put("msg", "系统错误,请与管理员联系");
            e.printStackTrace();
        }finally{
            printWriter.print(JsonUtil.jsonObject(result_map, null, null));
            printWriter.flush();
            printWriter.close();
        }
    }
    
    
    @RequestMapping("/addEmployee")
    public void addEmployee(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter, Employee employee){
        Map<String,Object> result_map = new HashMap<String,Object>();
        try {
        	boolean bon = employeeService.saveEmployee(employee);
        	if (bon){
        		result_map.put("success", true);
                result_map.put("msg", "添加成功");
        	}else {
        		result_map.put("success", false);
                result_map.put("msg", "添加失败");
        	}
        } catch (Exception e) {
            result_map.put("success", false);
            result_map.put("msg", "系统错误,请与管理员联系");
            e.printStackTrace();
        }finally{
            printWriter.print(JsonUtil.jsonObject(result_map, null, null));
            printWriter.flush();
            printWriter.close();
        }
    }
    @RequestMapping("/toemployee")
    public ModelAndView loginSuccess(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("employee");
    }
    
    //首页
    @RequestMapping("/tosetting")
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response){
    	return new ModelAndView("setting");
    }
    
}
