package com.cqkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;
import com.cqkj.dao.TCourseDao;
import com.cqkj.service.TCourseService;

@Service("tCourseServiceImpl")
public class TCourseServiceImpl implements TCourseService
{
    @Resource
    TCourseDao tCourseDao;

    /**
     * 模糊查询
     * 
     * @param pageList
     * @throws Exception
     */
    public List<TCourse> getSelectAllCourse(String cName) throws Exception
    {
        return tCourseDao.selectAllCourse(TCourse.class, cName);
    }

    /**
     * 分页查询
     * 
     * @param pageList
     * @param cName
     * @throws Exception
     */
    public void getSelectByPageCourse(PageList<TCourse> pageList, String cName) throws Exception
    {
        tCourseDao.selectByPageCourse(TCourse.class, pageList, cName);
    }

    /**
     * 删除的方法
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public boolean deleteCourse(int cId) throws Exception
    {
        TCourse tCourse = new TCourse();
        tCourse.setcId(cId);
        return tCourseDao.delete(tCourse) == 0 ? false : true;
    }

    /**
     * 根据id查询课程信息
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public TCourse getTCourseById(int cId) throws Exception
    {
        TCourse tCourse = new TCourse();
        tCourse.setcId(cId);
        return tCourseDao.selectById(tCourse);
    }

    /**
     * 添加的方法
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean insertTCourse(TCourse tCourse) throws Exception
    {
        return tCourseDao.insert(tCourse) == 0 ? false : true;
    }

    /**
     * 修改的方法
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean updateTCourse(TCourse tCourse) throws Exception
    {
        return tCourseDao.update(tCourse) == 0 ? false : true;
    }

    /**
     * 按课程编号查询课程信息
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    public boolean getCNoIsExist(String cNo) throws Exception
    {
        return tCourseDao.cNoIsExist(cNo);
    }

    /**
     * 查询学生未选课程的具体实现方法
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getUnselectedCourse(int userId) throws Exception
    {
        return tCourseDao.unselectedCourse(userId);
    }

    /**
     * 查询学生已选课程的具体实现方法
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getSelectCourse(int userId) throws Exception
    {
        return tCourseDao.selectedCourse(userId);
    }
}
