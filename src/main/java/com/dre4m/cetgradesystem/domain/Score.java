package com.dre4m.cetgradesystem.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Score {
    private Integer id;
    private Student student;
    private Integer cet4Score = null;
    private Integer cet6Score = null;
    private Date examDate;
}
