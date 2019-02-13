package com.cqkj.service;

import com.cqkj.bean.TSC;

public interface TSCService
{
    /**
     * 选课的实现方法
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean addSCService(TSC tsc) throws Exception;
    
    /**
     * 删除选课信息
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean deleteSCService(TSC tsc) throws Exception;
    
    /**
     * 查询指定stuId,cId的选课信息
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    public TSC getTSCService(int stuId, int cId) throws Exception;
    
    /**
     * 修改的方法
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean updateTSC(TSC tsc) throws Exception;
}
