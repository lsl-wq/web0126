package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;

public interface TCourseService
{
    /**
     * ģ����ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public List<TCourse> getSelectAllCourse(String cName) throws Exception;

    /**
     * ��ҳ��ѯ
     * 
     * @param pageList
     * @param cName
     * @throws Exception
     */
    public void getSelectByPageCourse(PageList<TCourse> pageList, String cName) throws Exception;

    /**
     * ɾ���ķ���
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public boolean deleteCourse(int cId) throws Exception;

    /**
     * ����id��ѯ�γ���Ϣ
     * 
     * @param cId
     * @return
     * @throws Exception
     */
    public TCourse getTCourseById(int cId) throws Exception;

    /**
     * ��ӵķ���
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean insertTCourse(TCourse tCourse) throws Exception;

    /**
     * �޸ĵķ���
     * 
     * @param tCourse
     * @return
     * @throws Exception
     */
    public boolean updateTCourse(TCourse tCourse) throws Exception;

    /**
     * ���γ̱�Ų�ѯ�γ���Ϣ
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    public boolean getCNoIsExist(String cNo) throws Exception;

    /**
     * ��ѯѧ��δѡ�γ̵ľ���ʵ�ַ���
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getUnselectedCourse(int userId) throws Exception;

    /**
     * ��ѯѧ����ѡ�γ̵ľ���ʵ�ַ���
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> getSelectCourse(int userId) throws Exception;
}
