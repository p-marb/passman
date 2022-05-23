package me.pat;

public class Password {

    private int id;
    private String username;
    private String password;
    private String name;

    public Password(String user, String pwd, String name){
        this.username = user;
        this.password = pwd;
        this.name = name;
    }

    public Password(int id, String user, String pwd, String name){
        this.id = id;
        this.username = user;
        this.password = pwd;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
