package com.dre4m.cetgradesystem.controller;

import com.dre4m.cetgradesystem.domain.Notice;
import com.dre4m.cetgradesystem.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notices")
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> getNoticeById(@PathVariable Long id) {
        Notice notice = noticeService.getNoticeById(id);
        return notice != null ? ResponseEntity.ok(notice) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Notice addNotice(@RequestBody Notice notice) {
        noticeService.saveNotice(notice);
        return notice;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long id, @RequestBody Notice notice) {
        Notice existingNotice = noticeService.getNoticeById(id);
        if (existingNotice != null) {
            existingNotice.setTitle(notice.getTitle());
            existingNotice.setContent(notice.getContent());
            noticeService.saveNotice(existingNotice);
            return ResponseEntity.ok(existingNotice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotice(@PathVariable Long id) {
        Notice existingNotice = noticeService.getNoticeById(id);
        if (existingNotice != null) {
            noticeService.deleteNotice(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

