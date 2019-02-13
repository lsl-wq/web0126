package com.cqkj.bean;

import org.springframework.stereotype.Component;

/**
 * ������Ϣʵ�壬��Ӧ�ı�ΪDeptInfo
 * 
 * @author lsl
 *
 */
@Component
public class DeptInfo
{
    // ����ID
    @PK
    private int deptId;
    // ���ű��
    private String deptCode;
    // ��������
    private String deptName;

    // ��װ
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
     * �޲εĹ��췽��
     */
    public DeptInfo()
    {

    }

    /**
     * �����������Ĺ��췽��
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
     * �����������Ĺ��췽��
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
