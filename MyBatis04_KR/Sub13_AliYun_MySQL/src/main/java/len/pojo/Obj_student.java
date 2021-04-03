package len.pojo;

import lombok.Data;

@Data
public class Obj_student {
    private int obj_s_id;
    private String obj_s_name;
    private Obj_teacher obj_s_teacher;
}
