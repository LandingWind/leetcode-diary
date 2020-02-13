// dp

import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String p = in.nextLine();
        System.out.println("s: " + s);
        System.out.println("p: " + p);
        Regex regex = new Regex();
        System.out.println("res: " + regex.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        // dp
        // dp[i][j] means: s[:i] can match p[:j]
        int slen = s.length();
        int plen = p.length();
        boolean dp[][] = new boolean[slen+1][plen+1];
        dp[0][0] = true;
        // init dp[0][]
        for(int i=0;i<plen;i++) {
            if(p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }
        // start to dp
        for(int i=0;i<slen;i++) {
            Character s1 = s.charAt(i);
            for(int j=0;j<plen;j++) {
                Character p1 = p.charAt(j);
                if(s1==p1 || p1=='.') dp[i+1][j+1] = dp[i][j];
                else if(p1=='*'){
                    if(p.charAt(j-1)!=s1 && p.charAt(j-1)!='.') dp[i+1][j+1] = dp[i+1][j-1];
                    else dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j] || dp[i+1][j-1]);
                }
            }
        }


        return dp[slen][plen];
    }
}
