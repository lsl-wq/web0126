package com.cqkj.dao;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.PageList;

public interface DeptInfoDao extends BaseDao<DeptInfo>
{
    void selectByPage(Class<DeptInfo> c, PageList<DeptInfo> pageList, Object... objs) throws Exception;
}
