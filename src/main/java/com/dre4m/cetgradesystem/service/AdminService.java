package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.mapper.AdminMapper;
import com.dre4m.cetgradesystem.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {
    Admin login(String username, String password); // 登录方法

    void addAdmin(Admin admin); // 添加管理员

    void updateAdmin(Admin admin); // 更新管理员信息

    void deleteAdmin(Integer adminId); // 删除管理员

    List<Admin> getAllAdmins(); // 获取所有管理员

    Admin getAdminById(Integer adminId); // 根据ID获取管理员

    // 其他可能的方法
}

