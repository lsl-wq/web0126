package com.cqkj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;
import com.cqkj.dao.ScoresDao;
import com.cqkj.service.ScoresService;

@Service
public class ScoresServiceImpl implements ScoresService
{
    @Resource
    ScoresDao scoresDao;

    /**
     * ��ѯ�ɼ��ķ���
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList) throws Exception
    {
        scoresDao.selectScores(Scores.class, pageList);
    }

    /**
     * ��ѧ��ID��ѯ�ɼ��ķ���
     * 
     * @param pageList
     * @param stuId
     * @throws Exception
     */
    public void selectScoresService(PageList<Scores> pageList, int stuId) throws Exception
    {
        scoresDao.selectScores(Scores.class, pageList, stuId);
    }
}
