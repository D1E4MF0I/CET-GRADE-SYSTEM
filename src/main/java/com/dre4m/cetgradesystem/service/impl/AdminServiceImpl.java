package com.dre4m.cetgradesystem.service.impl;

import com.dre4m.cetgradesystem.domain.Admin;
import com.dre4m.cetgradesystem.mapper.AdminMapper;
import com.dre4m.cetgradesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String username, String password) {
        Admin admin = adminMapper.getAdminByUsername(username);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        } else {
            return null;
        }
    }

    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(Integer adminId) {
        adminMapper.deleteAdmin(adminId);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.getAllAdmins();
    }

    @Override
    public Admin getAdminById(Integer adminId) {
        return adminMapper.getAdminById(adminId);
    }

    // 其他方法的实现
}

