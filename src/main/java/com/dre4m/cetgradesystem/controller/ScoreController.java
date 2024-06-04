package com.dre4m.cetgradesystem.controller;

import com.alibaba.fastjson2.JSON;
import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @GetMapping("/studentScore/{studentId}")
    public String getScoreByStudentId(@PathVariable String studentId){
        List<Score> scores = scoreService.getScoreByStudentId(studentId);
        return JSON.toJSONString(scores);
    }
}
