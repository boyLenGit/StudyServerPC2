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
        TreeNode in2 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode in3 = new TreeNode(2, new TreeNode(3, new TreeNode(1), null), null);
        Solution094 solution = new Solution094();
        System.out.println(solution.inorderTraversal3(in2));
        System.out.println(1);
    }
}

class Solution094 {
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
        // 自己尝试的循环法,错误,做不出来
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        if (current==null) return res;
        while (true){
            while (current.left!=null){
                stack.add(current);
                current = current.left;
            }
            res.add(current.val);
            if (!stack.isEmpty()){
                current = stack.pop();
                res.add(current.val);
            }
            while (!stack.isEmpty() && current.right==null){
                current = stack.pop();
                res.add(current.val);
                current = current.right;
            }
            if (stack.isEmpty() && current.right==null) break;
        }
        return res;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode deep_left = root;
        TreeNode temp;
        if (deep_left==null) return res;
        while (!stack.isEmpty() || deep_left!=null){
            while (deep_left!=null){
                stack.push(deep_left);
                deep_left = deep_left.left;
            }
            // ↓ 如果没有right,则一直pop,然后存就行了
            temp = stack.pop();
            res.add(temp.val);
            if (temp.right!=null){
                deep_left = temp.right;
            }
        }
        return res;
    }

}