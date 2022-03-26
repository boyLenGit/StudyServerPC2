package leet;

import leet.help.TreeNode;

import java.util.*;

public class l145 {
    private List<Integer> list = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dg(root);
        return list;
    }

    public void dg(TreeNode node){
        if (node==null) return;
        if (node.left!=null) dg(node.left);
        if (node.right!=null) dg(node.right);
        list.add(node.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode temp;
        while (!stack.isEmpty()){
            temp = stack.pop();
            if (temp==null) break;
            res.add(temp.val);
            if (temp.left!=null) stack.add(temp.left);
            if (temp.right!=null) stack.add(temp.right);
        }
        Collections.reverse(res);
        return res;
    }
}
