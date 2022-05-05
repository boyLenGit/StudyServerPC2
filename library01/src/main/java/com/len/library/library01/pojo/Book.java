package com.len.library.library01.pojo;

import javax.persistence.*;

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

    @ManyToOne // 多本书对应一个用户，即一个用户可以借多本书。这句代码用于进行对象之间的关系绑定，从而方便数据库数据的获取。
    private User user;

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

    public Integer getView_time() {
        return view_time;
    }

    public void setView_time(Integer view_time) {
        this.view_time = view_time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
                ", user=" + user +
                '}';
    }
}
