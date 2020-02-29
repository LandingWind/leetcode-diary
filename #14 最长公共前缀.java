class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        StringBuilder strb = new StringBuilder();
        char ch;
        int minLen = strs[0].length();
        for(String str:strs) {
            minLen = Math.min(str.length(), minLen);
        }
        for(int i=0;i<minLen;i++) {
            ch = strs[0].charAt(i);
            for(String str:strs) {
                if(ch != str.charAt(i)) return strb.toString();
            }
            strb.append(ch);
        }
        return strb.toString();
    }
}