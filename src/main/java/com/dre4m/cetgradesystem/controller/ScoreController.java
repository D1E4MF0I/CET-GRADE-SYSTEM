package com.dre4m.cetgradesystem.controller;

import com.alibaba.fastjson2.JSON;
import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.error.ErrorResponse;
import com.dre4m.cetgradesystem.service.ScoreService;
import com.dre4m.cetgradesystem.service.model.ScoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    ScoreService scoreService;

    @PostMapping("/submitScore")
    public ResponseEntity<?> submitScore(@RequestBody ScoreDto scoreDto) {
        boolean isSaved = scoreService.saveScore(scoreDto);
        if (isSaved) {
            return ResponseEntity.ok("Score submitted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error submitting score");
        }
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Score>> getScoresByStudentId(@PathVariable Integer studentId) {
        List<Score> scores = scoreService.getScoresByStudentId(studentId);
        if (scores != null && !scores.isEmpty()) {
            return ResponseEntity.ok(scores);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @DeleteMapping("/{scoreId}")
    public ResponseEntity<?> deleteScore(@PathVariable Integer scoreId) {
        boolean isDeleted = scoreService.deleteScoreById(scoreId);
        if (isDeleted) {
            return ResponseEntity.ok("Score deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting score");
        }
    }


}
