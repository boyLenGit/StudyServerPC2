package leet;

import leet.help.TreeNode;

public class l124 {
    public static int maxPathSum(TreeNode root) {
        return dg(root);
    }

    public static int dg(TreeNode treeNode){
        int max_val;
        if (treeNode.left==null && treeNode.right==null) max_val = treeNode.val;
        else if (treeNode.left!=null && treeNode.right==null) max_val = Math.max(dg(treeNode.left)+treeNode.val, dg(treeNode.left));
        else if (treeNode.left==null && treeNode.right!=null) max_val = Math.max(dg(treeNode.right)+treeNode.val, dg(treeNode.right));
        else max_val = Math.max(Math.max(dg(treeNode.left), dg(treeNode.right)), dg(treeNode.left)+dg(treeNode.right)+treeNode.val);
        return max_val;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxPathSum(input1));
    }
}
