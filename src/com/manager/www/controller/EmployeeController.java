package com.manager.www.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.commons.util.JsonUtil;
import com.manager.www.service.IEmployeeService;
import com.manager.www.vo.Employee;

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
    
    
    @RequestMapping("/toemployee")
    public ModelAndView toemployee(HttpServletRequest request, HttpServletResponse response){
    	String realPath = request.getSession().getServletContext()
                .getRealPath("/");
    	System.out.println(realPath);
    	WriteToFileExample(realPath);
        return new ModelAndView("employee");
    }
    
    public JSONArray loadInfo(){
    	JSONArray jsonArray = new JSONArray();
        try {
            List<Employee> employeeList = employeeService.findAllEmployeeList();
            for (int i=0;i<employeeList.size();i++){
            	JSONObject jsonObject = new JSONObject();
            	Employee employee = new Employee();
            	employee = employeeList.get(i);
            	jsonObject.put("number", employee.getNumber());
            	jsonObject.put("name", employee.getName());
            	jsonObject.put("gender", employee.getGender());
            	jsonObject.put("job", employee.getJob());
            	jsonObject.put("entryTime", new SimpleDateFormat("yyyy-MM-dd").format(employee.getEntryTime()));
            	jsonObject.put("status", employee.getStatus());
            	jsonObject.put("remarks", employee.getRemarks());
            	jsonObject.put("edit", "<a herf='javascript(0)' onclick='editEmployee()'>编辑</>");
            	jsonArray.add(jsonObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
    
    
    
    /**
     * 写文件的方法
     */
    public void WriteToFileExample(String realPath) {
        
        try {
            JSONArray content = loadInfo();
            File file = new File(realPath + "/content/index/tables/data1.json");

            // if file doesnt exists, then create it
            if (!file.exists()) {
             file.createNewFile();
            }

            OutputStream out=new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
            bw.write(content+"");
            bw.close();

            System.out.println("Done");

           } catch (IOException e) {
            e.printStackTrace();
           }
        }
    
    @RequestMapping("/addEmployee")
    public void addEmployee(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
        Map<String,Object> result_map = new HashMap<String,Object>();
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String job = request.getParameter("job");
        String entryTime = request.getParameter("entryTime");
        String status = request.getParameter("status");
        String remarks = request.getParameter("remarks");
        
        Employee employee = new Employee();
        
        if (StringUtils.isNotBlank(number)){
            employee.setNumber(number);
        }
        if (StringUtils.isNotBlank(name)){
            employee.setName(name);
        }
        if (StringUtils.isNotBlank(gender)){
                employee.setGender(gender);
        }
        if (StringUtils.isNotBlank(job)){
            employee.setJob(job);
        }
        if (StringUtils.isNotBlank(status)){
            employee.setStatus(status);
        }
        if (StringUtils.isNotBlank(entryTime)){
            try {
                employee.setEntryTime(new SimpleDateFormat("yyyy-MM-dd").parse(entryTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(remarks)){
            employee.setRemarks(remarks);
        }
        try {
            boolean bon = employeeService.saveupdateEmployee(employee);
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
    
}
