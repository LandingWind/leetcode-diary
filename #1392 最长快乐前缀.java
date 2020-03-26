class Solution {
    public String longestPrefix(String s) {
        int[] dp=new int[s.length()+1];
        dp[0]=-1;
        for(int i=1;i<=s.length();i++){
            char c=s.charAt(i-1);
            int k=dp[i-1];
            while(k>=0&&c!=s.charAt(k)){
                k=dp[k];
            }
            dp[i]=k+1;
        }
        return s.substring(0,dp[s.length()]);
    }
}