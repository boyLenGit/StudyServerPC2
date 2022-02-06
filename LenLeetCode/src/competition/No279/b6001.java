package competition.No279;

import java.util.Arrays;

public class b6001 {
    public static long smallestNumber(long num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int PosOrNeg = 1;
        if (sb.charAt(0)=='-') {
            PosOrNeg = -1;
            sb.deleteCharAt(0);
        }
        int[] in1 = new int[sb.length()];
        for (int i1=0; i1<sb.length(); i1++){
            in1[i1] = sb.charAt(i1) - '0';
        }
        Arrays.sort(in1);
        StringBuilder resSB = new StringBuilder();
        int ZeroCnt = 0;
        if (PosOrNeg==1){
            for (int i1=0; i1<in1.length; i1++){
                if (in1[i1]==0){
                    ZeroCnt++;
                }else {
                    resSB.append(in1[i1]);
                    if (resSB.length()==1){
                        for (int i2=0; i2<ZeroCnt; i2++){
                            resSB.append(0);
                        }
                    }
                }
            }
        }else {
            for (int i1=in1.length-1; i1>=0; i1--){
                resSB.append(in1[i1]);
            }
        }

        String resStr = resSB.toString();
        if (PosOrNeg==-1) resStr = "-".concat(resStr);
        return resStr.length()!=0 ? Long.parseLong(resStr) : 0;
    }

    public static void main(String[] a){
        System.out.println(smallestNumber(-7605));
    }
}
