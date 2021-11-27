package ac.injecs.java2.config;

import ac.injecs.java2.entity.Manager;
import ac.injecs.java2.entity.Student;
import ac.injecs.java2.entity.User;

public class SessionConfig {
    public boolean isLogin = false;
    public User user = null;
    // Manager 추가 예정

    public SessionConfig(){

    }

    @Override
    public String toString() {
        return "SessionConfig{" +
                "isLogin=" + isLogin +
                ", user=" + user +
                '}';
    }

    public void newSession(boolean isLogin, User user) {
        this.isLogin = isLogin;
        this.user = user;

        System.out.println(toString());
    }

    public void outSession(){
        this.isLogin = false;
        this.user = null;
    }

    public User getUser() {
        return this.user;
    }

    public boolean isLogin(){
        return this.isLogin;
    }

}
