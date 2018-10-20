package com.vishnu.model;

/**
 * Created by Administrator on 2018/10/19 0019.
 */
public class User {
    private int u_id;
    private String u_name;
    private String u_pass;

    public User() {
    }

    public User(String u_name, String u_pass) {
        this.u_name = u_name;
        this.u_pass = u_pass;
    }

    public User(int u_id, String u_name, String u_pass) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_pass = u_pass;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pass='" + u_pass + '\'' +
                '}';
    }
}
