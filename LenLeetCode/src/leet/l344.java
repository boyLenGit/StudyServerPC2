package leet;

import java.util.Arrays;

public class l344 {
    public void reverseString(char[] s) {
        char temp;
        for (int i1=0, i2=s.length-1; i1<i2; i1++, i2--){
            temp = s[i1];
            s[i1] = s[i2];
            s[i2] = temp;
        }

    }

    public static void main(String[] args) {
        l344 l = new l344();
        char[] i = new char[]{};
        l.reverseString(i);
        System.out.println(Arrays.toString(i));
    }
}
