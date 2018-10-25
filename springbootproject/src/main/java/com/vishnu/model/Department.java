package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Department implements Serializable {
    private int id;
    private String name;
    private String time;

    public Department() {
    }

    public Department(String name,String time) {
        this.name = name;
        this.time=time;
    }

    public Department(int id, String name,String time) {
        this.id = id;
        this.name = name;
        this.time=time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
