package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/23 0023.
 */
public class Position implements Serializable{
    private int id;
    private String name;
    private int dep_id;
    private String time;

    public Position() {
    }

    public Position(String name, int dep_id,String time) {
        this.name = name;
        this.dep_id = dep_id;
        this.time=time;
    }

    public Position(int id, String name, int dep_id,String time) {
        this.id = id;
        this.name = name;
        this.dep_id = dep_id;
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

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dep_id=" + dep_id +
                ", time='" + time + '\'' +
                '}';
    }
}
