package com.manager.www.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import com.manager.www.service.IAssetService;
import com.manager.www.service.ICategoryService;
import com.manager.www.vo.Asset;
import com.manager.www.vo.Category;

/**
 * @author djx
 * @date 2015-12-31
 * @description
 */

@Controller
@RequestMapping(value="assetController")
public class AssetController {
    @Resource
    IAssetService assetService;
    @Resource
    private ICategoryService categoryService;
    
    @RequestMapping("/toasset")
    public ModelAndView toasset(HttpServletRequest request, HttpServletResponse response){
    	String realPath = request.getSession().getServletContext()
                .getRealPath("/");
    	System.out.println(realPath);
    	WriteToFileExample(realPath);
    	List<Category> category_list = categoryService.findAllCategoryList();
        request.setAttribute("category", category_list);
        return new ModelAndView("asset");
    }
    
    @RequestMapping("/tosaveOrupdateAsset")
    public ModelAndView tosaveOrupdateAsset(HttpServletRequest request, HttpServletResponse response){
    	List<Category> category_list = categoryService.findAllCategoryList();
        request.setAttribute("category", category_list);
        return new ModelAndView("saveOrupdateAsset");
    }
    
    /**
     * 从数据库查询信息供写文件使用
     * @return JSONArray
     */
    public JSONArray loadInfo(){
    	JSONArray jsonArray = new JSONArray();
        try {
            List<Asset> assetList = assetService.findAllAssetList();
            for (int i=0;i<assetList.size();i++){
            	JSONObject jsonObject = new JSONObject();
            	Asset asset = new Asset();
            	asset = assetList.get(i);
            	jsonObject.put("number", asset.getNumber());
            	jsonObject.put("name", asset.getName());
            	jsonObject.put("uses", asset.getUses());
            	jsonObject.put("category", asset.getCategory());
            	jsonObject.put("entryTime", new SimpleDateFormat("yyyy-MM-dd").format(asset.getEntryTime()));
            	jsonObject.put("status", asset.getStatus());
            	jsonObject.put("remarks", asset.getRemarks());
            	jsonObject.put("edit", "<a href='javascript:void(0)' onclick='editAsset("+asset.getId()+")'>编辑</>/<a href='javascript:void(0)' onclick='deleteAsset("+asset.getId()+")'>删除</>");
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
            File file = new File(realPath + "/content/index/tables/dataAsset.json");

            // if file doesnt exists, then create it
            if (!file.exists()) {
             file.createNewFile();
            }

            OutputStream out=new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,"utf-8"));
            bw.write(content+"");
            bw.close();

           } catch (IOException e) {
            e.printStackTrace();
           }
        }
    
    /**
     * 查询员工信息
     * @param request
     * @param response
     * @param printWriter
     */
    @RequestMapping("/searchAsset")
    public void searchAsset(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
    	Map<String,Object> result_map = new HashMap<String,Object>();
    	String id = request.getParameter("id");
        Asset asset = new Asset();
        asset = assetService.findById(id);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(asset.getEntryTime());
        result_map.put("msg", asset);
        result_map.put("date", date);
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
    @RequestMapping("/addAsset")
    public void addAsset(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
        Map<String,Object> result_map = new HashMap<String,Object>();
        String idString = request.getParameter("id");
        String number = request.getParameter("number");
        String name = request.getParameter("name");
        String uses = request.getParameter("uses");
        String category = request.getParameter("category");
        String entryTime = request.getParameter("entryTime");
        String status = request.getParameter("status");
        String remarks = request.getParameter("remarks");
        
        Asset asset = new Asset();
        
        if (StringUtils.isNotBlank(idString)){
            asset.setId(idString);
        }else{
        	asset.setId(UUID.randomUUID()+"");
        }
        if (StringUtils.isNotBlank(number)){
        	asset.setNumber(number);
        }
        if (StringUtils.isNotBlank(name)){
            asset.setName(name);
        }
        if (StringUtils.isNotBlank(uses)){
                asset.setUses(uses);
        }
        if (StringUtils.isNotBlank(category)){
            asset.setCategory(category);
        }
        if (StringUtils.isNotBlank(status)){
            asset.setStatus(status);
        }
        if (StringUtils.isNotBlank(entryTime)){
            try {
                asset.setEntryTime(new SimpleDateFormat("yyyy-MM-dd").parse(entryTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (StringUtils.isNotBlank(remarks)){
            asset.setRemarks(remarks);
        }
        try {
            boolean bon = assetService.saveupdateAsset(asset);
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
    @RequestMapping("/deleteAsset")
    public void deleteAsset(HttpServletRequest request, HttpServletResponse response, PrintWriter printWriter){
    	Map<String,Object> result_map = new HashMap<String,Object>();
        String id = request.getParameter("id");
        Boolean bon = assetService.deleteEntityById(id);
        result_map.put("success", bon);
        printWriter.print(JsonUtil.jsonObject(result_map, null, null));
        printWriter.flush();
        printWriter.close();
    }
}
