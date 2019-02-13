package com.cqkj.service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;

public interface ScoresService
{
    /**
     * 查询成绩的方法
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList) throws Exception;

    /**
     * 按学生ID查询成绩的方法
     * 
     * @param pageList
     * @param stuId
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList, int stuId) throws Exception;
}
