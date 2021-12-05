package ac.injecs.java2.config;

import ac.injecs.java2.entity.User;

public class SessionConfig {
    public boolean isLogin = false;
    public User user = null;

    @Override
    public String toString() {
        return "SessionConfig{" +
                "isLogin=" + isLogin +
                ", user=" + user +
                ", 관리자여부 =" + user.isManager() +
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

    public void removeUser() {
    	user=null;
    }

    public boolean isLogin(){
        return this.isLogin;
    }

    public SessionConfig(){ }
}
