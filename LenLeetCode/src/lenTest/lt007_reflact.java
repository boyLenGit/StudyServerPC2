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

        Class class1 = Class.forName("lenTest.LenUser");
        Method method = class1.getMethod("get", String.class);
        Constructor constructor = class1.getConstructor();
        Object user = constructor.newInstance();
        Object result = method.invoke(user, "AAA");
        System.out.println(result.toString());
    }


}

class LenUser{
    private int a;

    public LenUser() {
    }

    public static String get(String str){
        System.out.println("ABC");
        return "T"+str;
    }
}