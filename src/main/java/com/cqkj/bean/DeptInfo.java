package com.cqkj.bean;

import org.springframework.stereotype.Component;

/**
 * 部门信息实体，对应的表为DeptInfo
 * 
 * @author lsl
 *
 */
@Component
public class DeptInfo
{
    // 部门ID
    @PK
    private int deptId;
    // 部门编号
    private String deptCode;
    // 部门名称
    private String deptName;

    // 封装
    public int getDeptId()
    {
        return deptId;
    }

    public void setDeptId(int deptId)
    {
        this.deptId = deptId;
    }

    public String getDeptCode()
    {
        return deptCode;
    }

    public void setDeptCode(String deptCode)
    {
        this.deptCode = deptCode;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    /**
     * 无参的构造方法
     */
    public DeptInfo()
    {

    }

    /**
     * 带两个参数的构造方法
     * 
     * @param deptCode
     * @param deptName
     */
    public DeptInfo(String deptCode, String deptName)
    {
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

    /**
     * 带三个参数的构造方法
     * 
     * @param deptId
     * @param deptCode
     * @param deptName
     */
    public DeptInfo(int deptId, String deptCode, String deptName)
    {
        this.deptId = deptId;
        this.deptCode = deptCode;
        this.deptName = deptName;
    }

}
