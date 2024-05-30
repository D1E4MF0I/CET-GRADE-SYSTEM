package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ScoreMapper {

    @Select("SELECT * FROM scores WHERE id = #{id}")
    @Result(property = "student", javaType = Student.class, column = "studentId",
            one = @One(select = "com.dre4m.cetgradesystem.mapper.StudentMapper.getStudentById"))
    Score getScoreById(Integer id);

    @Select("SELECT * FROM scores")
    @Result(property = "student", javaType = Student.class, column = "studentId",
            one = @One(select = "com.dre4m.cetgradesystem.mapper.StudentMapper.getStudentById"))
    List<Score> getAllScores();

    @Select("SELECT * FROM scores WHERE studentId = #{studentId}")
    @Result(property = "student", javaType = Student.class, column = "studentId",
            one = @One(select = "com.dre4m.cetgradesystem.mapper.StudentMapper.getStudentById"))
    Score getScoresByStudentId(Integer studentId);

    @Insert("INSERT INTO scores(studentId, cet4Score, cet6Score, examDate) VALUES(#{student.id}, #{cet4Score}, #{cet6Score}, #{examDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertScore(Score score);

    @Update("UPDATE scores SET studentId = #{student.id}, cet4Score = #{cet4Score}, cet6Score = #{cet6Score}, examDate = #{examDate} WHERE id = #{id}")
    void updateScore(Score score);

    @Delete("DELETE FROM scores WHERE id = #{id}")
    void deleteScore(Integer id);
}
