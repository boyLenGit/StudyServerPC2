package leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class l054 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int i1=0, i2=0;  // 列\行下标
        int rotate_stat = 4;
        int time = 0;
        List<Integer> res = new ArrayList<>();
        for (int cnt=0; cnt<matrix.length*matrix[0].length; cnt++){
            if (rotate_stat==4){
                res.add(matrix[i1][i2]);
                i2++;
                // 跳出向右👉🏻遍历
                if (i2-time>=matrix[0].length){
                    rotate_stat = 1;
                    i2--;
                    i1++;
                }
            }else if (rotate_stat==1){
                res.add(matrix[i1][i2]);
                i1++;
                if (i1-time>=matrix.length){
                    rotate_stat = 2;
                    i1--;
                    i2--;
                }
            }else if (rotate_stat==2){
                res.add(matrix[i1][i2]);
                i2--;
                if (i2+time<0){
                    rotate_stat = 3;
                    i2++;
                    i1--;
                }
            }else if (rotate_stat==3){
                res.add(matrix[i1][i2]);
                i1--;
                if (i1+time<0){
                    rotate_stat = 4;
                    i1++;
                    i2++;
                }
            }
        }
        return res;
    }

    public static void main(String[] a){
        int[][] input1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(input1));
    }
}
