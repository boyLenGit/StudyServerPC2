package len.cloud02.blog.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity(name = "t_blog")
@Table
public class Blog {
    @Id
    @GeneratedValue
    private Long id;  //
    private String title;  // 标题

    // ↓ 下面的Basic和Lob只有第一次生成时才有用
    //@Basic(fetch = FetchType.LAZY)  // 设定该变量只有用到的时候再加载，避免资源浪费，因为content是文本内容，占用资源大
    @Lob  // 说明这个是大字段类型，因为如果是String，对应到数据库会生成char(255)，所以文章内容长了会报错
    private String content;  // 内容
    @Lob
    private String info; // 简介
    private String firstPicture;  // 首图
    private String flag;  // 标记
    private Integer views;  // 浏览次数
    private boolean appreciation;  // 赞赏开启
    private boolean shareStatement;  // 版权开启
    private boolean commentabled;  // 评论开启
    private boolean published;  // 发布
    private boolean recommend;  //
    @Temporal(TemporalType.TIMESTAMP)  // @Temporal(TemporalType.TIMESTAMP)用于将数据库和java的Data格式相对应。TemporalType.TIMESTAMP表示全时间，即日期+时间
    private Date createTime;  // 创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;  // 更新时间

    @ManyToOne  // 这种两者“多对一对多”互关联的，一定要在一方指明跟随的关系
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})  // Blog与tags建立级联操作：给当前设置的实体操作另一个实体的权限。具体看OneNote
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient  // 表明该变量不是数据库的，不要加入到数据库中，仅作为一个单变量在该类中
    private String tagIds;

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isAppreciation() {
        return appreciation;
    }

    public void setAppreciation(boolean appreciation) {
        this.appreciation = appreciation;
    }

    public boolean isShareStatement() {
        return shareStatement;
    }

    public void setShareStatement(boolean shareStatement) {
        this.shareStatement = shareStatement;
    }

    public boolean isCommentabled() {
        return commentabled;
    }

    public void setCommentabled(boolean commentabled) {
        this.commentabled = commentabled;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void initTagIds(){
        this.tagIds = tagsToIds(this.getTags());
        System.out.println("LenPrint. " + this.getTags() + " || " + this.tagIds);
    }

    //1,2,3
    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content=略'" + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views=" + views +
                ", appreciation=" + appreciation +
                ", shareStatement=" + shareStatement +
                ", commentabled=" + commentabled +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
