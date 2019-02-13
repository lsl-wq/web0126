package com.cqkj.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cqkj.bean.DeptInfo;
import com.cqkj.service.DeptInfoService;

@Controller
public class DeptInfoController
{
    @Resource
    DeptInfoService deptInfoService;

    @Resource
    DeptInfo deptInfo;

    @GetMapping("/deptInfo")
    public String deptInfo(Integer pageIndex, ModelMap map)
    {
        if (pageIndex != null)
        {
            map.put("pageIndex", pageIndex);
        }
        return "view/deptInfo/deptInfo";
    }

    @GetMapping("/addDept")
    public String addUser(Integer flag, Integer deptId, ModelMap map)
    {
        if (deptId != null)
        {
            map.put("deptId", deptId);
        }

        map.put("flag", flag);

        return "view/deptInfo/addDept";
    }

    @GetMapping("/deleteDeptInfo")
    public String deleteDeptInfo(Integer deptId) throws Exception
    {
        deptInfoService.deleteDeptInfo(deptId);

        return "view/deptInfo/deptInfo";
    }

    @PostMapping("/addDeptInfo")
    public String addDeptInfo(HttpServletRequest request) throws Exception
    {
        deptInfo.setDeptCode(request.getParameter("deptCode"));
        deptInfo.setDeptName(request.getParameter("deptName"));

        deptInfoService.insertDeptInfo(deptInfo);

        return "view/deptInfo/deptInfo";
    }

    @PostMapping("/updateDeptInfo")
    public String updateDeptInfo(HttpServletRequest request) throws Exception
    {
        deptInfo.setDeptId(Integer.parseInt(request.getParameter("deptId")));
        deptInfo.setDeptCode(request.getParameter("deptCode"));
        deptInfo.setDeptName(request.getParameter("deptName"));

        deptInfoService.updateDeptInfo(deptInfo);

        return "view/deptInfo/deptInfo";
    }
}
