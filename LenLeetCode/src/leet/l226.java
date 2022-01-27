package leet;

import leet.help.TreeNode;

import java.util.ArrayList;

public class l226 {
    public static TreeNode invertTree(TreeNode root) {
        if (root==null) return null;
        root = dg(root);
        return root;
    }

    public static TreeNode dg(TreeNode treeNode){
        if (treeNode==null) return null;
        TreeNode temp = treeNode.left;
        treeNode.left = dg(treeNode.right);
        treeNode.right = dg(temp);
        return treeNode;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        invertTree(input1);
    }
}
