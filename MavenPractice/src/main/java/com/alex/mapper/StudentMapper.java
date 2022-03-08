package com.alex.mapper;

import com.alex.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    @Select("SELECT * FROM school.student WHERE sid = #{sid}")
    Student getStudentById(int sid);

    @Select("SELECT * FROM school.student")
    List<Student> getAllStudent();

    @Select("SELECT * FROM school.student WHERE name = #{name}")
    List<Student> getStudentByName(String name);

    @Select("DELETE FROM school.student WHERE sid = #{sid}")
    Student deleteStudentId(int sid);

    @Insert("INSERT INTO school.student (name, gender) VALUES(#{name}, #{gender})")
    int insertStudent(@Param("name") String name, @Param("gender") String gender);
}
