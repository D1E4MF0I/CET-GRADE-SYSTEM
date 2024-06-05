package com.dre4m.cetgradesystem.mapper;

import com.dre4m.cetgradesystem.domain.Notice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeMapper {

    @Select("SELECT * FROM notices")
    List<Notice> getAllNotices();

    @Select("SELECT * FROM notices WHERE id = #{id}")
    Notice getNoticeById(Long id);

    @Insert("INSERT INTO notices(title, content) VALUES(#{title}, #{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertNotice(Notice notice);

    @Update("UPDATE notices SET title = #{title}, content = #{content} WHERE id = #{id}")
    void updateNotice(Notice notice);

    @Delete("DELETE FROM notices WHERE id = #{id}")
    void deleteNotice(Long id);
}

