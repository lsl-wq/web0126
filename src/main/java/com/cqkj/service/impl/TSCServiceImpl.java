package com.cqkj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.TSC;
import com.cqkj.dao.TSCDao;
import com.cqkj.service.TSCService;

@Service
public class TSCServiceImpl implements TSCService
{
    @Resource
    TSCDao tscDao;

    /**
     * ѡ�ε�ʵ�ַ���
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean addSCService(TSC tsc) throws Exception
    {
        return tscDao.addSC(tsc) == 0 ? false : true;
    }

    /**
     * ɾ��ѡ����Ϣ
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean deleteSCService(TSC tsc) throws Exception
    {
        return tscDao.deleteSC(tsc) == 0 ? false : true;
    }

    /**
     * ��ѯָ��stuId,cId��ѡ����Ϣ
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    public TSC getTSCService(int stuId, int cId) throws Exception
    {
        return tscDao.getSelectTSC(stuId, cId);
    }

    /**
     * �޸ĵķ���
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean updateTSC(TSC tsc) throws Exception
    {
        return tscDao.update(tsc) == 0 ? false : true;
    }
}
