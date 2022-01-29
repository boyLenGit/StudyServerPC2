package leet;

import leet.help.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class l103 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<TreeNode> inputs = new ArrayList<>();
        ArrayList<TreeNode> inputs_temp;
        inputs.add(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> res_temp;
        int toRight = 1;
        for (int i1=0; ;){
            if (inputs.size()==1 & inputs.get(0)==null) break;
            // 从ArrayList中提取内容
            res_temp = new ArrayList<>();
            for (int i2=0, i2_reverse=inputs.size()-1; i2<inputs.size(); i2++, i2_reverse--){
                if (toRight==1) res_temp.add(inputs.get(i2).val);
                else if (toRight==0) res_temp.add(inputs.get(i2_reverse).val);
            }
            res.add(res_temp);
            // 将TreeNode保存到List中
            inputs_temp = new ArrayList<>();
            for (int i2=0; i2<inputs.size(); i2++){
                if (inputs.get(i2).left!=null) inputs_temp.add(inputs.get(i2).left);
                if (inputs.get(i2).right!=null) inputs_temp.add(inputs.get(i2).right);
            }
            if (inputs_temp.size()==0) break;
            toRight = toRight==1 ? 0 : 1;
            inputs = inputs_temp;
        }
        return res;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        zigzagLevelOrder(input1);
    }
}
