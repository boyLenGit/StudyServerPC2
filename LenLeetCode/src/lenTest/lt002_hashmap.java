package lenTest;

import leet.help.TreeNode;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class lt002_hashmap {
    public static void main(String[] args){
        Map<String, String> map = new HashMap<>();
        map.put("321", "312");
        map.put("322", "312");
        System.out.println(map);
    }

    public static void sss() throws Exception {
        // [正序列化]写入
        ObjectOutputStream oos_write = new ObjectOutputStream(new FileOutputStream("treenode1.out"));
        TreeNode treeNode = new TreeNode();
        oos_write.writeObject(treeNode);
        oos_write.close();
        // [反序列化]读取
        ObjectInputStream oos_read = new ObjectInputStream(new FileInputStream("treenode1.out"));
        Object treenode_read = oos_read.readObject();
        oos_read.close();
        System.out.println(treenode_read);
    }
}
