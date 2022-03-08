package com.alex.mapper;

import com.alex.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM school.student WHERE sid = #{sid}")
    Student getStudentById(int sid);

    @Select("SELECT * FROM school.student")
    List<Student> getAllStudent();

    @Select("SELECT * FROM school.student WHERE name = #{name}")
    List<Student> getStudentByName(String name);
}
