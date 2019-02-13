package com.cqkj.service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;

public interface ScoresService
{
    /**
     * ��ѯ�ɼ��ķ���
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList) throws Exception;

    /**
     * ��ѧ��ID��ѯ�ɼ��ķ���
     * 
     * @param pageList
     * @param stuId
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList, int stuId) throws Exception;
}
