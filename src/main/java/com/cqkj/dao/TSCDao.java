package com.cqkj.dao;

import com.cqkj.bean.TSC;

public interface TSCDao extends BaseDao<TSC>
{
    /**
     * 选课的方法
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    int addSC(TSC tsc) throws Exception;

    /**
     * 删除选课信息
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    int deleteSC(TSC tsc) throws Exception;

    /**
     * 查询指定stuId,cId的选课信息
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    TSC getSelectTSC(int stuId, int cId) throws Exception;
}
