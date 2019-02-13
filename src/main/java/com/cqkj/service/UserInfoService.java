package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;

public interface UserInfoService
{
    /**
     * �û���¼��ʵ�ַ���
     * 
     * @param loginName
     *            ��¼��
     * @param loginPwd
     *            ����
     * @return ����һ��UserInfo����
     * @throws Exception
     *             �쳣����
     */
    public UserInfo loginService(String loginName, String loginPwd) throws Exception;

    /**
     * ��ѯ�����û��ķ���
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectAll() throws Exception;

    /**
     * ��ҳ��ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<UserInfo> pageList) throws Exception;

    /**
     * ��ӵķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean insertUserInfo(UserInfo userInfo) throws Exception;

    /**
     * ����ɾ���ķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean deleteUserInfo(int userId) throws Exception;

    /**
     * �޸ĵķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean updateUserInfo(UserInfo userInfo) throws Exception;

    /**
     * ��ѯ�����û���Ϣ
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public UserInfo getUserInfoById(int userId) throws Exception;

    /**
     * �ж��û����Ƿ����
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
    public boolean userNameIsExist(String loginName) throws Exception;

    /**
     * ��ѯ����ѧ��
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectStudentService() throws Exception;
}
