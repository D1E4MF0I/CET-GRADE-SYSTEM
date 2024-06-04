package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.mapper.ScoreMapper;
import com.dre4m.cetgradesystem.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ScoreService {
    List<Score> getScoreByStudentId(String studentId);
}
