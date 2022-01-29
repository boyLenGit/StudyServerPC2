package meet;

public class m01_01 {
    public static boolean isUnique(String astr) {
        for (int i1=0; i1<astr.length()-1; i1++){
            String debug = astr.substring(i1, i1 + 1);
            if (!astr.contains(astr.substring(i1, i1 + 1))) return false;
        }
        return true;
    }

    public static void main(String[] aa){
        System.out.println(isUnique("leetcode"));
    }
}
