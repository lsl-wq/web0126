package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.PageList;

public interface DeptInfoService
{
    /**
     * 查询所有的部门信息
     * 
     * @return
     * @throws Exception
     */
    public List<DeptInfo> selectAllDeptInfo() throws Exception;

    /**
     * 分页查询
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<DeptInfo> pageList) throws Exception;

    /**
     * 添加的方法
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean insertDeptInfo(DeptInfo deptInfo) throws Exception;

    /**
     * 查询单个用户信息
     * 
     * @param deptId
     * @return
     * @throws Exception
     */
    public DeptInfo getDeptInfoById(int deptId) throws Exception;

    /**
     * 修改的方法
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean updateDeptInfo(DeptInfo deptInfo) throws Exception;

    /**
     * 删除的方法
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean deleteDeptInfo(int deptId) throws Exception;
}
