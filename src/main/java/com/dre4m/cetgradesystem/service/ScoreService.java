package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.mapper.ScoreMapper;
import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.service.model.ScoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ScoreService {
    List<Score> getScoreByStudentId(String studentId);

    boolean saveScore(ScoreDto scoreDto);

    List<Score> getScoresByStudentId(Integer studentId);
    boolean deleteScoreById(Integer scoreId);
}
