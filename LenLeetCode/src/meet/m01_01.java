package meet;

public class m01_01 {
    public static boolean isUnique(String astr) {
        for (int i1=0; i1<astr.length()-1; i1++) if (astr.lastIndexOf(String.valueOf(astr.charAt(i1)))!=i1) return false;
        return true;
    }

    public static void main(String[] aa){
        System.out.println(isUnique("leetcode"));
    }
}
