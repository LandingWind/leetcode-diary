class Solution {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int dp[]=new int[amount+1];
        dp[0]=0;
        for(int i=1;i<=amount;i++) {
            int min=Integer.MAX_VALUE;
            for(int coin:coins) {
                if(i-coin<0) continue;
                if(dp[i-coin]==-1) continue;
                min=Math.min(min, dp[i-coin]+1);
            }
            if(min==Integer.MAX_VALUE) dp[i]=-1;
            else dp[i]=min;
        }
        return dp[amount];
    }
}