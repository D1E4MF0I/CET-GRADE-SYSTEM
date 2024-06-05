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

    @Update({
            "<script>",
            "UPDATE students",
            "<set>",
            "<if test='name != null'>name = #{name},</if>",
            "<if test='studentId != null'>studentId = #{studentId},</if>",
            "<if test='major != null'>major = #{major},</if>",
            "<if test='grade != null'>grade = #{grade},</if>",
            "<if test='username != null'>username = #{username},</if>",
            "<if test='password != null'>password = #{password},</if>",
            "</set>",
            "WHERE id = #{id}",
            "</script>"
    })
    void updateStudentById(Student student);

    @Delete("DELETE FROM students WHERE id = #{id}")
    boolean deleteStudent(Integer id);
}