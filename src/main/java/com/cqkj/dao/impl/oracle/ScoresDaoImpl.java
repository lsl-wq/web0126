package com.cqkj.dao.impl.oracle;

import org.springframework.stereotype.Component;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;
import com.cqkj.dao.ScoresDao;

@Component
public class ScoresDaoImpl extends BaseDaoImpl<Scores> implements ScoresDao
{
    /**
     * 查询成绩的方法
     */
    public void selectScores(Class<Scores> c, PageList<Scores> pageList) throws Exception
    {
        String sql = "select name,cNo,cName,score,tsc.createDate from userinfo u join tsc on tsc.stuid = u.userid join tcourse c on tsc.cid = c.cid where tsc.score > 0";

        selectByPage(c, sql, pageList);
    }

    @Override
    /**
     * 按ID查询成绩的方法
     */
    public void selectScores(Class<Scores> c, PageList<Scores> pageList, int stuId) throws Exception
    {
        String sql = "select name,cNo,cName,score,tsc.createDate from userinfo u join tsc on tsc.stuid = u.userid join tcourse c on tsc.cid = c.cid where u.userid = ?";

        selectByPage(c, sql, pageList, stuId);
    }
}
