package leet;

public class l009 {
    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }

        String string = String.valueOf(x);
        char[] chars = string.toCharArray();

        int index_end = chars.length - 1;
        for (int i1=0; i1<chars.length/2; i1++){
            if (chars[i1]!=chars[index_end]){
                return false;
            }
            index_end--;
        }
        return true;
    }
}


// aabb
// 0123