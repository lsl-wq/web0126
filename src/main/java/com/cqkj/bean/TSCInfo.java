package com.cqkj.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TSCInfo
{
    private int scId;
    private String cNo;
    private String cName;
    private double score;
    private Date createDate;

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }

    public int getScId()
    {
        return scId;
    }

    public void setScId(int scId)
    {
        this.scId = scId;
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

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

}
