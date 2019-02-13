package com.cqkj.dao;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo>
{
    /**
     * ����һ���û���¼�ķ���
     * 
     * @param loginName
     *            ��¼��
     * @param loginPwd
     *            ����
     * @return ����һ��UserInfo����
     * @throws Exception
     *             �쳣����
     */
    UserInfo login(String loginName, String loginPwd) throws Exception;

    /**
     * ��ҳ��ѯ
     * 
     * @param c
     * @param pageList
     * @param objs
     * @throws Exception
     */
    void selectByPage(Class<UserInfo> c, PageList<UserInfo> pageList, Object... objs) throws Exception;

    /**
     * ��ѯ�û��Ƿ����
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
    boolean userNameIsExist(String loginName) throws Exception;

    /**
     * ��ѯ����ѧ��
     * 
     * @param c
     * @param deptcode
     * @return
     * @throws Exception
     */
    List<UserInfo> selectStudent(Class<UserInfo> c, String deptcode) throws Exception;
}
