package com.manager.www.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.commons.util.JsonUtil;
import com.manager.www.service.ICategoryService;
import com.manager.www.vo.Category;

/**
 * @author djx
 * @date 2015-12-31
 * @description
 */

@Controller
@RequestMapping(value="categoryController")
public class CategoryController {
    @Resource
    ICategoryService categoryService;
    
    
    @RequestMapping("/tocategory")
    public ModelAndView tocategory(HttpServletRequest request, HttpServletResponse response){
    	String realPath = request.getSession().getServletContext()
                .getRealPath("/");
    	System.out.println(realPath);
//    	WriteToFileExample(realPath);
        return new ModelAndView("category");
    }
    
    /**
     * 从数据库查询信息供写文件使用
     * @return JSONArray
     */
//    public JSONArray loadInfo(){
//    	JSONArray jsonArray = new JSONArray();
//        try {
//            List<Category> categoryList = categoryService.findAllCategoryList();
//            for (int i=0;i<categoryList.size();i++){
//            	JSONObject jsonObject = new JSONObject();
//            	Category category = new Category();
//            	category = categoryList.get(i);
//            	jsonObject.put("value", category.getNumber());
//            	jsonObject.put("name", category.getName());
//            	jsonObject.put("uses", category.getUses());
//            	jsonObject.put("category", category.getCategory());
//            	jsonObject.put("entryTime", new SimpleDateFormat("yyyy-MM-dd").format(category.getEntryTime()));
//            	jsonObject.put("status", category.getStatus());
//            	jsonObject.put("remarks", category.getRemarks());
//            	jsonObject.put("edit", "<a href='javascript:void(0)' onclick='editCategory("+category.getId()+")'>编辑</>/<a href='javascript:void(0)' onclick='deleteCategory("+category.getId()+")'>删除</>");
//            	jsonArray.add(jsonObject);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return jsonArray;
//    }
    
    
    
    /**
     * 写文件的方法
     */
//    public void WriteToFileExample(String realPath) {
//        
//        try {
//            JSONArray content = loadInfo();
//            File file = new File(realPath + "/content/index/tables/dataCategory.json");
//
//            // if file doesnt exists, then create it
//            if (!file.exists()) {
//             file.createNewFile();
//            }
//
//            OutputStream out=new FileOutputStream(file);
//            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
//            bw.write(content+"");
//            bw.close();
//
//           } catch (IOException e) {
//            e.printStackTrace();
//           }
//        }
    
    /**
     * 查询员工信息
     * @param request
     * @param response
     * @param printWriter
     */
    @RequestMapping("/searchCategory")
    public void searchCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
    	Map<String,Object> result_map = new HashMap<String,Object>();
    	String id = request.getParameter("id");
        Category category = new Category();
        category = categoryService.findById(id);
        result_map.put("msg", category);
        printWriter.print(JsonUtil.jsonObject(result_map, null, null));
        printWriter.flush();
        printWriter.close();
    }
    
    
    /**
     * 添加新员工方法
     * @param request
     * @param response
     * @param printWriter
     */
    @RequestMapping("/addCategory")
    public void addCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
        Map<String,Object> result_map = new HashMap<String,Object>();
        String idString = request.getParameter("id");
        String value = request.getParameter("value");
        
        Category category = new Category();
        
        if (StringUtils.isNotBlank(idString)){
            category.setId(idString);
        }else{
        	category.setId(UUID.randomUUID()+"");
        }
        if (StringUtils.isNotBlank(value)){
        	category.setValue(value);
        }
        try {
            boolean bon = categoryService.saveupdateCategory(category);
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

    /**
     * 删除员工信息
     * @param request
     * @param response
     * @param printWriter
     */
    @RequestMapping("/deleteCategory")
    public void deleteCategory(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
    	Map<String,Object> result_map = new HashMap<String,Object>();
        String id = request.getParameter("id");
        Boolean bon = categoryService.deleteEntityById(id);
        result_map.put("success", bon);
        printWriter.print(JsonUtil.jsonObject(result_map, null, null));
        printWriter.flush();
        printWriter.close();
    }
}
