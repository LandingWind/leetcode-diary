// standard dfs solution

import java.util.*;

class test {
    ArrayList<String> listaa = new ArrayList<String>();
    int n;
    public void dfs(int left, int right, String now) {
        // reach the destination
        if(left==n && right==n) {
            listaa.add(now);
            return;
        }
        // cut unnecessary branch
        if(right>left) return;
        // add left
        if(left<n) dfs(left+1, right, now+"(");
        // add right
        if(right<n) dfs(left, right+1, now+")");
    }
    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return listaa;
    }
    public static void main(String[] args) {
        test abc = new test();
        System.out.println(abc.generateParenthesis(3));

    }
}