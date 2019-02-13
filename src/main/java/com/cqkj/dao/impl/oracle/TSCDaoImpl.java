package com.cqkj.dao.impl.oracle;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cqkj.bean.TSC;
import com.cqkj.dao.TSCDao;

@Component
public class TSCDaoImpl extends BaseDaoImpl<TSC> implements TSCDao
{
    /**
     * 选课的方法
     */
    public int addSC(TSC tsc) throws Exception
    {
        return insert(tsc);
    }

    /**
     * 删除选课信息
     */
    public int deleteSC(TSC tsc) throws Exception
    {
        return delete(tsc);
    }

    /**
     * 查询指定stuId,cId的选课信息
     * 
     * @param stuId
     * @param cId
     * @return
     * @throws Exception
     */
    public TSC getSelectTSC(int stuId, int cId) throws Exception
    {
        String sql = "select * from TSC where stuId = ? and cId = ?";
        List<TSC> list = selectAll(TSC.class, sql, stuId, cId);
        return list.get(0);
    }
}
