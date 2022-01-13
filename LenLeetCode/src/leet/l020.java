package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l020 {
    public static boolean isValid(String s) {
        if (s.length()%2!=0) return false;
        char[] chars = s.toCharArray();
        int isTrue = 1;
        // "{[]}"情况
        if ((chars[0]=='{' & chars[chars.length-1]=='}') | (chars[0]=='[' & chars[chars.length-1]==']') | (chars[0]=='(' & chars[chars.length-1]==')')){
            for(int i1=(chars.length/2)-1, i2=i1+1; i1>=0 & i2<chars.length; i1--, i2++){
                if (chars[i1]=='(' & chars[i2]!=')'){
                    isTrue = 0;
                }else if (chars[i1]=='[' & chars[i2]!=']'){
                    isTrue = 0;
                }else if (chars[i1]=='{' & chars[i2]!='}'){
                    isTrue = 0;
                }else if (chars[i1]==')' | chars[i1]=='}' | chars[i1]==']'){
                    isTrue = 0;
                }
            }
            return isTrue == 1;
        }
        // {}[]()情况
        for(int i1=0, i2=i1+1; i1<chars.length & i2<chars.length; i1=i1+2, i2=i2+2){
            if (chars[i1]=='(' & chars[i2]!=')'){
                isTrue = 0;
            }else if (chars[i1]=='[' & chars[i2]!=']'){
                isTrue = 0;
            }else if (chars[i1]=='{' & chars[i2]!='}'){
                isTrue = 0;
            }else if (chars[i1]==')' | chars[i1]=='}' | chars[i1]==']'){
                isTrue = 0;
            }
        }
        return isTrue == 1;
    }

    public static boolean isValid_len2(String s) {
        char[] chars = s.toCharArray();
        ArrayList<Character> inputs = new ArrayList<Character>();
        for (char char_single: chars){
            inputs.add(char_single);
        }
        char compare = ' ';
        int isTrue = 0;
        for (int i1=0; i1<inputs.size(); i1++){
            if (chars[i1]=='[' | chars[i1]=='{' | chars[i1]=='('){
                if (chars[i1]=='[') compare = ']';
                else if (chars[i1]=='{') compare = '}';
                else if (chars[i1]=='(') compare = ')';
                for (int i2=i1+1; i2<inputs.size(); i2++){
                    if (inputs.get(i2)==compare){
                        inputs.remove(i1);
                        i2--;
                        inputs.remove(i2);
                        isTrue=1;
                        break;
                    }
                }
                if (isTrue==0){
                    return false;
                }
                isTrue = 0;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println(isValid_len2("(}{)"));
    }
}

// {}{}
// 0123
// "){"
// "[[[]"
// "(}{)"