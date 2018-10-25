package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public class Interview implements Serializable {
    private int id;
    private String address;
    private String date;
    private int re_id;
    private int rc_id;
    private int mess_id;

    public Interview() {
    }

    public Interview(String address, String date, int re_id, int rc_id, int mess_id) {
        this.address = address;
        this.date = date;
        this.re_id = re_id;
        this.rc_id = rc_id;
        this.mess_id = mess_id;
    }

    public Interview(int id, String address, String date, int re_id, int rc_id, int mess_id) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.re_id = re_id;
        this.rc_id = rc_id;
        this.mess_id = mess_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRe_id() {
        return re_id;
    }

    public void setRe_id(int re_id) {
        this.re_id = re_id;
    }

    public int getRc_id() {
        return rc_id;
    }

    public void setRc_id(int rc_id) {
        this.rc_id = rc_id;
    }

    public int getMess_id() {
        return mess_id;
    }

    public void setMess_id(int mess_id) {
        this.mess_id = mess_id;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                ", re_id=" + re_id +
                ", rc_id=" + rc_id +
                ", mess_id=" + mess_id +
                '}';
    }
}
