package ac.injecs.java2.controller;


import ac.injecs.java2.config.SessionConfig;
import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.service.ManagerService;

import java.util.Optional;

public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    public boolean login(SessionConfig session, String id, String password) {
        Optional<Manager> manager = managerService.loginManger(id);
        if (manager.isEmpty()) {
            throw new IllegalStateException("가입되지 않은 회원입니다.");
        }

        if (manager.get().getPassword().equals(password)) {
            session.newSession(true, manager.get());
            return true;
        }
        return false;
    }
}