package com.cqkj.dao.impl.oracle;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cqkj.bean.PageList;
import com.cqkj.bean.UserInfo;
import com.cqkj.dao.UserInfoDao;

@Component
public class UserInfoDaoImpl extends BaseDaoImpl<UserInfo> implements UserInfoDao
{

    @Override
    /**
     * 重写实现的接口UserInfoDao中的用户登录的方法
     * 
     * @param loginName
     *            登录名
     * @param loginPwd
     *            密码
     * @return 返回一个UserInfo对象
     * @throws Exception
     *             异常处理
     */
    public UserInfo login(String loginName, String loginPwd) throws Exception
    {
        // 定义一个UserInfo对象
        UserInfo userInfo = null;

        // 需要执行的sql语句
        String sql = "select userId,deptId from UserInfo where loginName = ? and loginPwd = ?";

        // 调用继承的executeQuery方法，将得到的结果保存到ResultSet对象中
        executeQuery(sql, loginName, loginPwd);

        // 将得到的userId,deptId保存到userInfo对象中
        while (rs.next())
        {
            // 创建UserInfo对象
            userInfo = new UserInfo();
            userInfo.setUserId(rs.getInt("userId"));
            userInfo.setDeptId(rs.getInt("deptId"));
        }

        return userInfo;
    }

    /**
     * 分页查询
     */
    public void selectByPage(Class<UserInfo> c, PageList<UserInfo> pageList, Object... objs) throws Exception
    {
        String sql = "select * from UserInfo where isdelete = 0";

        selectByPage(c, sql, pageList, objs);
    }

    @Override
    /**
     * 判断用户名是否存在
     */
    public boolean userNameIsExist(String loginName) throws Exception
    {
        String sql = "select count(1) from userInfo where loginName = ?";
        Object object = executeQueryObj(sql, loginName);
        return Integer.parseInt(object.toString()) > 0 ? true : false;
    }

    /**
     * 查询所有学生
     */
    public List<UserInfo> selectStudent(Class<UserInfo> c, String deptcode) throws Exception
    {
        String sql = "select * from userinfo u where u.deptid in (select d.deptid from deptinfo d where d.deptcode = ?)";

        return selectAll(c, sql, deptcode);
    }
}
