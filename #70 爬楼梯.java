class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        if(n==2) return 2;
        int x=1, y=2, t;
        for(int i=3;i<=n;i++) {
            t=x+y;
            x=y;
            y=t;
        }
        return y;
    }
}