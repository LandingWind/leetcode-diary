class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder strb = new StringBuilder();
        String pre="1";
        int count=1;
        while(n>count) {
            count++;
            int t=0;
            char ch=' ';
            char chpre=' ';
            for(int i=0;i<pre.length();i++) {
                ch=pre.charAt(i);
                if(ch!=chpre) {
                    if(t!=0) {
                        strb.append((char)(t+'0'));
                        strb.append(chpre);
                    }
                    t=1;
                    chpre=ch;
                }
                else t++;
            }
            strb.append((char)(t+'0'));
            strb.append(chpre);
            pre=strb.toString();
            strb.delete(0, strb.length());
        }
        return pre;
    }
}