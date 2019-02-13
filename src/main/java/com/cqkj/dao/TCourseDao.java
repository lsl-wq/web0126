package com.cqkj.dao;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;

public interface TCourseDao extends BaseDao<TCourse>
{

    /**
     * ��ѯ�ķ���
     * 
     * @param c
     * @param cName
     * @return
     * @throws Exception
     */
    List<TCourse> selectAllCourse(Class<TCourse> c, String cName) throws Exception;

    /**
     * ��ҳ��ѯ�ķ���
     * 
     * @param c
     * @param pageList
     * @param cName
     * @throws Exception
     */
    void selectByPageCourse(Class<TCourse> c, PageList<TCourse> pageList, String cName) throws Exception;

    /**
     * ����Ų�ѯ�ͻ���Ϣ
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    boolean cNoIsExist(String cNo) throws Exception;

    /**
     * ��ѯѧ��δѡ�Ŀγ�
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    List<TCourse> unselectedCourse(int userId) throws Exception;

    /**
     * ��ѯѧ����ѡ�Ŀγ�
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    List<TCourse> selectedCourse(int userId) throws Exception;
}
