package com.cqkj.dao;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TSCInfo;

public interface TSCInfoDao extends BaseDao<TSCInfo>
{
    void selectSC(PageList<TSCInfo> pageList, int stuId) throws Exception;
}
