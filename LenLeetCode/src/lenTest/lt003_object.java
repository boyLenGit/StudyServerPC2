package lenTest;

import leet.help.TreeNode;

public class lt003_object {
    public static void main(String[] ad){
        int[] in1 = new int[]{1,2,3};
        int[] in2 = new int[]{1,2,3};
        int a = 3;
        int b = 4;
        System.out.println(in1.equals(in2));
        TreeNode[] aa = new TreeNode[0];
        TreeNode bb = new TreeNode();
        System.out.println(bb.clone());
    }
}
