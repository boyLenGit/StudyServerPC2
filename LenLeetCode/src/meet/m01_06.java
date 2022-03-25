package meet;

public class m01_06 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
    }
}

class Solution {
    public String compressString(String S) {
        if (S.length()==0) return "";
        StringBuilder res = new StringBuilder();
        int len=1;
        for (int i1=1; i1<S.length(); i1++){
            if (S.charAt(i1)==S.charAt(i1-1)){
                len++;
            }else {
                res.append(S.charAt(i1-1)).append(len);
                len = 1;
            }
        }
        res.append(S.charAt(S.length()-1)).append(len);
        if (res.length()>=S.length()) return S;
        else return res.toString();
    }
}