package com.cqkj.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PageList<T>
{
    private List<T> data;
    // 默认页
    private int pageIndex = 1;
    // 默认页的大小
    private int pageSize = 5;
    // 总数
    private int count = 0;

    public List<T> getData()
    {
        return data;
    }

    public void setData(List<T> data)
    {
        this.data = data;
    }

    public int getPageIndex()
    {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public int getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    /**
     * 计算当前页的起始值
     * 
     * @return
     */
    public int getFirstSeq()
    {
        return (pageIndex - 1) * pageSize;
    }

    /**
     * 计算页数的方法
     * 
     * @return 输出总的页数
     */
    public int getPageCount()
    {
        return count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
    }
}
