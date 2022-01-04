package leet;

import java.util.Arrays;

public class l006 {
    public static String convert(String s, int numRows) {
        char[][] chars_2v = new char[numRows][];
        int length = s.length();
        int length_s_2v = (s.length()/(numRows+1)) * 2;
        for(int i1=0; i1<numRows; i1++){
            Arrays.fill(chars_2v[i1], '0');
        }
        int index_1v = 0;
        int index_2v = 0;
        for(int i0=0; i0<length; i0++){
            if(index_1v>=numRows){
                index_1v=0;
                index_2v++;
            }
            if(index_2v==0){
                chars_2v[]
            }
            Arrays.fill();
            chars_2v[index_1v][index_2v] = s.charAt(i0);
            index_2v++;
        }
        return s;
    }

    public static void main(String[] args) {
        String test01 = "PAYPALISHIRING";
        String result = convert(test01, 3);
    }
}
