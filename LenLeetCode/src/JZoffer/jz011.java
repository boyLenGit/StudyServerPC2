package JZoffer;

public class jz011 {
    public int minArray(int[] numbers) {
        if (numbers.length==1) return numbers[0];
        int res=numbers[0];
        for (int number: numbers){
            res = Math.min(number, res);
        }
        return res;
    }

    public int minArray2(int[] numbers) {
        // 利用数组的升序特点,用二分法,降低时间
        if (numbers.length==1) return numbers[0];
        for (int i1=1; i1<numbers.length; i1++){
            if (numbers[i1-1]>numbers[i1]) return numbers[i1];
        }
        return numbers[0];
    }
}
