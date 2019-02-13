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
    // 数据访问对象
    @Resource
    UserInfoDao userInfoDao;

    /**
     * 用户登录的实现方法
     * 
     * @param loginName
     *            登录名
     * @param loginPwd
     *            密码
     * @return 返回一个UserInfo对象
     * @throws Exception
     *             异常处理
     */
    public UserInfo loginService(String loginName, String loginPwd) throws Exception
    {
        return userInfoDao.login(loginName, loginPwd);
    }

    /**
     * 查询所有用户的方法
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectAll() throws Exception
    {
        return userInfoDao.selectAll(UserInfo.class);
    }

    /**
     * 分页查询
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<UserInfo> pageList) throws Exception
    {
        userInfoDao.selectByPage(UserInfo.class, pageList);
    }

    /**
     * 添加的方法
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
     * 物理删除的方法
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
     * 修改的方法
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
     * 查询单个用户信息
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
     * 判断用户名是否存在
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
     * 查询所有学生
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectStudentService() throws Exception
    {
        return userInfoDao.selectStudent(UserInfo.class, "student");
    }
}
