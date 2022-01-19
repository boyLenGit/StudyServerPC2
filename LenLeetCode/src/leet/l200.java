package leet;

import util.LenLog;

public class l200 {
    public static int numIslands(char[][] grid) {
        // 递归的思路
        int[][] inputs = new int[grid.length][grid[0].length];
        int value = 2;
        int cnt = 0;
        for (int i1=0; i1<grid.length; i1++){
            for (int i2=0; i2<grid[0].length; i2++){
                inputs[i1][i2] = grid[i1][i2]-'0';
            }
        }
        for (int i1=0; i1<grid.length; i1++){
            for (int i2=0; i2<grid[0].length; i2++){
                if (inputs[i1][i2]==0) continue;
                else if (inputs[i1][i2]==1) {
                    value++;
                    cnt++;
                    inputs[i1][i2] = value;
                }
                dg(inputs, i1, i2);
            }
        }
        LenLog.printInt2vArray(inputs);
        return cnt;
    }

    public static void dg(int[][] inputs, int i1, int i2){
        if (i1-1>=0){
            if (inputs[i1-1][i2]==1){
                inputs[i1-1][i2] = inputs[i1][i2];
                dg(inputs, i1-1, i2);
            }
        }
        if (i1+1<inputs.length){
            if (inputs[i1+1][i2]==1){
                inputs[i1+1][i2] = inputs[i1][i2];
                dg(inputs, i1+1, i2);
            }
        }
        if (i2-1>=0){
            if (inputs[i1][i2-1]==1){
                inputs[i1][i2-1] = inputs[i1][i2];
                dg(inputs, i1, i2-1);
            }
        }
        if (i2+1<inputs[0].length){
            if (inputs[i1][i2+1]==1){
                inputs[i1][i2+1] = inputs[i1][i2];
                dg(inputs, i1, i2+1);
            }
        }
    }

    public static void main(String[] args){
        char[][] input = new char[][]{
                {'1','1','0','1','0'},
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'0','0','1','0','1'}};
        numIslands(input);
    }
}
