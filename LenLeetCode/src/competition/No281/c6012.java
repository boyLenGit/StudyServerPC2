package competition.No281;

public class c6012 {
    public static int countEven(int num) {
        int res = 0;
        int temp = 0;
        int sum;
        for (int i1=1; i1<=num; i1++){
            sum=0;
            temp=i1;
            while (temp!=0){
                sum += temp%10;
                temp = temp/10;
            }
            if (sum%2==0) res++;
        }
        return res;
    }

    public static void main(String[] arg){
        System.out.println(countEven(1));
    }


}
