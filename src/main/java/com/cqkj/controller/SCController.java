package com.cqkj.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.remoting.RemoteTimeoutException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;
import com.cqkj.bean.TSC;
import com.cqkj.bean.TSCInfo;
import com.cqkj.service.TCourseService;
import com.cqkj.service.TSCInfoService;
import com.cqkj.service.TSCService;

/**
 * 
 * @author LSL
 * @createDate 2019年2月9日
 * @lastUpdateDate 2019年2月9日
 * @version 1.0
 */
@Controller
public class SCController
{
    @Resource
    TCourseService tCourseService;

    @Resource
    TSCService tSCService;

    @Resource
    TSC tsc;

    @Resource
    PageList<TSCInfo> pageList;

    @Resource
    TSCInfoService tSCInfoService;

    @GetMapping("/sc")
    public String sc()
    {
        return "view/SC/sc";
    }

    @PostMapping("/courses")
    @ResponseBody
    public List<TCourse> courses(HttpSession session) throws Exception
    {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());

        return tCourseService.getUnselectedCourse(userId);
    }

    @PostMapping("/scInfo")
    @ResponseBody
    public String selectCourse(Integer selectCourse, HttpSession session) throws Exception
    {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());

        if (selectCourse > 0)
        {
            tsc.setCId(selectCourse);
            tsc.setStuId(userId);
            tsc.setScore(0);
            tsc.setCreateDate(new Date());

            String mag;
            if (tSCService.addSCService(tsc))
            {
                return "Y";
            } else
            {
                return "N";
            }
        } else
        {
            return "E";
        }
    }

    @PostMapping("/scDo")
    @ResponseBody
    public PageList<TSCInfo> scDo(Integer page, HttpSession session) throws Exception
    {
        int userId = Integer.parseInt(session.getAttribute("userId").toString());

        pageList.setPageIndex(page);

        tSCInfoService.selectSCService(pageList, userId);

        return pageList;
    }

    @PostMapping("/deleteSC")
    @ResponseBody
    public String deleteSC(Integer scId) throws Exception
    {
        tsc.setScId(scId);

        String mag;
        if (tSCService.deleteSCService(tsc))
        {
            mag = "Y";
        } else
        {
            mag = "N";
        }

        return mag;
    }
}
