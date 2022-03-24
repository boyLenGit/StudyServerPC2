package leet;

import leet.help.TreeNode;

public class l235 {
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//
//    }

    public void dg(TreeNode root, TreeNode p, TreeNode q){
        if (root==p) return;
        if (root.left!=null) dg(root.left, p, q);
        if (root.right!=null) dg(root.right, p, q);

    }
}
