package len.cloud02.blog_service.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    private Long id;

    private String content;

    private String avatar;

    private Date createTime;

    private Boolean isAuthor;

    // 关联
    private Long parentId;

    private Long blogId;

    private Long userId;

    private String nickname;

    private String email;
}
