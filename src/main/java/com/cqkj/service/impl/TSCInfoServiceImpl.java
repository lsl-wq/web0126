package com.cqkj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TSCInfo;
import com.cqkj.dao.TSCInfoDao;
import com.cqkj.service.TSCInfoService;

@Service
public class TSCInfoServiceImpl implements TSCInfoService
{
    @Resource
    TSCInfoDao tscInfoDao;

    /**
     * 查询所选课程的具体信息
     * 
     * @param stuId
     * @return
     * @throws Exception
     */
    public void selectSCService(PageList<TSCInfo> pageList, int stuId) throws Exception
    {
        tscInfoDao.selectSC(pageList, stuId);
    }
}
