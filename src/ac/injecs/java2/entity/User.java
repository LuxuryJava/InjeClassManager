package ac.injecs.java2.entity;

public class User {
    private Long key;

    private String id;

    private String name;

    private String department;

    private String studentId;

    private String email;

    private String phoneNuber;

    private String password;

    @Override
    public String toString() {
        return "User{" +
                "key=" + key +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", studentId='" + studentId + '\'' +
                ", email='" + email + '\'' +
                ", phoneNuber='" + phoneNuber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNuber() {
        return phoneNuber;
    }

    public void setPhoneNuber(String phoneNuber) {
        this.phoneNuber = phoneNuber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
