package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;

public interface UserInfoService
{
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
    public UserInfo loginService(String loginName, String loginPwd) throws Exception;

    /**
     * 查询所有用户的方法
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectAll() throws Exception;

    /**
     * 分页查询
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<UserInfo> pageList) throws Exception;

    /**
     * 添加的方法
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean insertUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 物理删除的方法
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean deleteUserInfo(int userId) throws Exception;

    /**
     * 修改的方法
     * 
     * @param userInfo
     * @return
     * @throws Exception
     */
    public boolean updateUserInfo(UserInfo userInfo) throws Exception;

    /**
     * 查询单个用户信息
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public UserInfo getUserInfoById(int userId) throws Exception;

    /**
     * 判断用户名是否存在
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
    public boolean userNameIsExist(String loginName) throws Exception;

    /**
     * 查询所有学生
     * 
     * @return
     * @throws Exception
     */
    public List<UserInfo> selectStudentService() throws Exception;
}
