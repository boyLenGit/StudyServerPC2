package leet;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class l144 {
    private List<Integer> arrayList = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        dg(root);
        return arrayList;
    }

    public void dg(TreeNode node){
        if (node==null) return;
        arrayList.add(node.val);
        if (node.left!=null) dg(node.left);
        if (node.right!=null) dg(node.right);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        List<Integer> list = new LinkedList<>();
        TreeNode temp;
        while (!stack.isEmpty()){
            temp = stack.pop();
            if (temp==null) break;
            list.add(temp.val);
            if (temp.right!=null) stack.add(temp.right);
            if (temp.left!=null) stack.add(temp.left);

        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode in = new TreeNode(3, new TreeNode(1), new TreeNode(2));
        l144 l = new l144();
        System.out.println(l.preorderTraversal2(in));
    }
}
