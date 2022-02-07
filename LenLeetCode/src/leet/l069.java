package leet;

public class l069 {
    public static int mySqrt(int x) {
        return (int)Math.sqrt(x);
    }

    public static int mySqrt2(int x) {
        int low=0, high=x-1, mid=0;
        while (low<=high){
            mid = (high-low)/2 + low;
            if (mid*mid<=x && (mid+1)*(mid+1)>x) return mid;
            else if ((mid+1)*(mid+1)==x) return mid+1;
            else if (mid*mid<x) low = mid-1;
            else if (mid*mid>x) high = mid+1;
        }
        return mid;
    }

    public static void main(String[] arg){
        System.out.println(mySqrt2(4));
    }
}
