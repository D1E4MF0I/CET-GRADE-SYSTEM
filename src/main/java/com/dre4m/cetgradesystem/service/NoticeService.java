package com.dre4m.cetgradesystem.service;

import com.dre4m.cetgradesystem.domain.Notice;

import java.util.List;

public interface NoticeService {
    public List<Notice> getAllNotices();

    public Notice getNoticeById(Long id);
    public void saveNotice(Notice notice);
    public void deleteNotice(Long id);
}
