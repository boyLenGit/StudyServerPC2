package com.len.library.library01.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity(name = "user")
@Table
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String password;
    private String user_icon;
    private boolean isAdmin;
    private boolean isRoot;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Book> books = new ArrayList<>();
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Book> books_history = new ArrayList<>();

    public User() {
        isAdmin = false;
        isRoot = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_icon() {
        return user_icon;
    }

    public void setUser_icon(String user_icon) {
        this.user_icon = user_icon;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks_history() {
        return books_history;
    }

    public void setBooks_history(List<Book> books_history) {
        this.books_history = books_history;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", user_icon='" + user_icon + '\'' +
                ", isAdmin=" + isAdmin +
                ", isRoot=" + isRoot +
                ", books=" + books +
                ", books_history=" + books_history +
                '}';
    }
}
