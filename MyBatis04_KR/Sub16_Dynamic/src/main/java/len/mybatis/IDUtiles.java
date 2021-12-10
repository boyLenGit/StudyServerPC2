<<<<<<< HEAD
package len.mybatis;

import org.junit.Test;
import java.util.UUID;

public class IDUtiles {

    public static String Len_getId(){
        // UUID.randomUUID()生成唯一识别码（直接生成的ID中有“-”存在，如果不需要，可以使用replace()方法去掉）
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void  test(){
        System.out.println(Len_getId());
    }

}
=======
package len.mybatis;

import org.junit.Test;
import java.util.UUID;

public class IDUtiles {

    public static String Len_getId(){
        // UUID.randomUUID()生成唯一识别码（直接生成的ID中有“-”存在，如果不需要，可以使用replace()方法去掉）
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void  test(){
        System.out.println(Len_getId());
    }

}
>>>>>>> 1da3f48 (first commit)
