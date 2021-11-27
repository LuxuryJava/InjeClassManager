package ac.injecs.java2.entity;

public class Manager extends User{

    private String id;
    private String password;
    private String name;

    public Manager(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}
