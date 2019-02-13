package com.cqkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;
import com.cqkj.dao.UserInfoDao;
import com.cqkj.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService
{
    // ���ݷ��ʶ���
    @Resource
    UserInfoDao userInfoDao;

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
    public UserInfo loginService(String loginName, String loginPwd) throws Exception
    {
        return userInfoDao.login(loginName, loginPwd);
    }

    /**
     * ��ѯ�����û��ķ���
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectAll() throws Exception
    {
        return userInfoDao.selectAll(UserInfo.class);
    }

    /**
     * ��ҳ��ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<UserInfo> pageList) throws Exception
    {
        userInfoDao.selectByPage(UserInfo.class, pageList);
    }

    /**
     * ��ӵķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean insertUserInfo(UserInfo userInfo) throws Exception
    {
        return userInfoDao.insert(userInfo) == 0 ? false : true;
    }

    /**
     * ����ɾ���ķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean deleteUserInfo(int userId) throws Exception
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        return userInfoDao.delete(userInfo) == 0 ? false : true;
    }

    /**
     * �޸ĵķ���
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean updateUserInfo(UserInfo userInfo) throws Exception
    {
        return userInfoDao.update(userInfo) == 0 ? false : true;
    }

    /**
     * ��ѯ�����û���Ϣ
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public UserInfo getUserInfoById(int userId) throws Exception
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        return userInfoDao.selectById(userInfo);
    }

    /**
     * �ж��û����Ƿ����
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
    public boolean userNameIsExist(String loginName) throws Exception
    {
        return userInfoDao.userNameIsExist(loginName);
    }

    /**
     * ��ѯ����ѧ��
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectStudentService() throws Exception
    {
        return userInfoDao.selectStudent(UserInfo.class, "student");
    }
}
