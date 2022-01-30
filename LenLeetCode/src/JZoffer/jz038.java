package JZoffer;

import java.util.*;

public class jz038 {
    public static String[] permutation(String s) {
        String jack = "";
        for (int i1=0; i1<s.length(); i1++){
            jack = jack.concat(String.valueOf(i1));
        }
        ArrayList<String> res = new ArrayList<>();
        for (int i1=0; i1<jack.length(); i1++){
            res.add(String.valueOf(jack.charAt(i1)));
        }
        res = dg(res, jack, 0);
        // 将index合成char,并除掉重复元素
        ArrayList<String> res_unrepeat = new ArrayList<>();
        for (int i1=0; i1<res.size(); i1++){
            String mask = "";
            for (int i2=0; i2<s.length(); i2++){
                mask = mask.concat(String.valueOf(s.charAt(res.get(i1).charAt(i2)-'0')));
            }
            res_unrepeat.add(mask);
        }
        for (int i1=0; i1<res_unrepeat.size(); i1++){
            if (res_unrepeat.lastIndexOf(res_unrepeat.get(i1))!=i1){
                res_unrepeat.remove(i1);
                i1--;
            }
        }
        // 合成结果
        String[] ret = new String[res_unrepeat.size()];
        for (int i1=0; i1<res_unrepeat.size(); i1++){
            ret[i1] = res_unrepeat.get(i1);
        }
        return ret;
    }

    public static ArrayList<String> dg(ArrayList<String> res, String s, int cnt){
        cnt++;
        if (cnt==s.length()) return res;
        ArrayList<String> temp = new ArrayList<>();
        for (int i1=0; i1<res.size(); i1++){
            for (int i2=0; i2<s.length(); i2++){
                if (res.get(i1).indexOf(String.valueOf(s.charAt(i2)))==-1) temp.add(res.get(i1).concat(String.valueOf(s.charAt(i2))));
            }
        }
        res = temp;
        res = dg(res, s, cnt);
        return res;
    }

    public static String[] permutation2(String s) {
        ArrayList<String> res = new ArrayList<>();
        ArrayList<ArrayList<Character>> res_help = new ArrayList<>();
        ArrayList<Character> temp01 = new ArrayList<>();
        ArrayList<Character> res_help_temp = new ArrayList<>();
        for (int i1=0; i1<s.length(); i1++) temp01.add(s.charAt(i1));
        res_help.add(temp01);
        int res_help_size = res_help.size();
        for (int i2=0; i2<res_help_size; i2++){
            for (int i3=0; i3<res_help.get(i2).size(); i3++){
                res.add(String.valueOf(res_help.get(i2).get(i3)));
                res_help_temp = (ArrayList<Character>) res_help.get(i2).clone();
                res_help_temp.remove(i3);
                res_help.add((ArrayList<Character>) res_help_temp.clone());
            }
        }
        for (int i1=0; i1<res_help_size; i1++) res_help.remove(0);
        res = dg1(res, res_help, s, 0);
        String[] ret = new String[res.size()];
        for (int i1=0; i1<res.size(); i1++){
            ret[i1] = res.get(i1);
        }
        return ret;
    }

    public static ArrayList<String> dg1(ArrayList<String> res, ArrayList<ArrayList<Character>> help, String s, int cnt){
        cnt++;
        if (cnt>=s.length()) return res;
        ArrayList<String> res_temp = new ArrayList<>();
        ArrayList<Character> help_temp = new ArrayList<>();
        int help_size = help.size();
        for (int i1=0; i1<res.size(); i1++){
            for (int i2=0; i2<help.get(i1).size(); i2++){
                String single = res.get(i1).concat(String.valueOf(help.get(i1).get(i2)));
                if (res_temp.contains(single)) continue;
                res_temp.add(single);
                help_temp = (ArrayList<Character>) help.get(i1).clone();
                help_temp.remove(i2);
                help.add((ArrayList<Character>) help_temp.clone());
            }
        }
        for (int i1=0; i1<help_size; i1++) help.remove(0);
        res = res_temp;
        res = dg1(res, help, s, cnt);
        return res;
    }


    

    public static void main(String[] ast){
        String in1 = "dkjphedy";
        System.out.println(Arrays.toString(permutation2(in1)));
    }
}

//["aba","aab","baa"]"dkjphedy"