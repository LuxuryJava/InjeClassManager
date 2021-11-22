package ac.injecs.java2.config;

import ac.injecs.java2.entity.Student;

public class SessionConfig {
    public boolean isLogin = false;
    public Student user = null;
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

    public void newSession(boolean isLogin, Student student) {
        this.isLogin = isLogin;
        this.user = student;

        System.out.println(toString());
    }

    public void outSession(){
        this.isLogin = false;
        this.user = null;
    }

    public Student getUser() {
        return this.user;
    }

    public boolean isLogin(){
        return this.isLogin;
    }

}
