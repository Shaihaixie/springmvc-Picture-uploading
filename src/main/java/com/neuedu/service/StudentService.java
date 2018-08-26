package com.neuedu.service;

import com.neuedu.dao.StudentMapper;
import com.neuedu.entity.Student;

import java.util.List;

public interface StudentService {
    /*
    *
    * 查询所有*/
    List<Student>  findall();

    int deleteByPrimaryKey(String stunum);
    int insert(Student record);
    Student selectByPrimaryKey(String stunum);
    int updateByPrimaryKey(Student record);
}
