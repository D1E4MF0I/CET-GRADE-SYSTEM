package com.dre4m.cetgradesystem.service.impl;

import com.dre4m.cetgradesystem.domain.Notice;
import com.dre4m.cetgradesystem.mapper.NoticeMapper;
import com.dre4m.cetgradesystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getAllNotices() {
        return noticeMapper.getAllNotices();
    }
    @Override
    public Notice getNoticeById(Long id) {
        return noticeMapper.getNoticeById(id);
    }
    @Override
    public void saveNotice(Notice notice) {
        if (notice.getId() == null) {
            noticeMapper.insertNotice(notice);
        } else {
            noticeMapper.updateNotice(notice);
        }
    }
    @Override
    public void deleteNotice(Long id) {
        noticeMapper.deleteNotice(id);
    }
}