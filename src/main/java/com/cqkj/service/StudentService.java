package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.Student;

public interface StudentService
{
    /**
     * 插入一条数据到数据库
     * 
     * @param st
     * @return
     * @throws Exception
     */
    public boolean addStudent(Student st);

    /**
     * 查询所有学生的方法
     * 
     * @return
     */
    public List<Student> selectAll();
}
