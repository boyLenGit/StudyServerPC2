package leet;

public class l455 {
    public static int findContentChildren(int[] g, int[] s) {
        lenSortQuickDFX(g, 0, g.length-1);
        lenSortQuickDFX(s, 0, s.length-1);
        int plus=0, cnt_s=0, res=0;
        for (int i1=0; i1<g.length; i1++){
            for ( ; cnt_s<s.length; cnt_s++){
                plus += s[cnt_s];
                if (plus>=g[i1]){
                    res++;
                    break;
                }
            }
            if (cnt_s>=g.length) return res;
        }
        return res;
    }

    public static void lenSortQuickDFX(int[] inputs, int start, int end){
        int i1=start, i2=end, exchange, compare;
        if (start>end)return;
        compare = inputs[start];
        while (i1<i2){
            while (compare<=inputs[i2] && i1<i2) i2--;
            while (compare>=inputs[i1] && i1<i2) i1++;
            if (i1<i2){
                exchange = inputs[i1];
                inputs[i1] = inputs[i2];
                inputs[i2] = exchange;
            }
        }
        inputs[start] = inputs[i1];
        inputs[i1] = compare;
        lenSortQuickDFX(inputs, start, i1-1);
        lenSortQuickDFX(inputs, i1+1, end);
    }

    public static void main(String[] arg){
        System.out.println(findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
    }
}
