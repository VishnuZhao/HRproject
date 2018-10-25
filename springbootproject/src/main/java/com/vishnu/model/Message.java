package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/24 0024.
 */
public class Message implements Serializable {
    private int id;
    private String message;
    private int uid;
    private int emp_id;
    private int status;
    private int style;
    private int it_id;

    public Message() {
    }

    public Message(String message, int uid, int status, int style,int it_id) {
        this.message = message;
        this.uid = uid;
        this.status = status;
        this.style = style;
        this.it_id=it_id;
    }

    public Message(String message, int emp_id, int status, int style) {
        this.message = message;
        this.emp_id = emp_id;
        this.status = status;
        this.style = style;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public int getIt_id() {
        return it_id;
    }

    public void setIt_id(int it_id) {
        this.it_id = it_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", uid=" + uid +
                ", emp_id=" + emp_id +
                ", status=" + status +
                ", style=" + style +
                ", it_id=" + it_id +
                '}';
    }
}
