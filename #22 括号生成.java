// a strange dfs solution

import java.util.*;

class test {
    ArrayList<String> listaa = new ArrayList<String>();
    int n;
    public boolean judge(String now) {
        int tt=0;
        int len = now.length();
        for(int i=0;i<len;i++) {
            Character ch = now.charAt(i);
            if(ch=='(') tt++;
            else {
                if(tt==0) return false;
                tt--;
            }
        }
        if(tt==0) return true;
        return false;
    }
    public void dfs(int step, int pop, String now) {
        // get to n times push
        if(step==n) {
            while(pop!=0) {
                pop--;
                now = now+")";
            }
            if(judge(now)) listaa.add(now);
            return;
        }
        // choose to push
        dfs(step+1, pop+1, now+"(");
        // choose to pop
        while(pop!=0) {
            pop--;
            dfs(step, pop,now+")");
        }
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(1, 1,"(");
        return listaa;
    }
    public static void main(String[] args) {
        test abc = new test();
        System.out.println(abc.generateParenthesis(3));

    }
}