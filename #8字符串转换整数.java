package atoi;

import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    int max = 2147483647;
    int min = -2147483648;
    public static void main(String[] args) {
        Main obj = new Main();
        String x = obj.in.nextLine();
        System.out.println("origin:"+x);
        int res = obj.myAtoi(x);
        System.out.println("res:"+res);
    }
    public int myAtoi(String str) {
        int slen = str.length();
        int pos=0;
        int resInt = 0;
        boolean flag = false;
        boolean isValid = false;
        boolean isPositive = true;

        while(pos<slen) {
            char ch = str.charAt(pos);
            if(!flag) {
                // 在检测到有效数字或负号之前
                if(ch==' ') {
                    pos++;
                    continue;
                }
                if(ch=='-') {
                    isPositive = false;
                    flag = true;
                    pos++;
                    continue;
                }
                if(ch=='+') {
                    isPositive = true;
                    flag = true;
                    pos++;
                    continue;
                }
                if(ch>='0' && ch<='9') {
                    flag = true;
                    isValid = true;
                    Long t = (long)resInt*10 + ch-'0';
                    if((t-max)>0 && isPositive) return max;
                    resInt = resInt*10 + ch-'0';
                    pos++;
                    continue;
                }
                isValid=false;
                break;
            } else {
                // 在检测到有效数字或负号之后
                if(ch>='0' && ch<='9') {
                    isValid = true;
                    Long t = (long)resInt*10 + ch-'0';
                    if((t-max)>0 && isPositive) return max;
                    if((t+min)>0 && !isPositive) return min;
                    resInt = resInt*10 + ch-'0';
                    pos++;
                } else {
                    break;
                }
            }
        }
        if(!isValid) return 0;
        if(!isPositive) resInt = -resInt;
        return resInt;
    }
}

