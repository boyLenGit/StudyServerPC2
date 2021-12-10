<<<<<<< HEAD
package len.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Obj_teacher {
    private int obj_t_id;
    private String obj_t_name;

    // 一个老师拥有多个学生
    private List<Obj_student> obj_t_student;
}
=======
package len.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Obj_teacher {
    private int obj_t_id;
    private String obj_t_name;

    // 一个老师拥有多个学生
    private List<Obj_student> obj_t_student;
}
>>>>>>> 1da3f48 (first commit)
