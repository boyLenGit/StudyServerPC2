package len.pojo;

import lombok.Data;

@Data
public class Obj_student {
    private int id;
    private String name;
    private Obj_teacher teacher;
}
