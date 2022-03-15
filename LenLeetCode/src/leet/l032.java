package leet;

public class l032 {
    public static int longestValidParentheses(String s) {
        // 思路：设置'('为-1，')'为+1，计算从左向右遍历时的总和sum，如果sum<0则判定为无效括号（此时会出现'('少于')'的情况，例如"(()))"）,如果sum=0表示当前是有小括号，记录一下长度
        char[] chars = s.toCharArray();
        int sum = 0;
        int cnt_temp = 0;
        int cnt = 0;
        for (int i1=0; i1<chars.length; i1++){
            sum = 0;
            cnt_temp = 0;
            if (chars[i1]=='(' & i1+1<chars.length){
                sum++;
                cnt_temp++;
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
                    if (sum==0) cnt = Math.max(cnt, cnt_temp);
                }
                // 如果遍历完毕后，sum不为零，则说明不是有效的最长括号
                if (sum!=0){
                    sum = 0;
                }else {
                    cnt = Math.max(cnt, cnt_temp);
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(longestValidParentheses("(())("));
    }
}
// (()())
// ((())())()
// ((()))()()

// "(())("