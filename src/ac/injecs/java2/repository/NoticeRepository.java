package ac.injecs.java2.repository;

import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.entity.Student;

import java.util.List;
import java.util.Optional;

public interface NoticeRepository {
    Notice insert(Notice notice);
}
