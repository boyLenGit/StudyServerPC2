package len.cloud02.front.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;

    private String content;

    private Date createTime;

    private Integer isAuthor; // 0不是 1是作者

    private Long likes;

    // 关联
    private Long parentId;

    private Long toReplyId;

    private String toReplyUserName;

    private Long blogId;

    private Long userId;

    private String userAvatar;

    private String username;

    private String userEmail;

    // 非数据库数据
    private List<Comment> replyComments = new ArrayList<>();
}
