package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.mapper.StudentMapper;
import com.dre4m.cetgradesystem.domain.Student;
import com.dre4m.cetgradesystem.service.model.StudentWithScores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student register(Student student);
    Student login(String username, String password);
    Student saveInfo(Student student);
    List<StudentWithScores> getAllStudentsInfo();

    StudentWithScores getStudentById(Integer id);

    boolean deleteStudentById(Integer studentId);
}

