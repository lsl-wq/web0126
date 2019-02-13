package com.cqkj.service;

import com.cqkj.bean.TSC;

public interface TSCService
{
    /**
     * ѡ�ε�ʵ�ַ���
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean addSCService(TSC tsc) throws Exception;
    
    /**
     * ɾ��ѡ����Ϣ
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean deleteSCService(TSC tsc) throws Exception;
    
    /**
     * ��ѯָ��stuId,cId��ѡ����Ϣ
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    public TSC getTSCService(int stuId, int cId) throws Exception;
    
    /**
     * �޸ĵķ���
     * 
     * @param tsc
     * @return
     * @throws Exception
     */
    public boolean updateTSC(TSC tsc) throws Exception;
}
