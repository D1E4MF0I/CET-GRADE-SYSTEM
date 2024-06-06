package com.dre4m.cetgradesystem.domain;

import lombok.Data;

import java.sql.Date;

@Data
public class Score {
    private Integer id;
    private Integer studentId;
    private Integer cet4Score = null;
    private Integer cet6Score = null;
    private Date examDate;
}
