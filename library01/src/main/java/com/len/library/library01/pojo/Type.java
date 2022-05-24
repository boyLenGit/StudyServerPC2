package com.len.library.library01.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name="type")
@Table
public class Type {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Book> books = new ArrayList<>();
}
