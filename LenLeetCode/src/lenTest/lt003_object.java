package lenTest;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lt003_object {
    public static void main(String[] ad){
        int[] in1 = new int[]{1,2,3};
        int[] in2 = new int[]{1,2,3};
        char[] chars = new char[]{'a','b','c'};
        System.out.println(Arrays.toString(in1));
        System.out.println(new String(chars));
        TreeNode[] aa = new TreeNode[0];
        TreeNode bb = new TreeNode();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
            }
        });
        thread.start();

    }
}

