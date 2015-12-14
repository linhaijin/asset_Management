package com.manager.www.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manager.www.service.IUserService;

/**
 * @author djx
 * @date 2015-11-19
 * @description
 */

@Controller
@RequestMapping(value="profileController")
public class ProfileController {
    @Resource
    IUserService userService;
    
    @RequestMapping("/tologout")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response){
    	request.getSession().removeAttribute("userId");  //退出登录之前移除session
    	request.getSession().removeAttribute("user_info");  //退出登录之前移除session
    	ModelAndView mav = new ModelAndView("redirect:/login.jsp");
        return mav;
    }
    
    
    @RequestMapping("/toprofile")
    public ModelAndView loginSuccess(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("profile");
    }
    
    //首页
    @RequestMapping("/tosetting")
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response){
    	return new ModelAndView("setting");
    }
    
}
