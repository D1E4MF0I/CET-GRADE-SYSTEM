package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Admin;
import com.dre4m.cetgradesystem.domain.Score;
import com.dre4m.cetgradesystem.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Date;

@SpringBootTest
public class MapperTest {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    ScoreMapper scoreMapper;
    @Test
    public void test(){
//        System.out.println(studentMapper.getAllStudents());
//        System.out.println(adminMapper.getAllAdmins());
//        System.out.println(scoreMapper.getAllScores());

//        Admin admin = new Admin();
//        admin.setUsername("testroot");
//        admin.setPassword("123456");
//        admin.setId(3);
//        adminMapper.insertAdmin(admin);
//        adminMapper.deleteAdmin(3);
//        System.out.println(adminMapper.getAllAdmins());

//        =========================================================================================================================

//        System.out.println(studentMapper.getAllStudents());
//        Student student;
//        student = new Student();
//        student.setName("dwadwad");
//        student.setStudentId("12983dw6712837123");
//        student.setMajor("ihdiwlhaidh");
//        student.setGrade("2021");
//        student.setUsername("dwadwdad");
//        student.setPassword("wdadadada");
//        studentMapper.insertStudent(student);
//        System.out.println(studentMapper.getAllStudents());
//        System.out.println(student);

//        System.out.println(studentMapper.getStudentById(5));
//        System.out.println(studentMapper.getAllStudents());
//        Student student = studentMapper.getStudentById(3);
//        student.setPassword("5555555555555555");
//        System.out.println(studentMapper.getStudentById(3));
//        studentMapper.updateStudent(student);
//        System.out.println(studentMapper.getStudentById(3));
//        studentMapper.deleteStudent(3);
//        System.out.println(studentMapper.getStudentById(3));
//        studentMapper.deleteStudent(3);

//        ========================================================================================

//        System.out.println(scoreMapper.getAllScores());
//        System.out.println(scoreMapper.getScoreById(1));
//        System.out.println(scoreMapper.getScoresByStudentId(scoreMapper.getScoreById(1).getStudent().getId()));
//        Score score;
//        score = new Score();
//        score.setExamDate(Date.from(Instant.now()));
//        score.setCet4Score(400);
//        score.setStudent(student);
//        System.out.println(scoreMapper.getAllScores());
//        scoreMapper.insertScore(score);
//        System.out.println(scoreMapper.getAllScores());

//        Score score = scoreMapper.getScoreById(3);
//        score.setCet6Score(450);
//        System.out.println(scoreMapper.getScoreById(3));
//        scoreMapper.updateScore(score);
//        System.out.println(scoreMapper.getScoreById(3));

//        scoreMapper.deleteScore(3);
//        System.out.println(scoreMapper.getScoreById(3));
//        System.out.println(scoreMapper.getScoreById(3));
//        System.out.println(adminMapper.getAllAdmins());
        System.out.println(adminMapper.getAdminByUsername("admin1"));
    }
}
