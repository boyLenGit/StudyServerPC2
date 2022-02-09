package leet;

import leet.help.TreeNode;

public class l104 {
    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return dg(root);
    }

    public static int dg(TreeNode node){
        int left_depth=1, right_depth=1;
        if (node.left!=null) left_depth = dg(node.left)+left_depth;
        if (node.right!=null) right_depth = dg(node.right)+right_depth;
        return Math.max(right_depth, left_depth);
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(new TreeNode(1)));
    }
}
