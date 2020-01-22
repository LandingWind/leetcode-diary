class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int len = s.length();
        for(int i=0;i<len;i++) {
            Character ch = s.charAt(i);
            if(ch=='('||ch=='['||ch=='{') {
                st.push(ch);
            }else{
                if(st.isEmpty()) return false;
                Character ch2 = st.pop();
                if(ch2=='('&&ch==')' || ch2=='['&&ch==']' || ch2=='{'&&ch=='}') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }
}