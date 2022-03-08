package com.alex.utils;

import com.alex.entity.Student;
import com.alex.mapper.StudentMapper;

import java.util.List;

public class StudentUtil {
    private static final StudentMapper studentMapper = MybatisUtil.getSqlSession(true).getMapper(StudentMapper.class);

    public static List<Student> getAllStudent() {
        return StudentUtil.studentMapper.getAllStudent();
    }

    public static List<Student> getStudentByName(String name) {
        return StudentUtil.studentMapper.getStudentByName(name);
    }

    public static Student getStudentById(int id) {
        return StudentUtil.studentMapper.getStudentById(id);
    }
}
