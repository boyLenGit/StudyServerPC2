package competition.No285;

public class c6028 {
    public int countCollisions(String directions) {
        StringBuilder sb = new StringBuilder(directions);
        int result = 0;
        int cnt_temp;
        for (int i1=1; i1<sb.length(); i1++){
            if (sb.charAt(i1)=='S'){
                if (sb.charAt(i1-1)=='R'){
                    result++;
                }
            }else if (sb.charAt(i1)=='R'){
                cnt_temp = 0;
                if (sb.charAt(i1-1)=='R') cnt_temp++;
                for (int i2=i1+1; i2<sb.length(); i2++){
                    cnt_temp++;
                    if (sb.charAt(i2)=='L'){
                        cnt_temp++;
                        result += cnt_temp;
                        i1=i2;
                        sb.replace(i2,i2+1,"S");
                        break;
                    }else if (sb.charAt(i2)=='S'){
                        result += cnt_temp;
                        i1=i2;
                        sb.replace(i2,i2+1,"S");
                        break;
                    }
                }
            }else if (sb.charAt(i1)=='L'){
                if (sb.charAt(i1-1)=='R'){
                    result=result+2;
                    sb.replace(i1,i1+1,"S");
                }else if (sb.charAt(i1-1)=='S'){
                    result++;
                    sb.replace(i1,i1+1,"S");
                }
            }
        }
        return result;
    }

    public int countCollisions2(String directions) {
        char[] chars = directions.toCharArray();
        int result = 0;
        int cnt_temp;
        for (int i1=1; i1<chars.length; i1++){
            if (chars[i1]=='S'){
                if (chars[i1-1]=='R'){
                    result++;
                }
            }else if (chars[i1]=='R'){
                cnt_temp = 0;
                if (chars[i1-1]=='R') cnt_temp++;
                for (int i2=i1+1; i2<chars.length; i2++){
                    cnt_temp++;
                    if (chars[i2]=='L'){
                        cnt_temp++;
                        result += cnt_temp;
                        i1=i2;
                        chars[i2] = 'S';
                        break;
                    }else if (chars[i2]=='S'){
                        result += cnt_temp;
                        i1=i2;
                        chars[i2] = 'S';
                        break;
                    }
                }
            }else if (chars[i1]=='L'){
                if (chars[i1-1]=='R'){
                    result=result+2;
                    chars[i1] = 'S';
                }else if (chars[i1-1]=='S'){
                    result++;
                    chars[i1] = 'S';
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        c6028 c = new c6028();
        System.out.println(c.countCollisions2("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
// "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"
//    ^  ^^^^ ^^^ ^  ^^^^^^^^
// "RRRSSSLRSR"
//  ^^^   ^ ^