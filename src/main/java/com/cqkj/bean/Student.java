package com.cqkj.bean;

import org.springframework.stereotype.Component;

@Component
public class Student
{

    // �ֶ�������������
    // ѧ��ID
    @PK
    private int stuId;

    // ѧ�����
    private String stuNo;

    // ����
    private String stuName;

    // ����
    private int stuAge = 0;

    // �Ա�
    private String stuSex;

    /**
     * �Ա�
     * 
     * @return
     */
    public int getStuId()
    {
        return stuId;
    }

    /**
     * �Ա�
     * 
     * @param stuId
     */
    public void setStuId(int stuId)
    {
        this.stuId = stuId;
    }

    public String getStuNo()
    {
        return stuNo;
    }

    public void setStuNo(String stuNo)
    {
        this.stuNo = stuNo;
    }

    public String getStuName()
    {
        return stuName;
    }

    public void setStuName(String stuName)
    {
        this.stuName = stuName;
    }

    public int getStuAge()
    {
        return stuAge;
    }

    public void setStuAge(int stuAge)
    {
        this.stuAge = stuAge;
    }

    public String getStuSex()
    {
        return stuSex;
    }

    public void setStuSex(String stuSex)
    {
        this.stuSex = stuSex;
    }

    public Student()
    {

    }

    /**
     * ���췽��
     * 
     * @param stuNo
     * @param stuName
     * @param stuSex
     * @param stuAge
     */
    public Student(String stuNo, String stuName, String stuSex, int stuAge)
    {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
    }

    /**
     * ���췽��
     * 
     * @param stuId
     * @param stuNo
     * @param stuName
     * @param stuSex
     * @param stuAge
     */
    public Student(int stuId, String stuNo, String stuName, String stuSex, int stuAge)
    {
        this(stuNo, stuName, stuSex, stuAge);
        this.stuId = stuId;
    }

}
