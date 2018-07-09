package pl.coderslab.model;

public class User {


    private int id;
    private int userGroupId;
    private String name;
    private String surname;
    private String gitLogin;
    private String email;


    public User(int id, int userGroupId, String name, String surname, String gitLogin, String email) {
        setId(id);
        setUserGroupId(userGroupId);
        setName(name);
        setSurname(surname);
        setGitLogin(gitLogin);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGitLogin() {
        return gitLogin;
    }

    public void setGitLogin(String gitLogin) {
        this.gitLogin = gitLogin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
