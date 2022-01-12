package leet;

public class l020 {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        for(int i1=(chars.length/2)-1, i2=(chars.length/2); i1>=0; i1--, i2++){
            switch (chars[i1]){
                case '(':
                    if (chars[i2]!=')') return false;
                case '{':
                    if (chars[i2]!='}') return false;
                case '[':
                    if (chars[i2]!=']') return false;
            }
        }
        return true;
    }
}

// {}{}
// 0123