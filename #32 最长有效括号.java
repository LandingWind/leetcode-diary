class Solution {
    public boolean check(String t) {
        int len = t.length();
        if(len==0) return true;
        if(len==1) return false;
        Stack<Character> s = new Stack<>();
        s.push(t.charAt(0));
        for(int i=1;i<t.length();i++) {
            if(s.empty() && t.charAt(i)==')') return false;
            else if(t.charAt(i)=='(') s.push('(');
            else if(t.charAt(i)==')' && s.peek()=='(') s.pop();
        }
        return s.empty();
    }
    // tle method
    /*
    public int longestValidParentheses(String s) {
        // 预处理
        int len = s.length();
        while(len>1 && s.charAt(0) == ')') {
            s=s.substring(1);
            len = s.length();
        }
        len = s.length();
        while(len>1 && s.charAt(len-1)=='(') {
            s=s.substring(0,len-1);
            len = s.length();
        }
        if(len==0 || len==1) return 0;

        // recursion
        if(check(s)) {
            return len;
        } else {
            return Math.max(longestValidParentheses(s.substring(1)),longestValidParentheses(s.substring(0,len-1)));
        }
    }
    */

    // dp method
    /*
    public int longestValidParentheses(String s) {
        // dp[i]: longestValidParentheses end at pos i
        int len = s.length();
        int dp[] = new int[len];
        int res=0;
        for(int i=0;i<len;i++) {
            if(s.charAt(i)=='(') dp[i]=0; // can't end with '('
            else {
                if(i==0) dp[i]=0;
                // condition 1: ...()
                else if(s.charAt(i-1)=='(') {
                    if(i==1) dp[i]=2;
                    else dp[i]=dp[i-2]+2;
                }
                // condition 2: ((...))
                else {
                    if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='(') {
                        dp[i]=dp[i-1]+2;
                        if(i-dp[i-1]-2>=0) dp[i]+=dp[i-dp[i-1]-2];
                    } 
                    else dp[i]=0;
                }
            }
            // System.out.println(dp[i]);
            res=Math.max(res, dp[i]);
        }
        return res;
    }
    */

    // stack method
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res=0;
        int len = s.length();
        st.push(-1);
        for(int i=0;i<len;i++) {
            Character ch = s.charAt(i);
            if(ch=='(') st.push(i);
            else {
                if(st.peek()!=-1 && s.charAt(st.peek())=='(') {
                    st.pop();
                }else st.push(i);
            }
        }
        st.push(len);
        int pre = st.pop();
        while(true) {
            if(st.empty()){
                if(pre==1) pre=0;
                res=Math.max(res, pre);
                break;
            } else {
                res=Math.max(res, pre-st.peek()-1);
                pre=st.pop();
            }
        }
        return res;
    }
}