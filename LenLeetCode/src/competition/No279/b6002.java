package competition.No279;

public class b6002 {
    public static void main(String[] ar){
//        Bitset bs = new Bitset(5); // bitset = "00000".
//        bs.fix(3);     // 将 idx = 3 处的值更新为 1 ，此时 bitset = "00010" 。
//        bs.fix(1);     // 将 idx = 1 处的值更新为 1 ，此时 bitset = "01010" 。
//        bs.flip();     // 翻转每一位上的值，此时 bitset = "10101" 。
//        bs.all();      // 返回 False ，bitset 中的值不全为 1 。
//        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "00101" 。
//        bs.flip();     // 翻转每一位上的值，此时 bitset = "11010" 。
//        bs.one();      // 返回 True ，至少存在一位的值为 1 。
//        bs.unfix(0);   // 将 idx = 0 处的值更新为 0 ，此时 bitset = "01010" 。
//        bs.count();    // 返回 2 ，当前有 2 位的值为 1 。
//        bs.toString(); // 返回 "01010" ，即 bitset 的当前组成情况。
        Bitset bs = new Bitset(2);
        bs.flip();
        bs.unfix(1);
        bs.all();
        bs.fix(1);
        bs.fix(1);
        bs.unfix(1);
        bs.all();
        bs.count();
    }
}


class Bitset {
    private StringBuilder sb = new StringBuilder();
    private int countOne = 0;

    public Bitset(int size) {
        for (int i1=0; i1<size; i1++){
            sb.append(0);
        }
    }

    public void fix(int idx) {
        if (sb.charAt(idx)!='1')countOne++;
        sb.setCharAt(idx, '1');
    }

    public void unfix(int idx) {
        sb.setCharAt(idx, '0');
    }

    public void flip() {
        for (int i1=0; i1<sb.length(); i1++){
            if (sb.charAt(i1)=='0') sb.setCharAt(i1, '1');
            else sb.setCharAt(i1, '0');
        }
        countOne = sb.length()-countOne;
    }

    public boolean all() {
        for (int i1=0; i1<sb.length(); i1++){
            if (sb.charAt(i1)=='0') return false;
        }
        return true;
    }

    public boolean one() {
        return sb.indexOf("1")!=-1;
//        for (int i1=0; i1<sb.length(); i1++){
//            if (sb.charAt(i1)=='1') return true;
//        }
//        return false;
    }

    public int count() {
        return countOne;
//        int cnt=0;
//        for (int i1=0; i1<sb.length(); i1++){
//            if (sb.charAt(i1)=='1') cnt++;
//        }
//        return cnt;
    }

    public String toString() {
        return sb.toString();
    }
}
