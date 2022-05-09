package len.cloud02.common.entity.paper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Entity(name = "paper")
@Table
public class Paper {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String author;
    private String publisher;
    @Lob
    private String introduce;
    private String first_picture;
    private Integer view_time;
    private String file_path;

//    @OneToMany()
//    private List<User> starers;

    public Paper() {
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getFirst_picture() {
        return first_picture;
    }

    public void setFirst_picture(String first_picture) {
        this.first_picture = first_picture;
    }

    public Integer getView_time() {
        return view_time;
    }

    public void setView_time(Integer view_time) {
        this.view_time = view_time;
    }

    public String getFile_path() {
        return file_path;
    }

    public void setFile_path(String file_path) {
        this.file_path = file_path;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", introduce='" + introduce + '\'' +
                ", first_picture='" + first_picture + '\'' +
                ", view_time=" + view_time +
                ", file_path='" + file_path + '\'' +
                '}';
    }
}
