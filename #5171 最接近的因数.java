class Solution {
    public int[] help(int n) {
        int res[] = new int[2];
        if(n==1) {
            res[0]=1;
            res[1]=2;
            return res;
        }
        int t = (int)(Math.sqrt(n))+1;
        while(t>0) {
            if((n+1)%t==0) {
                res[0]=t;
                res[1]=(n+1)/t;
                break;
            }
            else if((n+2)%t==0) {
                res[0]=t;
                res[1]=(n+2)/t;
                break;
            }
            else t--;
        }
        return res;
    }
    public int[] closestDivisors(int num) {
        int res[];
        res = help(num);
        return res;
    }
}