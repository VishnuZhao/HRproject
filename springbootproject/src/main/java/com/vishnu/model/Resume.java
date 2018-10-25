package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/20 0020.
 */
public class Resume implements Serializable {//简历表
    private int id;
    private String uname;
    private String sex;
    private String phone;
    private String education;
    private String school;
    private String major;
    private int age;
    private int status;//0：未公开，1：公开
    private int workyear;
    private String interoduction;
    private int uid;
    private String rename;

    public Resume() {
    }

    public Resume(String name, String sex, String phone, String education, String school, String major, int age, int status, int workyear, String interoduction,int uid,String rename) {
        this.uname = name;
        this.sex = sex;
        this.phone = phone;
        this.education = education;
        this.school = school;
        this.major = major;
        this.age = age;
        this.status = status;
        this.workyear = workyear;
        this.interoduction = interoduction;
        this.uid=uid;
        this.rename=rename;
    }

    public Resume(int id, String name, String sex, String phone, String education, String school, String major, int age, int status, int workyear, String interoduction,int uid,String rename) {
        this.id = id;
        this.uname = name;
        this.sex = sex;
        this.phone = phone;
        this.education = education;
        this.school = school;
        this.major = major;
        this.age = age;
        this.status = status;
        this.workyear = workyear;
        this.interoduction = interoduction;
        this.uid=uid;
        this.rename=rename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getRename() {
        return rename;
    }

    public void setRename(String rename) {
        this.rename = rename;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWorkyear() {
        return workyear;
    }

    public void setWorkyear(int workyear) {
        this.workyear = workyear;
    }

    public String getInteroduction() {
        return interoduction;
    }

    public void setInteroduction(String interoduction) {
        this.interoduction = interoduction;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", age=" + age +
                ", status=" + status +
                ", workyear=" + workyear +
                ", interoduction='" + interoduction + '\'' +
                ", uid=" + uid +
                ", rename='" + rename + '\'' +
                '}';
    }
}
