package com.fundooapp.app.userDetails;

public class UserDetails {

    private String id;
    private String name;
    private int age;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSignStatus() {
        return signStatus;
    }

    public void setSignStatus(boolean signStatus) {
        this.signStatus = signStatus;
    }

    private boolean signStatus;


}
