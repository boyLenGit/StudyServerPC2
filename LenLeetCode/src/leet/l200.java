package leet;

import util.LenLog;

public class l200 {
    public static int numIslands(char[][] grid) {
        int[][] inputs = new int[grid.length][grid[0].length];
        for (int i1=0; i1<grid.length; i1++){
            for (int i2=0; i2<grid[0].length; i2++){
                inputs[i1][i2] = grid[i1][i2]-'0';
            }
        }
        // 2代表已经搜索过了
        int value = 2;
        for (int i1=0; i1<grid.length; i1++){
            for (int i2=0; i2<grid[0].length; i2++){
                if (inputs[i1][i2]==0) continue;
//                // 取值
//                if (i2!=0 & i1!=0){
//                    if (inputs[i1][i2-1]!=0 & inputs[i1-1][i2]==0){
//                        value = inputs[i1][i2-1];
//                    }else if (inputs[i1][i2-1]==0 & inputs[i1-1][i2]!=0){
//                        value = inputs[i1-1][i2];
//                    }else if (inputs[i1][i2-1]!=0 & inputs[i1-1][i2]!=0){
//                        value = inputs[i1][i2-1];
//                    }else if (inputs[i1][i2-1]==0 & inputs[i1-1][i2]==0){
//                        value++;
//                        inputs[i1][i2] = value;
//                    }
//                }else if (i2!=0 & i1==0){
//                    if (inputs[i1][i2-1]==0){
//                        value++;
//                        inputs[i1][i2] = value;
//                    }
//                }else if (i1!=0 & i2==0){
//                    if (inputs[i1-1][i2]==0){
//                        value++;
//                        inputs[i1][i2] = value;
//                    }
//                }else if (i1==0 & i2==0){
//                    value++;
//                    inputs[i1][i2] = value;
//                }
//
//                // 赋值
//                if (i2!=grid[0].length-1){
//                    if (inputs[i1][i2+1]!=0) inputs[i1][i2+1]=value;
//                }
//                if (i1!=grid.length-1){
//                    if (inputs[i1+1][i2]!=0) inputs[i1+1][i2]=value;
//                }
                // 上
                for (int i3=i1-1; i3>=0; i3--){
                    if (inputs[i3][i2]==1);

                }
                // 下
                // 左
                // 右
            }
        }
        LenLog.printInt2vArray(inputs);
        return 0;
    }

    public static int numIslands_dg(char[][] grid) {
        int[][] inputs = new int[grid.length][grid[0].length];
        int value = 2;
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
                    inputs[i1][i2] = value;
                }
                dg(inputs, i1, i2);
            }
        }
        LenLog.printInt2vArray(inputs);
        return 0;
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
                inputs[i1][i2-1] = inputs[i1][i2-1];
                dg(inputs, i1, i2-1);
            }
        }
        if (i2+1<inputs[0].length){
            if (inputs[i1][i2+1]==1){
                inputs[i1][i2+1] = inputs[i1][i2+1];
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
        numIslands_dg(input);
    }
}
