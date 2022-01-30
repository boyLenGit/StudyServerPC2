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

    public static String[] permutation3(String s) {
        Set<String> set_res = new HashSet<>();
        char[] chars = s.toCharArray();
        boolean[] help = new boolean[chars.length];
        Arrays.fill(help, false);
        dg3(set_res, "", chars, help);
        return set_res.toArray(new String[0]);
    }

    public static void dg3(Set<String> set_res, String grower, char[] chars, boolean[] help){
        if (grower.length()==chars.length){
            set_res.add(grower);
            return;
        }
        for (int i1=0; i1<chars.length; i1++){
            if (help[i1]) continue;
            help[i1] = true;
            dg3(set_res, grower + String.valueOf(chars[i1]), chars, help);
            help[i1] = false;
        }
    }

    public static String[] permutation_leetcode(String s) {
        Set<String> list = new HashSet<>();
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[arr.length];
        dfs(arr, "", visited, list);
        return list.toArray(new String[0]);
    }
    public static void dfs(char[] arr, String s,  boolean[] visited, Set<String> list)
    {
        if(s.length() == arr.length)
        {
            list.add(s);
            return;
        }
        for(int i=0; i<arr.length; i++)
        {
            if(visited[i]) continue;
            visited[i] = true;
            dfs(arr, s+String.valueOf(arr[i]), visited, list);
            visited[i] = false;
        }

    }

    public static void main(String[] ast){
        String in1 = "aab";
        System.out.println(Arrays.toString(permutation3(in1)));
        Set<String> test1 = new HashSet<>();
        test1.add("Sdf");
        test1.add("Sdf");
        test1.add("Sdf1");
        System.out.println(test1);
    }
}

//["aba","aab","baa"]"dkjphedy"