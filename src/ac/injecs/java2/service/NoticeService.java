package ac.injecs.java2.service;

import ac.injecs.java2.entity.Notice;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class NoticeService {

    private final Repository repository;

    public NoticeService(Repository repository) {
        this.repository = repository;
    }

    public  Notice post(Notice notice){
        checkText(notice);
        System.out.println();
        checkSamePost(notice.getTitle());

        return repository.insertNotice(notice);
    }

    private void checkText(Notice notice){
        if (notice.getTitle().isEmpty() || notice.getContent().isEmpty()){
            throw new IllegalStateException();
        }
    }

    private void checkSamePost(String title){
        Optional<Notice> find = repository.findNoticeByTitle(title);
        if(find.isPresent() && find.get().getTitle().equals(title)){
            throw new IllegalArgumentException();
        }
    }

}
