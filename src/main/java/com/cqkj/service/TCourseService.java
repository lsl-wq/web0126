package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;

public interface TCourseService
{
    /**
     * 模糊查询
     * 
     * @param pageList
     * @throws Exception
     */
    public List<TCourse> getSelectAllCourse(String cName) throws Exception;

    /**
     * 分页查询
     * 
     * @param pageList
     * @param cName
     * @throws Exception
     */
    public void getSelectByPageCourse(PageList<TCourse> pageList, String cName) throws Exception;

    /**
     * 删除的方法
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public boolean deleteCourse(int cId) throws Exception;

    /**
     * 根据id查询课程信息
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public TCourse getTCourseById(int cId) throws Exception;

    /**
     * 添加的方法
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean insertTCourse(TCourse tCourse) throws Exception;

    /**
     * 修改的方法
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean updateTCourse(TCourse tCourse) throws Exception;

    /**
     * 按课程编号查询课程信息
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    public boolean getCNoIsExist(String cNo) throws Exception;

    /**
     * 查询学生未选课程的具体实现方法
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getUnselectedCourse(int userId) throws Exception;

    /**
     * 查询学生已选课程的具体实现方法
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getSelectCourse(int userId) throws Exception;
}
