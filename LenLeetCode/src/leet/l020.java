package leet;

import java.util.ArrayList;
import java.util.Arrays;

public class l020 {
    // ! 执行错误
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
        if (s.length()%2!=0) return false;
        char[] chars = s.toCharArray();
        ArrayList<Character> inputs = new ArrayList<Character>();
        for (char char_single: chars){
            inputs.add(char_single);
        }
        char compare = ' ';
        int isTrue = 0;
        for (int i1=0; i1<inputs.size(); i1++){
            if (inputs.get(i1).equals('[') | inputs.get(i1).equals('{') | inputs.get(i1).equals('(')){
                if (inputs.get(i1).equals('[')) compare = ']';
                else if (inputs.get(i1).equals('{')) compare = '}';
                else if (inputs.get(i1).equals('(')) compare = ')';
                for (int i2=i1+1; i2<inputs.size(); i2++){
                    if (inputs.get(i2).equals(compare)){
                        if (((i2-i1)%2==0 & i2-i1!=0)) return false;
                        inputs.remove(i1);
                        i1--;
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
            }else return false;
        }
        return true;
    }

    public static boolean isValid_len3(String s){
        for ( ; ; ){
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
            if (!s.contains("{}") & !s.contains("[]") & !s.contains("()")) break;;
        }
        return s.length()==0;
    }

    public static void main(String[] args){
        System.out.println(isValid_len3("(([]){})"));
    }
}

// {}{}
// 0123
// "){"
// "[[[]"
// "(}{)"
// "()[]{}"
// "([)]"
//  0123
//  "([}}])"
//  "(([]){})"