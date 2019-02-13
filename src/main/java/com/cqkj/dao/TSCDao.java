package com.cqkj.dao;

import com.cqkj.bean.TSC;

public interface TSCDao extends BaseDao<TSC>
{
    /**
     * ѡ�εķ���
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    int addSC(TSC tsc) throws Exception;

    /**
     * ɾ��ѡ����Ϣ
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    int deleteSC(TSC tsc) throws Exception;

    /**
     * ��ѯָ��stuId,cId��ѡ����Ϣ
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    TSC getSelectTSC(int stuId, int cId) throws Exception;
}
