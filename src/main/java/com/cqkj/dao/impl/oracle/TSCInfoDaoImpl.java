package com.cqkj.dao.impl.oracle;

import org.springframework.stereotype.Component;

import com.cqkj.bean.PageList;
import com.cqkj.bean.TSCInfo;
import com.cqkj.dao.TSCInfoDao;

@Component
public class TSCInfoDaoImpl extends BaseDaoImpl<TSCInfo> implements TSCInfoDao
{
    /**
     * 查询所选课程的信息
     */
    public void selectSC(PageList<TSCInfo> pageList, int stuId) throws Exception
    {
        String sql = "select tsc.scid,tc.cno,tc.cname,tsc.createdate,tsc.score from tcourse tc join tsc on tc.cid = tsc.cid where tsc.stuid = ?";

        selectByPage(TSCInfo.class, sql, pageList, stuId);
    }
}
