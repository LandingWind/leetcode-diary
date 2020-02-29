class Solution {
    public String intToRoman(int num) {
        // basic num
        int mm = num/1000;
        num %=1000;
        int dd = num/500;
        num %=500;
        int cc = num/100;
        num %=100;
        int ll = num/50;
        num %=50;
        int xx = num/10;
        num %=10;
        int vv = num/5;
        num %=5;
        int ii = num/1;
        num %=1;
        // process
        StringBuilder strb = new StringBuilder();
        if(mm>0) {
            for(int i=0;i<mm;i++) strb.append('M');
        }
        if(dd==0 && cc==4){
            strb.append("CD");
        } else if(dd==1 && cc == 4) {
            strb.append("CM");
        } else {
            if(dd==1) strb.append('D');
            if(cc>0) {
                for(int i=0;i<cc;i++) strb.append('C');
            }
        }
        if(ll==0 && xx==4){
            strb.append("XL");
        } else if(ll==1 && xx == 4) {
            strb.append("XC");
        } else {
            if(ll==1) strb.append('L');
            if(xx>0) {
                for(int i=0;i<xx;i++) strb.append('X');
            }
        }
        if(vv==0 && ii==4){
            strb.append("IV");
        } else if(vv==1 && ii == 4) {
            strb.append("IX");
        } else {
            if(vv==1) strb.append('V');
            if(ii>0) {
                for(int i=0;i<ii;i++) strb.append('I');
            }
        }
        return strb.toString();
    }
}