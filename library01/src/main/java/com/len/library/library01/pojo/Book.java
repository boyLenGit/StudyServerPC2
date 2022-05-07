package com.len.library.library01.pojo;

import javax.persistence.*;
import java.util.List;

@Entity(name = "book")
@Table
public class Book {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;  // 书名
    private String author;  // 作者
    private String publisher; // 出版社
    private String content;  // 详情
    private String picture;  // 封面图
    private Integer view_time; // 借阅次数
    private Integer amount; // 总数
    private Integer remain; // 剩余

    @ManyToMany(mappedBy = "books") // 多本书对应一个用户，即一个用户可以借多本书。这句代码用于进行对象之间的关系绑定，从而方便数据库数据的获取。
    private List<User> users;

    @ManyToMany(mappedBy = "books_history") // 多本书对应一个用户，即一个用户可以借多本书。这句代码用于进行对象之间的关系绑定，从而方便数据库数据的获取。
    private List<User> users_history;

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getView_time() {
        return view_time;
    }

    public void setView_time(Integer view_time) {
        this.view_time = view_time;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getRemain() {
        return remain;
    }

    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers_history() {
        return users_history;
    }

    public void setUsers_history(List<User> users_history) {
        this.users_history = users_history;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", content='" + content + '\'' +
                ", picture='" + picture + '\'' +
                ", view_time=" + view_time +
                ", amount=" + amount +
                ", remain=" + remain +
                ", users=" + users +
                ", users_history=" + users_history +
                '}';
    }
}
