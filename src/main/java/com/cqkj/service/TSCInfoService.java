package com.cqkj.service;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TSCInfo;

public interface TSCInfoService
{
    /**
     * ��ѯ��ѡ�γ̵ľ�����Ϣ
     * 
     * @param stuId
     * @return
     * @throws Exception
     */
    public void selectSCService(PageList<TSCInfo> pageList, int stuId) throws Exception;
}
