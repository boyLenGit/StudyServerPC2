package leet;

public class l278 {
    public static int firstBadVersion(int n) {
        if (n==2147483647) n--;
        int temp;
        int min=0;
        for(int i1=(n+1)/2; ; ){
            temp = i1;
            if (isBadVersion(i1)==false & isBadVersion(i1-1)==false) {
                min = i1;
                i1 = i1+(n-i1)/2;
            }
            else if(isBadVersion(i1)==true& isBadVersion(i1-1)==true) i1 = min+(i1-min)/2;
            else if (isBadVersion(i1)==true & isBadVersion(i1-1)==false) return i1;
            if (temp==i1) i1++;
        }
    }

    public static boolean isBadVersion(int i1){
        return i1 >= 2147483647;
    }

    public static void main(String[] arg){
        System.out.println(firstBadVersion(2147483647));
    }
}
// 2126753390, 1702766719
//2147483647
//2147483647