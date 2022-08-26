package len.cloud02.blog_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar; // 用户头像

    private Integer type;  // 0 普通用户  1 管理员用户  2 su用户

    private Date createTime;

    private Date updateTime;

}
