package com.vishnu.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/10/25 0025.
 */
public class Employee implements Serializable {
    private int id;
    private String name;
    private String pass;
    private String sex;
    private String phone;
    private String education;
    private String school;
    private String major;
    private int dep_id;
    private int po_id;
    private double salary;
    private int status;//0:在职，1：离职

    public Employee() {
    }

    public Employee(String name, String pass, String sex, String phone, String education, String school, String major, int dep_id, int po_id, double salary, int status) {
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.phone = phone;
        this.education = education;
        this.school = school;
        this.major = major;
        this.dep_id = dep_id;
        this.po_id = po_id;
        this.salary = salary;
        this.status = status;
    }

    public Employee(int id, String name, String pass, String sex, String phone, String education, String school, String major, int dep_id, int po_id, double salary, int status) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.phone = phone;
        this.education = education;
        this.school = school;
        this.major = major;
        this.dep_id = dep_id;
        this.po_id = po_id;
        this.salary = salary;
        this.status = status;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public int getPo_id() {
        return po_id;
    }

    public void setPo_id(int po_id) {
        this.po_id = po_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", major='" + major + '\'' +
                ", dep_id=" + dep_id +
                ", po_id=" + po_id +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }
}
