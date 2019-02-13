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
     * 选课的实现方法
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
     * 删除选课信息
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
     * 查询指定stuId,cId的选课信息
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
     * 修改的方法
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
