package leet;

import leet.help.TreeNode;

import java.util.ArrayList;

public class l101 {
    public static boolean isSymmetric(TreeNode root) {
        if (root.left==null && root.right==null) return true;
        ArrayList<TreeNode> lefts = new ArrayList<>();
        ArrayList<TreeNode> lefts_temp;
        ArrayList<TreeNode> rights = new ArrayList<>();
        ArrayList<TreeNode> rights_temp;
        lefts.add(root.left);
        rights.add(root.right);
        int cnt;
        for (int i1=0; ; i1++){
            if (lefts.size()!=rights.size()) return false;
            for (int i2_l=0, i2_r=rights.size()-1; i2_l<lefts.size() & i2_r>=0; i2_l++, i2_r--){
                if ((lefts.get(i2_l)==null & rights.get(i2_r)!=null) || (lefts.get(i2_l)!=null & rights.get(i2_r)==null)) return false;
                else if (lefts.get(i2_l)==null & rights.get(i2_r)==null) continue;
                else if (lefts.get(i2_l).val!=rights.get(i2_r).val) return false;
            }
            // 更新arrayList
            cnt = 0;
            lefts_temp = new ArrayList<>();
            rights_temp = new ArrayList<>();
            for (int i2=0; i2<lefts.size(); i2++){
                if (lefts.get(i2)!=null){
                    lefts_temp.add(lefts.get(i2).left);
                    lefts_temp.add(lefts.get(i2).right);
                }else {
                    lefts_temp.add(null);
                    cnt++;
                }
                if (rights.get(i2)!=null){
                    rights_temp.add(rights.get(i2).left);
                    rights_temp.add(rights.get(i2).right);
                }else rights_temp.add(null);
            }
            if (cnt==lefts.size()) break;
            lefts = lefts_temp;
            rights = rights_temp;
        }
        return true;
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4))
        );
        TreeNode input2 = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), new TreeNode(4))
        );
        TreeNode input3 = new TreeNode(1);
        TreeNode input4 = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(2, new TreeNode(3), new TreeNode(4))
        );
        TreeNode input5 = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(4)),
                new TreeNode(2, new TreeNode(3), new TreeNode(4))
        );
        System.out.println(isSymmetric(input4));
    }
}
