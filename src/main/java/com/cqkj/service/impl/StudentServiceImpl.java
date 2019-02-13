package com.cqkj.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cqkj.bean.Student;
import com.cqkj.dao.StudentDao;
import com.cqkj.service.StudentService;

/**
 * 业务逻辑层
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
     * 插入一条数据到数据库
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
     * 查询所有学生的方法
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