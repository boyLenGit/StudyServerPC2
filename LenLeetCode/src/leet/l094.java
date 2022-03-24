package leet;

import leet.help.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class l094 {
    public static void main(String[] args) {
        TreeNode in1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(6)));
        Solution solution = new Solution();
        System.out.println(solution.inorderTraversal2(in1));
    }
}

class Solution {
    private List<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null) return res;
        dg(root);
        return res;
    }

    public void dg(TreeNode node){
        if (node.left!=null) dg(node.left);
        res.add(node.val);
        if (node.right!=null) dg(node.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty()){
            while (current.left!=null){
                stack.add(current);
                current = current.left;
            }
            res.add(current.val);
            current = stack.pop();
            res.add(current.val);
            if (current.right!=null){
                current  = current.right;
            }
        }
        return res;
    }
}