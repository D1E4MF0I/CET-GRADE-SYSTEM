package com.dre4m.cetgradesystem.service.model;

import com.dre4m.cetgradesystem.domain.Student;
import lombok.Data;

@Data
public class StudentWithScores {

    private Student student;
    private Integer maxCet4Score;
    private Integer maxCet6Score;

    public StudentWithScores(Student student, Integer maxCet4Score, Integer maxCet6Score) {
        this.student = student;
        this.maxCet4Score = maxCet4Score;
        this.maxCet6Score = maxCet6Score;
    }
}
