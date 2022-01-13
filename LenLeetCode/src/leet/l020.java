package leet;

public class l020 {
    public static boolean isValid(String s) {
        if (s.length()%2!=0) return false;
        char[] chars = s.toCharArray();
        int isTrue = 1;
        // "{[]}"情况
        if ((chars[0]=='{' & chars[chars.length-1]=='}') | (chars[0]=='[' & chars[chars.length-1]==']') | (chars[0]=='(' & chars[chars.length-1]==')')){
            for(int i1=(chars.length/2), i2=i1+1; i1>=0 & i2<chars.length; i1--, i2++){
                switch (chars[i1]){
                    case '(':
                        if (chars[i2]!=')') isTrue = 0;
                        continue;
                    case '{':
                        if (chars[i2]!='}') isTrue = 0;
                        continue;
                    case '[':
                        if (chars[i2]!=']') isTrue = 0;
                }
            }
            return isTrue == 1;
        }
        // {}[]()情况
        for(int i1=0, i2=i1+1; i1<chars.length & i2<chars.length; i1++, i2++){
            if (chars[i1]=='(' & chars[i2]!=')'){
                isTrue = 0;
            }else if (chars[i1]=='[' & chars[i2]!=']'){
                isTrue = 0;
            }else if (chars[i1]=='{' & chars[i2]!='}'){
                isTrue = 0;
            }
        }
        return isTrue == 1;
    }

    public static void main(String[] args){
        System.out.println(isValid("){"));
    }
}

// {}{}
// 0123
// "){"