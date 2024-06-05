package com.dre4m.cetgradesystem.service.model;

import lombok.Data;

@Data
public class ScoreDto {
    private Integer studentId;
    private Integer cet4Score;
    private Integer cet6Score;
    private String examDate;

    // Getters and Setters
}

