package com.cqkj.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TCourse
{
    @PK
    private int cId;
    private String cNo;
    private String cName;
    private Date createDate;

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public int getcId()
    {
        return cId;
    }

    public void setcId(int cId)
    {
        this.cId = cId;
    }

    public String getcNo()
    {
        return cNo;
    }

    public void setcNo(String cNo)
    {
        this.cNo = cNo;
    }

    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    /**
     * 无参的构造方法
     */
    public TCourse()
    {

    }

    /**
     * 带三个参数的构造方法
     * 
     * @param cNo
     * @param cName
     * @param createDate
     */
    public TCourse(String cNo, String cName, Date createDate)
    {
        this.cNo = cNo;
        this.cName = cName;
        this.createDate = createDate;
    }

}
