package ac.injecs.java2.service;

import ac.injecs.java2.entity.User;
import ac.injecs.java2.repository.Repository;

import java.util.Optional;

public class ManagerService {

    private final Repository repository;

    public ManagerService(Repository repository) {
        this.repository = repository;
    }


    public Optional<User> loginManger(String id) {
        // TODO : 리포지터리에서 id로 매니저를 불러오면 isManager True인지 확인하기

        return repository.findManagerById(id);
    }

}
