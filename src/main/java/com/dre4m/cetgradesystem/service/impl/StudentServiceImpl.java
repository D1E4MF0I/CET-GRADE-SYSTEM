package com.dre4m.cetgradesystem.service.impl;

import com.dre4m.cetgradesystem.domain.Student;
import com.dre4m.cetgradesystem.mapper.StudentMapper;
import com.dre4m.cetgradesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student register(Student student) {
        if(student == null || isExistByUsername(student.getUsername()) || isExistByStudentId(student.getStudentId())){
            return null;
        }else{
            studentMapper.insertStudent(student);
            return student;
        }
    }

    @Override
    public Student login(String username, String password) {
        if(!isExistByUsername(username)){
            return null;
        }else{
            Student student = studentMapper.getStudentByUsername(username);
            if (student != null && student.getPassword().equals(password)) {
                return student;
            } else {
                // TODO:抛出登陆错误
                return null;
            }
        }
    }

    @Override
    public Student saveInfo(Student student) {
        studentMapper.updateStudentById(student);
        student = studentMapper.getStudentById(student.getId());
        return student;
    }

    public boolean isExistByUsername(String username) {
        Student studentByUsername = studentMapper.getStudentByUsername(username);
        if(studentByUsername == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean isExistByStudentId(String studentId) {
        Student studentByStudentId = studentMapper.getStudentByStudentId(studentId);
        if(studentByStudentId == null){
            return false;
        }else{
            return true;
        }
    }
}
