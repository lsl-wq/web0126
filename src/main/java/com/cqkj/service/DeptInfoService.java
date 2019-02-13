package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.DeptInfo;
import com.cqkj.bean.PageList;

public interface DeptInfoService
{
    /**
     * ��ѯ���еĲ�����Ϣ
     * 
     * @return
     * @throws Exception
     */
    public List<DeptInfo> selectAllDeptInfo() throws Exception;

    /**
     * ��ҳ��ѯ
     * 
     * @param pageList
     * @throws Exception
     */
    public void selectPage(PageList<DeptInfo> pageList) throws Exception;

    /**
     * ��ӵķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean insertDeptInfo(DeptInfo deptInfo) throws Exception;

    /**
     * ��ѯ�����û���Ϣ
     * 
     * @param deptId
     * @return
     * @throws Exception
     */
    public DeptInfo getDeptInfoById(int deptId) throws Exception;

    /**
     * �޸ĵķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean updateDeptInfo(DeptInfo deptInfo) throws Exception;

    /**
     * ɾ���ķ���
     * 
     * @param deptInfo
     * @return
     * @throws Exception
     */
    public boolean deleteDeptInfo(int deptId) throws Exception;
}
