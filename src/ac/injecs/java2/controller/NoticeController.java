package ac.injecs.java2.controller;

import ac.injecs.java2.service.NoticeService;
import ac.injecs.java2.config.SessionConfig;
import ac.injecs.java2.dto.NoticeDto;
import ac.injecs.java2.entity.Notice;

public class NoticeController {
    private NoticeService noticeService;
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }
}
