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
     * 查询所有的部门信息
     * 
     * @return
     * @throws Exception
     */
    public List<DeptInfo> selectAllDeptInfo() throws Exception
    {
        return deptInfoDao.selectAll(DeptInfo.class);
    }

    /**
     * 分页查询
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<DeptInfo> pageList) throws Exception
    {
        deptInfoDao.selectByPage(DeptInfo.class, pageList);
    }

    /**
     * 添加的方法
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
     * 查询单个用户信息
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
     * 修改的方法
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
     * 删除的方法
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
