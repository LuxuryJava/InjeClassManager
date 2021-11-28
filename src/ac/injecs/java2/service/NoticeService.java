package ac.injecs.java2.service;

import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.repository.NoticeRepository;

import java.util.Optional;

public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }



}
