package leet;

public class l069 {
    public static int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public static int mySqrt2(int x) {
        if (x==2) return 1;
        int low=0, high=x-1, mid=0;
        long multi, multi_next;
        while (low<=high){
            mid = (high-low)/2 + low;
            multi = (long)mid*mid;
            multi_next = (long)(mid+1)*(long)(mid+1);
            if (multi<=x && multi_next>x) return mid;
            else if (multi_next==x) return mid+1;
            else if (multi<x) low = mid-1;
            else if (multi>x) high = mid+1;
        }
        return mid;
    }

    public static void main(String[] arg){
        System.out.println(mySqrt2(2147395599));
        for (int i1=0; i1<100; i1++){
            System.out.println(mySqrt(i1)==mySqrt2(i1));
        }
    }
}
