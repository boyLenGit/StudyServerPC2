package competition.No285;

public class c6027 {
    public int countHillValley(int[] nums) {
        int cnt = 0;
        for (int i1=1; i1<nums.length-1; i1++){
            if (nums[i1-1]<nums[i1] && nums[i1]<nums[i1+1]){ // 极大
                cnt++;
            }else if (nums[i1-1]<nums[i1] && nums[i1]>nums[i1+1]){ // 极小
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        c6027 c = new c6027();
        System.out.println(c.countHillValley(new int[]{2,4,1,1,6,5}));
    }
}
