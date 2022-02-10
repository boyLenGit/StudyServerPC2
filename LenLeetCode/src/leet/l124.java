package leet;

import leet.help.TreeNode;

public class l124 {
    private int max_value = 0;

    public int maxPathSum(TreeNode root) {
        dg(root);
        return max_value;
    }

    public  int dg(TreeNode treeNode){
        if (treeNode.left==null && treeNode.right==null) return treeNode.val;
        int left_val = treeNode.left!=null ? dg(treeNode.left) : 0;
        int right_val = treeNode.right!=null ? dg(treeNode.right) : 0;
        max_value = Math.max(Math.max(left_val+right_val+treeNode.val, max_value), Math.max(left_val, right_val));
        return Math.max(left_val, right_val) + treeNode.val;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        l124 ccc = new l124();
        System.out.println(ccc.maxPathSum(input1));
    }
}
