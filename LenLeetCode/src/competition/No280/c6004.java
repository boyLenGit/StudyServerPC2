package competition.No280;

public class c6004 {
    public static int countOperations(int num1, int num2) {
        int cnt = 0;
        while (num1!=0 && num2!=0){
            if (num1>=num2) num1 = num1-num2;
            else num2 = num2-num1;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] arg){
        System.out.println(countOperations(2,1));
    }
}
