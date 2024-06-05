package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Score;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.util.List;
@Mapper
public interface ScoreMapper {

    @Select("SELECT * FROM scores WHERE id = #{id}")
    Score getScoreById(Integer id);

    @Select("SELECT * FROM scores")
    List<Score> getAllScores();

    @Select("SELECT * FROM scores WHERE studentId = #{studentId}")
    List<Score> getScoresByStudentId(Integer studentId);

    @Insert("INSERT INTO scores(studentId, cet4Score, cet6Score, examDate) VALUES(#{studentId}, #{cet4Score}, #{cet6Score}, #{examDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    boolean insertScore(Score score);

    @Update("UPDATE scores SET cet4Score = #{cet4Score}, cet6Score = #{cet6Score} WHERE studentId = #{studentId} AND examDate = #{examDate}")
    boolean updateScore(Score score);

    @Select("SELECT * FROM scores WHERE studentId = #{studentId} AND examDate = #{examDate}")
    Score findScoreByStudentIdAndExamDate(Integer studentId, Date examDate);

    @Delete("DELETE FROM scores WHERE id = #{id}")
    boolean deleteScore(Integer id);

    @Select("SELECT MAX(cet4Score) FROM scores WHERE studentId = #{studentId}")
    Integer findMaxCet4ScoreByStudentId(Integer studentId);

    @Select("SELECT MAX(cet6Score) FROM scores WHERE studentId = #{studentId}")
    Integer findMaxCet6ScoreByStudentId(Integer studentId);
}
