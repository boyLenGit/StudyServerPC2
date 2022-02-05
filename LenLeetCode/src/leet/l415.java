package leet;

public class l415 {
    public static String addStrings(String num1, String num2) {
        int val1, val2, over=0, single;
        String res = "";
        for (int i1=num1.length()-1, i2=num2.length()-1; i1>=0 | i2>=0; i1--, i2--){
            val1 = i1>=0 ? num1.charAt(i1)-'0' : 0;
            val2 = i2>=0 ? num2.charAt(i2)-'0' : 0;
            single = val1 + val2 + over;
            over = single / 10;
            res = String.valueOf(single%10).concat(res);
        }
        if (over!=0) res = String.valueOf(over).concat(res);
        return res;
    }

    public static void main(String[] arg){
        System.out.println(addStrings("9999", "1"));
    }
}
