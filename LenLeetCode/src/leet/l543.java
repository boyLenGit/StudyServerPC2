package leet;

import leet.help.TreeNode;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;

public class l543 {
    private static int max;
    public static int diameterOfBinaryTree(TreeNode root) {
        if (root==null) return 0;
        DFX(root);
        return max;
    }

    public static int DFX(TreeNode input){
        int len_left=0, len_right=0;
        len_left = input.left==null ? len_left : DFX(input.left)+1;
        len_right = input.right==null ? len_right : DFX(input.right)+1;
        max = Math.max(max, len_left+len_right);
        return Math.max(len_left, len_right);
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode input2 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(diameterOfBinaryTree(input2));
    }
}
