package com.cqkj.dao;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;

public interface ScoresDao extends BaseDao<Scores>
{
    /**
     * 查询成绩的方法
     * 
     * @param c
     * @param pageList
     * @throws Exception
     */
    void selectScores(Class<Scores> c, PageList<Scores> pageList) throws Exception;

    /**
     * 按学生ID查询成绩的方法
     * 
     * @param c
     * @param pageList
     * @param stuId
     * @throws Exception
     */
    void selectScores(Class<Scores> c, PageList<Scores> pageList, int stuId) throws Exception;

}
