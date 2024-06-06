package com.dre4m.cetgradesystem.service.impl;

import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.domain.Student;
import com.dre4m.cetgradesystem.mapper.ScoreMapper;
import com.dre4m.cetgradesystem.mapper.StudentMapper;
import com.dre4m.cetgradesystem.service.ScoreService;
import com.dre4m.cetgradesystem.service.model.ScoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreMapper scoreMapper;
    @Autowired
    StudentMapper studentMapper;
    @Override
    public List<Score> getScoreByStudentId(String studentId) {
        Student student = studentMapper.getStudentByStudentId(studentId);
        List<Score> scores = scoreMapper.getScoresByStudentId(student.getId());
        return scores;
    }

    @Override
    public boolean saveScore(ScoreDto scoreDto) {
        Student student = studentMapper.getStudentById(scoreDto.getStudentId());
        if (student != null) {
            Date examDate = Date.valueOf(scoreDto.getExamDate());
            System.out.println(examDate);
            Score existingScore = scoreMapper.findScoreByStudentIdAndExamDate(scoreDto.getStudentId(), examDate);
            if (existingScore != null) {
                // 更新现有成绩
                existingScore.setCet4Score(scoreDto.getCet4Score());
                existingScore.setCet6Score(scoreDto.getCet6Score());
                scoreMapper.updateScore(existingScore);
            } else {
                // 插入新成绩
                Score newScore = new Score();
                newScore.setStudentId(scoreDto.getStudentId());
                newScore.setCet4Score(scoreDto.getCet4Score());
                newScore.setCet6Score(scoreDto.getCet6Score());
                newScore.setExamDate(examDate);
                scoreMapper.insertScore(newScore);
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Score> getScoresByStudentId(Integer studentId) {
        List<Score> scores = scoreMapper.getScoresByStudentId(studentId);
        return scores;
    }

    @Override
    public boolean deleteScoreById(Integer scoreId) {
        return scoreMapper.deleteScore(scoreId);
    }
}
