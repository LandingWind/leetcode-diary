class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        if(x==0) return true;
        ArrayList<Integer> al = new ArrayList<>();
        while(x!=0) {
            al.add(x%10);
            x=x/10;
        }
        int len = al.size();
        int pos1 = 0;
        int pos2 = len-1;
        while(pos1<pos2) {
            if(al.get(pos1) != al.get(pos2)) return false;
            pos1++;
            pos2--;
        }
        return true;
    }
}