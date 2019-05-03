package com.robson.meucontador;

import java.io.Serializable;

public class User implements Serializable {

    private Long id;
    private String name;
    private String username;
    private String phone;
    private String password;
    private String role;

    public User() {
        role = "user";
    }

    public User(String name, String username, String phone, String password) {
        this.id = null;
        this.name = name;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.role = "Usuário";
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return name;
    }
}
