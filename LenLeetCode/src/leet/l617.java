package leet;

import leet.help.TreeNode;

public class l617{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null) return root2;
        if (root2==null) return root1;
        dg(root1, root2);
        return root1;
    }

    public static void dg(TreeNode node1, TreeNode node2){
        node1.val += node2.val;
        if (node1.left==null) node1.left = node2.left;
        else{
            if (node2.left!=null) dg(node1.left, node2.left);
        }
        if (node1.right==null) node1.right = node2.right;
        else{
            if (node2.right!=null) dg(node1.right, node2.right);
        }
    }
}
