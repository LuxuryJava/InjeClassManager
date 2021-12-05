package ac.injecs.java2.controller;

import ac.injecs.java2.service.NoticeService;
import ac.injecs.java2.dto.NoticeDto;
import ac.injecs.java2.entity.Notice;

public class NoticeController {
    private final NoticeService noticeService;
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    public void post(NoticeDto noticeDto) {
        // noticeDto -> notice 변환
        Notice notice = Notice.createNotice(noticeDto);
        Notice savedPost = noticeService.post(notice);
        System.out.println("저장된 Notice " + savedPost);
    }
}
