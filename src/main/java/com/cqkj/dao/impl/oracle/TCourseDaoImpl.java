package com.cqkj.dao.impl.oracle;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TCourse;
import com.cqkj.dao.TCourseDao;

@Component
public class TCourseDaoImpl extends BaseDaoImpl<TCourse> implements TCourseDao
{

    @Override
    /**
     * ��ҳ��ѯ�ķ���
     */
    public List<TCourse> selectAllCourse(Class<TCourse> c, String cName) throws Exception
    {
        String sql = "select * from TCourse";

        if (cName == null || cName.isEmpty())
        {
            return selectAll(c, sql);
        } else
        {
            sql = sql + " where cName like ?";
            return selectAll(c, sql, "%" + cName + "%");
        }
    }

    /**
     * ��ҳ��ѯ
     * 
     * @param c
     * @param pageList
     * @param cName
     * @throws Exception
     */
    public void selectByPageCourse(Class<TCourse> c, PageList<TCourse> pageList, String cName) throws Exception
    {
        String sql = "select * from TCourse";

        if (cName == null || cName.isEmpty())
        {
            selectByPage(c, sql, pageList);
        } else
        {
            sql = sql + " where cName like ?";

            selectByPage(c, sql, pageList, "%" + cName + "%");
        }
    }

    /**
     * ����Ų�ѯ�γ���Ϣ
     * 
     * @param cNo
     * @return
     * @throws Exception
     */
    public boolean cNoIsExist(String cNo) throws Exception
    {
        String sql = "select count(1) from TCourse where cNo = ?";

        return Integer.parseInt(executeQueryObj(sql, cNo).toString()) > 0 ? true : false;
    }

    /**
     * ��ѯѧ��δѡ�Ŀγ�
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<TCourse> unselectedCourse(int userId) throws Exception
    {
        String sql = "select c.cid,c.cno,c.cname,c.createdate from tcourse c minus (select tc.cid,tc.cno,tc.cname,tc.createdate from tcourse tc join tsc on tc.cid = tsc.cid where tsc.stuid = ?)";

        return selectAll(TCourse.class, sql, userId);
    }

    /**
     * ��ѯѧ����ѡ�Ŀγ�
     */
    public List<TCourse> selectedCourse(int userId) throws Exception
    {
        String sql = "select tc.cid,tc.cno,tc.cname,tc.createdate from tcourse tc join tsc on tc.cid = tsc.cid where tsc.stuid = ?";

        return selectAll(TCourse.class, sql, userId);
    }
}
