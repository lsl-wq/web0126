package com.cqkj.service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TSCInfo;

public interface TSCInfoService
{
    /**
     * 查询所选课程的具体信息
     * 
     * @param stuId
     * @return
     * @throws Exception
     */
    public void selectSCService(PageList<TSCInfo> pageList, int stuId) throws Exception;
}
