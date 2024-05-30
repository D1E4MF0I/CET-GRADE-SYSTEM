package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    @Select("SELECT * FROM admins WHERE id = #{id}")
    Admin getAdminById(Integer id);

    @Select("SELECT * FROM admins")
    List<Admin> getAllAdmins();

    @Insert("INSERT INTO admins(username, password) VALUES(#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertAdmin(Admin admin);

    @Update("UPDATE admins SET username = #{username}, password = #{password} WHERE id = #{id}")
    void updateAdmin(Admin admin);

    @Delete("DELETE FROM admins WHERE id = #{id}")
    void deleteAdmin(Integer id);
}
