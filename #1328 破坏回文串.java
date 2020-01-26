class Solution {
    public boolean IsPalindrome1(String A){
        char[] arrayA = A.toCharArray();
        int top = 0;
        int end = arrayA.length-1;
        if(A.equals("") || A.equals(null))    //非法输入
            return false;
        while(top < end){
            if(arrayA[top++] != arrayA[end--])
                return false;
        }
        return true;
    }
    public String breakPalindrome(String palindrome) {
        int len = palindrome.length();
        if(len==1||len==0) return "";
        String resstr = "";
        for(int i=len-1;i>=0;i--) {
            char ch = palindrome.charAt(i);
            // System.out.println(ch);
            char ch2;
            if(ch=='a') ch2='b';
            else ch2='a';
            String newstr = palindrome.substring(0,i)+ch2+palindrome.substring(i+1);
            System.out.println(i+" "+newstr);
            if((resstr.compareTo(newstr)>0 || resstr.equals(""))&& !IsPalindrome1(newstr)) {
                resstr=newstr;
            }
        }
        return resstr;
    }
}