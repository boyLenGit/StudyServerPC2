package RealMeet.jingdong0531;

import java.util.ArrayList;

public class Main2 {
    public static int func(int hang, int lie, ArrayList<String> bodys){
        int res = 0;
        // 最后一列
        String last = bodys.get(bodys.size()-1);
        for (int i1=0; i1<last.length(); i1++){
            if (last.charAt(i1)=='D') res++;
        }
        for (int i2=0; i2<hang; i2++){
            if (bodys.get(i2).charAt(lie-1)=='R')res++;
        }
        return res;
    }
}
