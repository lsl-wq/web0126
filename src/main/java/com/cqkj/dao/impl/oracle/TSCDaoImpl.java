package com.cqkj.dao.impl.oracle;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cqkj.bean.TSC;
import com.cqkj.dao.TSCDao;

@Component
public class TSCDaoImpl extends BaseDaoImpl<TSC> implements TSCDao
{
    /**
     * ѡ�εķ���
     */
    public int addSC(TSC tsc) throws Exception
    {
        return insert(tsc);
    }

    /**
     * ɾ��ѡ����Ϣ
     */
    public int deleteSC(TSC tsc) throws Exception
    {
        return delete(tsc);
    }

    /**
     * ��ѯָ��stuId,cId��ѡ����Ϣ
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
