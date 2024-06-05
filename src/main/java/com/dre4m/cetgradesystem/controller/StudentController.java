package com.dre4m.cetgradesystem.controller;

import com.alibaba.fastjson2.JSON;
import com.dre4m.cetgradesystem.domain.Admin;
import com.dre4m.cetgradesystem.domain.Student;
import com.dre4m.cetgradesystem.error.ErrorResponse;
import com.dre4m.cetgradesystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/studentRegister")
    public ResponseEntity<String> studentRegister(@RequestBody Student studentRegister) {
        Student student = studentService.register(studentRegister);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("账号名或学号名已存在，请重新确认。");
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body("学生账号：" + student.getUsername() + "注册成功！");
        }
    }

    @PostMapping("/studentLogin")
    public ResponseEntity<String> studentLogin(@RequestBody Student loginStudent) {
        Student student = studentService.login(loginStudent.getUsername(), loginStudent.getPassword());
        if (student == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("账号或密码错误，请重新确认。");
        } else {
            return ResponseEntity.ok(JSON.toJSONString(student));
        }
    }

    @PostMapping("/saveStudentInfo")
    public ResponseEntity<?> saveStudentInfo(@RequestBody Student student) {
        student = studentService.saveInfo(student);
        if (student == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(504, "保存失败", JSON.toJSONString(student)));
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping("/allStudentsInfo")
    public ResponseEntity<?> allStudentsInfo() {
        List<Student> students = studentService.getAllStudentsInfo();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/getStudentInfo/{studentId}")
    public ResponseEntity<?> getStudentInfo(@PathVariable Integer studentId){
        Student student = studentService.getStudentById(studentId);
        if(student != null){
            return ResponseEntity.ok(student);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404, "Student Not Found"));
        }
    }
    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer studentId){
        boolean isDeleted = studentService.deleteStudentById(studentId);
        if(isDeleted){
            return ResponseEntity.ok("Student deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

}
