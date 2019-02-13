package com.cqkj.dao;

import java.util.List;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;

public interface UserInfoDao extends BaseDao<UserInfo>
{
    /**
     * 定义一个用户登录的方法
     * 
     * @param loginName
     *            登录名
     * @param loginPwd
     *            密码
     * @return 返回一个UserInfo对象
     * @throws Exception
     *             异常处理
     */
    UserInfo login(String loginName, String loginPwd) throws Exception;

    /**
     * 分页查询
     * 
     * @param c
     * @param pageList
     * @param objs
     * @throws Exception
     */
    void selectByPage(Class<UserInfo> c, PageList<UserInfo> pageList, Object... objs) throws Exception;

    /**
     * 查询用户是否存在
     * 
     * @param loginName
     * @return
     * @throws Exception
     */
    boolean userNameIsExist(String loginName) throws Exception;

    /**
     * 查询所有学生
     * 
     * @param c
     * @param deptcode
     * @return
     * @throws Exception
     */
    List<UserInfo> selectStudent(Class<UserInfo> c, String deptcode) throws Exception;
}
