package com.cqkj.service;

import java.util.List;

import com.cqkj.bean.Student;

public interface StudentService
{
    /**
     * ����һ�����ݵ����ݿ�
     * 
     * @param st
     * @return
     * @throws Exception
     */
    public boolean addStudent(Student st);

    /**
     * ��ѯ����ѧ���ķ���
     * 
     * @return
     */
    public List<Student> selectAll();
}
