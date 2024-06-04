package com.dre4m.cetgradesystem.controller;

import com.alibaba.fastjson2.JSON;
import com.dre4m.cetgradesystem.domain.Admin;
import com.dre4m.cetgradesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PostMapping("/adminLogin")
    public ResponseEntity<String> login(@RequestBody Admin loginAdmin){
        Admin admin = adminService.login(loginAdmin.getUsername(), loginAdmin.getPassword());
        if(admin == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("账号或密码错误，请重新确认。");
        }else{
            return ResponseEntity.ok(JSON.toJSONString(admin));
        }
    }
}
