package lenTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class lt007_reflact {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class user = Class.forName("lenTest.LenUser");
//        Method method = user.getMethod("get", String.class);
//        Constructor constructor = user.getConstructor();
//        Object object = constructor.newInstance();
//        Object instance = method.invoke(object, "a");
//        System.out.println(instance.toString());

//        Class class1 = Class.forName("lenTest.LenUser");
//        Method method = class1.getMethod("get", String.class);
//        Constructor constructor = class1.getConstructor();
//        Object user = constructor.newInstance();
//        Object result = method.invoke(user, "AAA");
//        System.out.println(result.toString());

        // 获取Class -> 获取method:getMethod(方法名, 方法类型) -> 获取Constructor -> 生成对象实例object -> 运行方法method.invoke(对象, 传入的参数)
        Class class2 = Class.forName("lenTest.LenUser");
        Method method1 = class2.getMethod("get", String.class);
        Constructor constructor1 = class2.getConstructor();
        Object lenUser1 = constructor1.newInstance();
        String result1 = (String)method1.invoke(lenUser1, "BBBB");
        System.out.println(result1);
    }


}

class LenUser{
    private int a;

    public LenUser() {
    }

    public static String get(String str){
        System.out.println("这里是get方法");
        return "T"+str;
    }
}