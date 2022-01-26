package leet;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class l102 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        List<Integer> temp_result = new ArrayList<>();
        ArrayList<TreeNode> inputs = new ArrayList<>();
        ArrayList<TreeNode> temp_inputs = new ArrayList<>();
        inputs.add(root);
        int cntEnd;
        while (true){
            // 初始化
            cntEnd = 0;
            // 提取当前[TreeNode]的val
            temp_result = new ArrayList<>();
            for (int i2=0; i2<inputs.size(); i2++){
                temp_result.add(inputs.get(i2).val);
                if (inputs.get(i2).right==null & inputs.get(i2).left==null) cntEnd++;
            }
            result.add(temp_result);
            // 判定结束条件
            if (cntEnd==inputs.size()) break;
            // 生成下一组将要遍历的[TreeNode]
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
        levelOrder(null);
    }
}


