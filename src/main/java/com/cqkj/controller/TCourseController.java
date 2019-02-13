package com.cqkj.controller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;
import com.cqkj.service.TCourseService;

/**
 * 
 * @author LSL
 * @createDate 2019年2月7日
 * @lastUpdateDate 2019年2月7日
 * @version 1.0
 */
@Controller
public class TCourseController
{
    @Resource
    PageList<TCourse> pageList;

    @Resource
    TCourseService tCourseService;

    @Resource
    TCourse tCourse;

    @GetMapping("/course")
    public String course()
    {
        return "view/course/course";
    }

    @GetMapping("/addCourse")
    public String addUser(Integer flag, Integer cId, ModelMap map)
    {
        if (cId != null)
        {
            map.put("cId", cId);
        }

        map.put("flag", flag);

        return "view/course/addCourse";
    }

    @PostMapping("/selectAllCourse")
    @ResponseBody
    public PageList<TCourse> select(String cName, String pageIndex) throws Exception
    {
        // 更改pageList的起始页码
        pageList.setPageIndex(Integer.parseInt(pageIndex));

        // 调用分页查询的方法
        tCourseService.getSelectByPageCourse(pageList, cName);

        return pageList;
    }

    @PostMapping("/courseCountPage")
    @ResponseBody
    public int countPage(String cName) throws Exception
    {
        // 调用分页查询的方法
        tCourseService.getSelectByPageCourse(pageList, cName);

        return pageList.getPageCount();
    }

    @PostMapping("/deleteCourse")
    @ResponseBody
    public String delete(Integer cId) throws Exception
    {
        // 调用方法判断该课程是否可以删除
        if (tCourseService.deleteCourse(cId))
        {
            return "Y";
        } else
        {
            return "N";
        }
    }

    @PostMapping("/addTCourse")
    public String add(HttpServletRequest request) throws Exception
    {
        //给课程对象添加参数
        tCourse.setcNo(request.getParameter("cNo"));
        tCourse.setcName(request.getParameter("cName"));
        tCourse.setCreateDate(new Date());

        // 调用方法插入
        tCourseService.insertTCourse(tCourse);

        return "view/course/course";
    }

    @PostMapping("/updateCourse")
    public String update(HttpServletRequest request) throws Exception
    {
        // 给课程对象添加参数
        tCourse.setcId(Integer.parseInt(request.getParameter("cId")));
        tCourse.setcNo(request.getParameter("cNo"));
        tCourse.setcName(request.getParameter("cName"));
        tCourse.setCreateDate(new Date(Long.parseLong(request.getParameter("createDate"))));

        // 调用方法修改
        tCourseService.updateTCourse(tCourse);

        return "view/course/course";
    }

    @PostMapping("/checkCNo")
    @ResponseBody
    public String checkCNo(String cNo) throws Exception
    {
        // 调用方法判断该编号是否已经使用过
        if (tCourseService.getCNoIsExist(cNo))
        {
            return "Y";
        } else
        {
            return "N";
        }
    }
}
