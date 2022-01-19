package leet;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp_result = new ArrayList<>();
        ArrayList<TreeNode> inputs = new ArrayList<>();
        ArrayList<TreeNode> temp_inputs = new ArrayList<>();
        inputs.add(root);
        for (int i1=0; ; ){
            temp_result = new ArrayList<>();
            for (int i2=0; i2<inputs.size(); i2++){
                temp_result.add(inputs.get(i2).val);
            }
            result.add(temp_result);
            if (inputs.get(i1).left==null & inputs.get(i1).right==null) break;
            temp_inputs = new ArrayList<>();
            for (int i3=0; i3<inputs.size(); i3++){
                if (inputs.get(i3).left!=null) temp_inputs.add(inputs.get(i3).left);
                if (inputs.get(i3).right!=null) temp_inputs.add(inputs.get(i3).right);
            }
            inputs = (ArrayList<TreeNode>) temp_inputs.clone();
        }
        return result;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        levelOrder(input1);
    }
}


