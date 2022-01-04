package leet;

import java.util.Arrays;

public class l006 {
    public static String convert(String s, int numRows) {
        char[][] chars_2v = new char[numRows][];
        int length = s.length();
        int length_s_2v = (s.length()/(numRows+1)) * 2;
        // 生成全是0的二维矩阵
        for(int i1=0; i1<numRows; i1++){
            char[] chars_temp = new char[length_s_2v];
            Arrays.fill(chars_temp, '0');
            chars_2v[i1] = chars_temp;
        }
        int index_1v = 0;
        int index_2v = 0;
        int single_row_index_1v = numRows -1 - 1;
        int single_row_checker = 0;
        for(int i0=0; i0<length; i0++){
            // index_1v与index_2v更新
            if(index_1v>=numRows){
                index_1v=0;
                index_2v++;
                single_row_checker = single_row_checker!=0 ? 0 : 1;
            }
            // single_row_index_1v值检查
            if (single_row_index_1v<=0){
                single_row_index_1v = numRows -1 - 1;
            }
            // 保存列的内容
            if (single_row_checker==1){ // 如果是要保存单列的char
                chars_2v[single_row_index_1v][index_2v] = s.charAt(i0);
                index_2v++;
                single_row_checker = 0;
            }else { // 常规列保存
                chars_2v[index_1v][index_2v] = s.charAt(i0);
            }
            index_1v++;
        }
        return s;
    }

    public static void main(String[] args) {
        String test01 = "PAYPALISHIRING";
        String result = convert(test01, 3);
    }
}
