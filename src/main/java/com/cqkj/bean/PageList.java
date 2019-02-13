package com.cqkj.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PageList<T>
{
    private List<T> data;
    // Ĭ��ҳ
    private int pageIndex = 1;
    // Ĭ��ҳ�Ĵ�С
    private int pageSize = 5;
    // ����
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
     * ���㵱ǰҳ����ʼֵ
     * 
     * @return
     */
    public int getFirstSeq()
    {
        return (pageIndex - 1) * pageSize;
    }

    /**
     * ����ҳ���ķ���
     * 
     * @return ����ܵ�ҳ��
     */
    public int getPageCount()
    {
        return count % pageSize == 0 ? count / pageSize : (count / pageSize) + 1;
    }
}
