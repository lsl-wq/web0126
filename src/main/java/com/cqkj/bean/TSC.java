package com.cqkj.bean;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TSC
{
    @PK
    private int scId;
    private int stuId;
    private int cId;
    private double score;
    private Date createDate;

    public int getScId()
    {
        return scId;
    }

    public void setScId(int scId)
    {
        this.scId = scId;
    }

    public int getStuId()
    {
        return stuId;
    }

    public void setStuId(int stuId)
    {
        this.stuId = stuId;
    }

    public int getCId()
    {
        return cId;
    }

    public void setCId(int cId)
    {
        this.cId = cId;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }

    public Date getCreateDate()
    {
        return createDate;
    }

    public void setCreateDate(Date createDate)
    {
        this.createDate = createDate;
    }
}
