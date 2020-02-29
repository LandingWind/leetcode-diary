class Solution {
    public double myPow(double x, int n) {
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        // if(n>0) {
            if(n%2==0) {
                double t = myPow(x, n/2);
                return t*t;
            } else {
                int d;
                if(n>0) d=n-1;
                else d=n+1;
                double t = myPow(x, d/2);
                if(n>0) return t*t*x;
                else return t*t*(1/x);
            }
        // }
    }
}