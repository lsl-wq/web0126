package com.cqkj.dao.impl.oracle;

import org.springframework.stereotype.Component;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.PageList;
import com.cqkj.dao.DeptInfoDao;

@Component
public class DeptInfoDaoImpl extends BaseDaoImpl<DeptInfo> implements DeptInfoDao
{
    /**
     * ∑÷“≥≤È—Ø
     */
    public void selectByPage(Class<DeptInfo> c, PageList<DeptInfo> pageList, Object... objs) throws Exception
    {
        String sql = "select * from DeptInfo";

        selectByPage(c, sql, pageList, objs);
    }
}
