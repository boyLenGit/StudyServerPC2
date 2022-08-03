package lenTest;

import java.lang.reflect.Field;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/2 14:47
 */
public class lt016_ReflectUtils {
    public static void bianLi(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);
                    System.err.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Payment payment = new Payment();
        payment.setId(11);
        payment.setName("@@");
        payment.setPwd("123");
        bianLi(payment);
    }

}
