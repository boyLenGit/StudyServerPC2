package leet;

public class l032 {
    public static int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        int cnt_temp = 0;
        int cnt = 0;
        for (int i1=0; i1<chars.length; i1++){
            if (chars[i1]=='('){
                sum++;
                for (int i2=i1+1; i2<chars.length; i2++){
                    if (chars[i2]=='(') sum++;
                    else if (chars[i2]==')') {
                        // 如果sum=0了，下一个还是')'，说明后面的就是不对的括号了，停止遍历
                        if (sum==0){
                            cnt = Math.max(cnt, cnt_temp);
                            break;
                        }
                        sum--;
                    }
                    cnt_temp++;
                }
            }else {
                sum = 0;
                cnt_temp = 0;
            }
        }
        return cnt;
    }
}
// (()())
// ((())())()
// ((()))()()