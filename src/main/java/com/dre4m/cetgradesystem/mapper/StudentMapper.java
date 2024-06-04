package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM students WHERE id = #{id}")
    Student getStudentById(Integer id);

    @Select("SELECT * FROM students WHERE username = #{username}")
    Student getStudentByUsername(String username);

    @Select("SELECT * FROM students WHERE studentId = #{studentId}")
    Student getStudentByStudentId(String studentId);

    @Select("SELECT * FROM students")
    List<Student> getAllStudents();

    @Insert("INSERT INTO students(name, studentId, major, grade, username, password) VALUES(#{name}, #{studentId}, #{major}, #{grade}, #{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertStudent(Student student);

    @Update("UPDATE students SET name = #{name}, studentId = #{studentId}, major = #{major}, grade = #{grade}, username = #{username}, password = #{password} WHERE id = #{id}")
    void updateStudent(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    void deleteStudent(Integer id);
}