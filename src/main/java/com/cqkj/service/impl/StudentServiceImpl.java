package com.cqkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.Student;
import com.cqkj.dao.StudentDao;
import com.cqkj.service.StudentService;

/**
 * ҵ���߼���
 * 
 * @author xxx
 *
 */
@Service
public class StudentServiceImpl implements StudentService
{
    @Resource
    StudentDao studentDao;

    /**
     * ����һ�����ݵ����ݿ�
     * 
     * @param st
     * @return
     * @throws Exception
     */
    public boolean addStudent(Student st)
    {
        try
        {
            studentDao.insert(st);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * ��ѯ����ѧ���ķ���
     * 
     * @return
     */
    public List<Student> selectAll()
    {
        try
        {
            return studentDao.selectAll(Student.class);
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

    }

}