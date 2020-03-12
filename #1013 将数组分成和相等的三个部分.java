class Solution {
    public int sum(int []A, int start, int end) {
        int s=0;
        for(int i=start;i<=end;i++) s=s+A[i];
        return s; 
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int len=A.length;
        int total = sum(A,0,len-1);
        // System.out.println(total);
        if(len<2) return false;
        int s1=0;
        for(int i=0;i<len-2;i++) {
            s1=s1+A[i];
            if(3*s1 != total) continue;
            int s2=0;
            // System.out.println(i);
            for(int j=i+1;j<len-1;j++) {
                s2=s2+A[j];
                if(3*s2 == total) return true;
            }
        }
        return false;
    }
}