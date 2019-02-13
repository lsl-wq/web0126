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
     * ģ����ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public List<TCourse> getSelectAllCourse(String cName) throws Exception
    {
        return tCourseDao.selectAllCourse(TCourse.class, cName);
    }

    /**
     * ��ҳ��ѯ
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
     * ɾ���ķ���
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
     * ����id��ѯ�γ���Ϣ
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
     * ��ӵķ���
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
     * �޸ĵķ���
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
     * ���γ̱�Ų�ѯ�γ���Ϣ
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
     * ��ѯѧ��δѡ�γ̵ľ���ʵ�ַ���
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
     * ��ѯѧ����ѡ�γ̵ľ���ʵ�ַ���
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
