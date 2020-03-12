class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int res=-1;
        if(len==0 || len==1) return 0;
        int cur=prices[0];
        for(int i=1;i<len;i++) {
            if(prices[i]>=cur) {
                res=Math.max(res, prices[i]-cur);
            }else cur=prices[i];
        }
        if(res==-1) return 0;
        return res;
    }
}