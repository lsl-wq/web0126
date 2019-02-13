package com.cqkj.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.UserInfo;
import com.cqkj.service.DeptInfoService;
import com.cqkj.service.UserInfoService;

@Controller
public class LoginController
{
    @Resource
    UserInfoService userInfoService;

    @Resource
    DeptInfoService deptInfoService;

    @GetMapping("/login")
    public String login()
    {
        return "login";
    }

    /*@PostMapping("/loginDo")
    public ModelAndView loginDo(String loginName, String loginPwd, HttpSession session) throws Exception
    {
        UserInfo userInfo = userInfoService.loginService(loginName, loginPwd);
    
        Map<String, Integer> map = new HashMap<String, Integer>();
    
        if (userInfo == null)
        {
            map.put("msg", 0);
    
            return new ModelAndView("login", map);
        } else
        {
            session.setAttribute("userId", userInfo.getUserId());
            session.setAttribute("loginName", loginName);
    
            DeptInfo deptInfo = deptInfoService.getDeptInfoById(userInfo.getDeptId());
    
            session.setAttribute("deptCode", deptInfo.getDeptCode());
    
            return new ModelAndView("redirect:index");
        }
    }*/

    @PostMapping("/loginDo")
    public String loginDo(String loginName, String loginPwd, ModelMap map, HttpSession session) throws Exception
    {
        UserInfo userInfo = userInfoService.loginService(loginName, loginPwd);

        if (userInfo == null)
        {
            map.put("msg", 0);

            return "login";
        } else
        {
            session.setAttribute("userId", userInfo.getUserId());
            session.setAttribute("loginName", loginName);

            DeptInfo deptInfo = deptInfoService.getDeptInfoById(userInfo.getDeptId());

            session.setAttribute("deptCode", deptInfo.getDeptCode());

            return "redirect:index";
        }
    }

    @GetMapping("/index")
    public String index(HttpSession session)
    {
        return "index";
    }
    
    @GetMapping("/welcome")
    public String welcome()
    {
        return "welcome";
    }
    
    @GetMapping("/dropOutDo")
    public String dropOutDo(HttpSession session)
    {
        session.invalidate();
        
        return "redirect:login";
    }
}
