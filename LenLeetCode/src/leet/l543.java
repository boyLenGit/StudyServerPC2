package leet;

import leet.help.TreeNode;
import sun.jvm.hotspot.oops.Array;

import java.util.ArrayList;

public class l543 {
    public static int diameterOfBinaryTree(TreeNode root) {
        ArrayList<TreeNode> inputs = new ArrayList<>();
        ArrayList<TreeNode> temp;
        inputs.add(root);
        int i1=0;
        for (; ; i1++){
            temp = new ArrayList<>();
            for (int i2=0; i2<inputs.size(); i2++){
                if (inputs.get(i2).left!=null) temp.add(inputs.get(i2).left);
                if (inputs.get(i2).right!=null) temp.add(inputs.get(i2).right);
            }
            if (temp.size()==0) break;
            inputs = temp;
        }
        return i1;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(diameterOfBinaryTree(input1));
    }
}
