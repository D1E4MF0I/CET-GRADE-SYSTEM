package com.dre4m.cetgradesystem.service.impl;

import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.domain.Student;
import com.dre4m.cetgradesystem.mapper.ScoreMapper;
import com.dre4m.cetgradesystem.mapper.StudentMapper;
import com.dre4m.cetgradesystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
