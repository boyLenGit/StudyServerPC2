package leet;

public class l043 {
    public static String multiply(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int over = 0;
        int temp, temp1, temp2;
        String right = "";
        for (int i1=num1.length()-1, i2=num2.length()-1; i1>=0 | i2>=0; i1--, i2--){
            temp1 = i1>=0 ? ChartoInt(chars1[i1]) : 1;
            temp2 = i2>=0 ? ChartoInt(chars2[i2]) : 1;
            temp = temp1 * temp2 + over;
            over = temp / 10;
            right = String.valueOf(temp%10).concat(right);
        }
        if (over!=0) right = String.valueOf(over).concat(right);
        return right;
    }

    public static int ChartoInt(char in){
        return in - '0';
    }

    public static void main(String[] a){
        System.out.println(multiply("9", "9"));
    }
}
