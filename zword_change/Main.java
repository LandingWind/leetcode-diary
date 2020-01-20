package zword_change;

import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Main obj = new Main();
        String str = obj.in.nextLine();
        System.out.println("origin: "+str);
        String str2 = obj.convert(str, 4);
        System.out.println("build: "+str2);
    }
    public String convert(String s, int numRows) {
        int slen = s.length();
        if(numRows==1) return s;
        if(slen==1) return s;
        StringBuffer buf = new StringBuffer();
        int startPos, dis1, dis2, pos;
        for(int i=1;i<=numRows;i++) {
            startPos = i-1;
            dis1 = (numRows-i)*2;
            dis2 = (numRows-1)*2 - dis1;
            pos = startPos;
            if(pos<slen)buf.append(s.charAt(pos));
            else break;
            while(pos<slen) {
                pos = pos+dis1;
                if(pos<slen && dis1>0) buf.append(s.charAt(pos));
                if(pos>=slen) break;
                pos = pos+dis2;
                if(pos<slen && dis2>0) buf.append(s.charAt(pos));
                if(pos>=slen) break;
            }
        }
        return buf.toString();
    }
}
