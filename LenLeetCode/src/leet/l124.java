package leet;

import leet.help.TreeNode;

import java.util.Arrays;

public class l124 {
    private final int MIN = -9999;
    private int max_value = MIN;

    public int maxPathSum(TreeNode root) {
        dg2(root);
        return max_value;
    }

    public  int dg(TreeNode treeNode){
        max_value = Math.max(max_value, treeNode.val);
        if (treeNode.left==null && treeNode.right==null) return treeNode.val;
        int left_val = treeNode.left!=null ? dg(treeNode.left) : MIN;
        int right_val = treeNode.right!=null ? dg(treeNode.right) : MIN;
        max_value = Math.max(Math.max(left_val+right_val+treeNode.val, max_value),
                Math.max(Math.max(left_val, left_val+treeNode.val),
                        Math.max(right_val, right_val+treeNode.val)));
        return Math.max(treeNode.val, Math.max(left_val, right_val) + treeNode.val);
    }

    public  int dg2(TreeNode treeNode){
        max_value = Math.max(max_value, treeNode.val);
        if (treeNode.left==null && treeNode.right==null) return treeNode.val;
        int left_val = treeNode.left!=null ? dg2(treeNode.left) : MIN;
        int right_val = treeNode.right!=null ? dg2(treeNode.right) : MIN;
        int[] arr_max = new int[]{left_val+right_val+treeNode.val, max_value,
                left_val, left_val+treeNode.val, right_val, right_val+treeNode.val};
        Arrays.sort(arr_max);
        max_value = arr_max[arr_max.length-1];
        return Math.max(treeNode.val, Math.max(left_val, right_val) + treeNode.val);
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode input2 = new TreeNode(-3);
        TreeNode input3 = new TreeNode(-2, new TreeNode(-1), null);
        TreeNode input4 = new TreeNode(1, new TreeNode(2), null);
        l124 ccc = new l124();
        System.out.println(ccc.maxPathSum(input4));
    }
}
