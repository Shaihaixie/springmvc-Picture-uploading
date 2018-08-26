package com.neuedu.service.impl;

import com.neuedu.dao.StudentMapper;
import com.neuedu.entity.Student;
import com.neuedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
   @Autowired
    StudentMapper  studentMapper;
    @Override
    public List<Student> findall() {
        return studentMapper.selectAll();
    }

    @Override
    public int deleteByPrimaryKey(String stunum) {
        return studentMapper.deleteByPrimaryKey(stunum);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public Student selectByPrimaryKey(String stunum) {
        return studentMapper.selectByPrimaryKey(stunum);
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
