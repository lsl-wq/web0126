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
     * ��дʵ�ֵĽӿ�UserInfoDao�е��û���¼�ķ���
     * 
     * @param loginName
     *            ��¼��
     * @param loginPwd
     *            ����
     * @return ����һ��UserInfo����
     * @throws Exception
     *             �쳣����
     */
    public UserInfo login(String loginName, String loginPwd) throws Exception
    {
        // ����һ��UserInfo����
        UserInfo userInfo = null;

        // ��Ҫִ�е�sql���
        String sql = "select userId,deptId from UserInfo where loginName = ? and loginPwd = ?";

        // ���ü̳е�executeQuery���������õ��Ľ�����浽ResultSet������
        executeQuery(sql, loginName, loginPwd);

        // ���õ���userId,deptId���浽userInfo������
        while (rs.next())
        {
            // ����UserInfo����
            userInfo = new UserInfo();
            userInfo.setUserId(rs.getInt("userId"));
            userInfo.setDeptId(rs.getInt("deptId"));
        }

        return userInfo;
    }

    /**
     * ��ҳ��ѯ
     */
    public void selectByPage(Class<UserInfo> c, PageList<UserInfo> pageList, Object... objs) throws Exception
    {
        String sql = "select * from UserInfo where isdelete = 0";

        selectByPage(c, sql, pageList, objs);
    }

    @Override
    /**
     * �ж��û����Ƿ����
     */
    public boolean userNameIsExist(String loginName) throws Exception
    {
        String sql = "select count(1) from userInfo where loginName = ?";
        Object object = executeQueryObj(sql, loginName);
        return Integer.parseInt(object.toString()) > 0 ? true : false;
    }

    /**
     * ��ѯ����ѧ��
     */
    public List<UserInfo> selectStudent(Class<UserInfo> c, String deptcode) throws Exception
    {
        String sql = "select * from userinfo u where u.deptid in (select d.deptid from deptinfo d where d.deptcode = ?)";

        return selectAll(c, sql, deptcode);
    }
}
