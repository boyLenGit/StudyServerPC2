package leet;

public class l067 {
    public static String addBinary(String a, String b) {
        int num_a, num_b, over=0, single_res;
        StringBuilder sb = new StringBuilder();
        for (int ia=a.length()-1, ib=b.length()-1; ia>=0 | ib>=0; ia--, ib--){
            num_a = ia>=0 ? a.charAt(ia)-'0' : 0;
            num_b = ib>=0 ? b.charAt(ib)-'0' : 0;
            single_res = num_a+num_b+over;
            over = single_res / 2;
            single_res = single_res % 2;
            sb.append(single_res);
        }
        if (over!=0) sb.append(over);
        return sb.reverse().toString();
    }

    public static void main(String[] ar){
        System.out.println(addBinary("0", "0"));
    }
}
