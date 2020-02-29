class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        int res=0;
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        char chb=' ';
        for(int i=0;i<len;i++) {
            char ch = s.charAt(i);
            res += hm.get(ch);
            if(chb!=' ' && hm.get(ch)>hm.get(chb)) {
                res -= 2*hm.get(chb);
            }
            chb = ch;
        }
        return res;
    }
}