package com.cqkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.PageList;
import com.cqkj.dao.DeptInfoDao;
import com.cqkj.service.DeptInfoService;

@Service
public class DeptInfoServiceImpl implements DeptInfoService
{
    @Resource
    DeptInfoDao deptInfoDao;

    /**
     * ��ѯ���еĲ�����Ϣ
     * 
     * @return
     * @throws Exception
     */
    public List<DeptInfo> selectAllDeptInfo() throws Exception
    {
        return deptInfoDao.selectAll(DeptInfo.class);
    }

    /**
     * ��ҳ��ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<DeptInfo> pageList) throws Exception
    {
        deptInfoDao.selectByPage(DeptInfo.class, pageList);
    }

    /**
     * ��ӵķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean insertDeptInfo(DeptInfo deptInfo) throws Exception
    {
        return deptInfoDao.insert(deptInfo) == 0 ? false : true;
    }

    /**
     * ��ѯ�����û���Ϣ
     * 
     * @param deptId
     * @return
     * @throws Exception
     */
    public DeptInfo getDeptInfoById(int deptId) throws Exception
    {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setDeptId(deptId);
        return deptInfoDao.selectById(deptInfo);
    }

    /**
     * �޸ĵķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean updateDeptInfo(DeptInfo deptInfo) throws Exception
    {
        return deptInfoDao.update(deptInfo) == 0 ? false : true;
    }

    /**
     * ɾ���ķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean deleteDeptInfo(int deptId) throws Exception
    {
        DeptInfo deptInfo = new DeptInfo();
        deptInfo.setDeptId(deptId);
        return deptInfoDao.delete(deptInfo) == 0 ? false : true;
    }
}
