package leet;

import leet.help.TreeNode;

import java.util.ArrayList;

public class l226 {
    public static TreeNode invertTree(TreeNode root) {
        ArrayList<ArrayList<Integer>> list_ints = new ArrayList<>();
        ArrayList<TreeNode> list_tnode = new ArrayList<>();
        ArrayList<TreeNode> list_tnode_temp;
        ArrayList<Integer> list_single;
        list_tnode.add(root);
        for (int i1=0; ;){
            list_single = new ArrayList<>();
            list_tnode_temp = new ArrayList<>();
            // 将treenode值读取进arraylist
            for (int i2=0; i2<list_tnode.size(); i2++){
                if (list_tnode.get(i2)!=null) list_single.add(list_tnode.get(i2).val);
                else list_single.add(999);
            }
            list_ints.add(list_single);
            // 将treenode放进list中
            for (int i3=0; i3<list_tnode.size(); i3++){
                if (list_tnode.get(i3).left!=null) list_tnode_temp.add(list_tnode.get(i3).left);
                else list_tnode_temp.add(null);
                if (list_tnode.get(i3).right!=null) list_tnode_temp.add(list_tnode.get(i3).right);
                else list_tnode_temp.add(null);
            }
            if (list_tnode_temp.size()==0) break;
            list_tnode = list_tnode_temp;
        }


        return new TreeNode();
    }

    public static void main(String[] a){
        TreeNode input1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        invertTree(input1);
    }
}
