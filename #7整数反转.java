package integer_reverse;

import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    int max = 2147483647;
    int min = -2147483648;
    public static void main(String[] args) {
        Main obj = new Main();
        int x = obj.in.nextInt();
        int res = obj.reverse(x);
        System.out.println(res);
    }
    public int reverse(int x) {
        if(x==min) return 0;
        boolean flag;
        if(x==0) return 0;
        if(x>0) flag = true;
        else flag = false;
        int x2 = Math.abs(x);
        String xStr = String.valueOf(x2);

        StringBuffer buf = new StringBuffer();
        int slen = xStr.length();
        for(int i=slen-1;i>=0;i--) {
            if(i==slen-1 && xStr.charAt(i)=='0') continue;
            buf.append(xStr.charAt(i));
        }
        long res = Long.valueOf(buf.toString());
        if(!flag) res = -res;
        if(res>max || res<min) return 0;

        return (int)res;
    }
}
