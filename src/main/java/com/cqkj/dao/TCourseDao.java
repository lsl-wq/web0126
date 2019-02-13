package com.cqkj.dao;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;

public interface TCourseDao extends BaseDao<TCourse>
{

    /**
     * 查询的方法
     * 
     * @param c
     * @param cName
     * @return
     * @throws Exception
     */
    List<TCourse> selectAllCourse(Class<TCourse> c, String cName) throws Exception;

    /**
     * 分页查询的方法
     * 
     * @param c
     * @param pageList
     * @param cName
     * @throws Exception
     */
    void selectByPageCourse(Class<TCourse> c, PageList<TCourse> pageList, String cName) throws Exception;

    /**
     * 按编号查询客户信息
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    boolean cNoIsExist(String cNo) throws Exception;

    /**
     * 查询学生未选的课程
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    List<TCourse> unselectedCourse(int userId) throws Exception;

    /**
     * 查询学生已选的课程
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    List<TCourse> selectedCourse(int userId) throws Exception;
}
