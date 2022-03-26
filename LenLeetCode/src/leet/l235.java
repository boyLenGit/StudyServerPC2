package leet;

import leet.help.TreeNode;

public class l235 {
    TreeNode res;
    int lock=0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int state_left=0, state_right=0;
        dg(root, p, q);
        return res;
    }

    public int dg(TreeNode root, TreeNode p, TreeNode q){
        int state_left=0, state_right=0;
        if (root.left!=null) state_left = dg(root.left, p, q);
        if (root.right!=null) state_right = dg(root.right, p, q);
        if (root==p || root==q) {
            if (state_right+state_left==1 && lock==0) res = root;
            return 1;
        }
        if (state_right+state_left>=2 && lock==0) {
            res = root;
            lock=1;
        }
        return state_left+state_right;
    }

    public static void main(String[] args) {
        TreeNode q1 = new TreeNode(4);
        TreeNode p1 = new TreeNode(2, q1, null);
        l235 l = new l235();
        l.lowestCommonAncestor(p1, p1, q1);

    }
}
