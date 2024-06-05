package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.mapper.StudentMapper;
import com.dre4m.cetgradesystem.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    Student register(Student student);
    Student login(String username, String password);
    Student saveInfo(Student student);
}

