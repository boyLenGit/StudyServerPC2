package leet;

import leet.help.TreeNode;

import java.util.ArrayList;

public class l101 {
    public static boolean isSymmetric(TreeNode root) {
        ArrayList<TreeNode> lefts = new ArrayList<>();
        ArrayList<TreeNode> lefts_temp;
        ArrayList<TreeNode> rights = new ArrayList<>();
        ArrayList<TreeNode> rights_temp;
        lefts.add(root.left);
        lefts.add(root.right);
        for (int i1=0; ; i1++){
            for (int i2_l=0, i2_r=rights.size()-1; i2_l<lefts.size() & i2_r>=0; i2_l++, i2_r--){
                if ((lefts.get(i2_l)==null & rights.get(i2_r)!=null) || (lefts.get(i2_l)!=null & rights.get(i2_r)==null)) return false;
                else if (lefts.get(i2_l).val!=rights.get(i2_r).val) return false;
            }
            // 更新arrayList
            lefts_temp = new ArrayList<>();
            rights_temp = new ArrayList<>();
            for (int i2=0; i2<lefts.size(); i2++){
                lefts_temp.add(lefts.get(i2).left);
                lefts_temp.add(lefts.get(i2).right);
                rights_temp.add(rights.get(i2).left);
                rights_temp.add(rights.get(i2).right);
            }
            lefts = lefts_temp;
            rights = rights_temp;
        }
    }
}
