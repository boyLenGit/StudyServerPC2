package leet;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l145 {
    private List<Integer> list = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        dg(root);
    }

    public void dg(TreeNode node){
        if (node.left!=null) dg(node.left);
        if (node.right!=null) dg(node.right);
        list.add(node.val);
        }
    }
}
