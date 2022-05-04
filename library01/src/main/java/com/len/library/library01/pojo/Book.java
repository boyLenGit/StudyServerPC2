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
    private Integer view_time;

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", view_time=" + view_time +
                ", user=" + user +
                '}';
    }
}
