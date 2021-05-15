package com.mycode.demo.models;

import javax.persistence.*;
import java.io.Serializable;

// Serializable helps transform the Employee class into different type pf Stream,
// because this class is gonna be sent to the database like a json
@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String photoUrl;
    @Column(updatable = false, nullable = false)
    private String empCode;
    private String jobTitle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Employee() {
    }

    public Employee(Long id, String name, String phone, String email, String photoUrl, String empCode, String jobTitle) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.photoUrl = photoUrl;
        this.empCode = empCode;
        this.jobTitle = jobTitle;
    }
}
