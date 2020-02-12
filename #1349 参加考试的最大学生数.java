// 很棒的一道状态压缩dp，获益匪浅
// 其中通过异或判断前后行是否冲突很棒

class Solution {
    int n;
    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        this.n=n;
        int types = 1<<n;
        int dp[][] = new int[m][types];
        int res=0;
        for(int i=0;i<m;i++) {
            // n columns 0-2^n-1
            for(int j=0;j<types;j++) {
                if(!judge(seats[i],j) || !judge2(j)) continue;
                int count=number(j);
                if(i==0) dp[i][j] = count;
                else {
                    for(int k=0;k<types;k++) {
                        if(judge2(j|k)) dp[i][j]=Math.max(dp[i][j],dp[i-1][k]+count);
                    }
                }
                // System.out.println(i+","+j+": "+dp[i][j]);
                res=Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
    // 是否和seats相符合
    public boolean judge(char[] row, int j) {
        int count=0;
        int t;
        while(count<n){
            t = j%2; // rightmost
            if(row[n-count-1]=='#' && t==1) return false;
            j = j/2;
            count++;
        }
        return true;
    }
    // 是否有相邻的1 就可以判断所有不合的情况(通过异或)
    public boolean judge2(int j) {
        int pret = 0;
        int count = 0;
        while(count<n){
            int t = j%2; // rightmost
            if(t==1 && pret==1) return false;
            pret = t;
            j = j/2;
            count++;
        }
        return true;
    }
    public int number(int j) {
        int count = 0;
        int res = 0;
        while(count<n){
            int t = j%2;
            if(t==1) res++;
            j = j/2;
            count++;
        }
        return res;
    }
}