package len.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Blog {
    private String Obj_id;
    private String Obj_title;
    private String Obj_author;
    private Date Obj_createTime;
    private int Obj_views;
}
