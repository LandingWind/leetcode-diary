class Solution {
    public int[] help(int lenmod1, int lenmod2) {
        int res[]=new int[2];
        if(lenmod1==0 && lenmod2==0) return res;
        int t=(lenmod1+lenmod2*2)/3*3;
        for(int i=t;i>=3;i=i-3) {
            for(int j=lenmod1;j>=0;j--) {
                if((i-j)%2==0 && (i-j)/2<=lenmod2) {
                    res[0]=j;
                    res[1]=(i-j)/2;
                    return res;
                }
            }
        }
        return res;
    }
    public String largestMultipleOfThree(int[] digits) {
        ArrayList<Integer> mod0 = new ArrayList<>();
        ArrayList<Integer> mod1 = new ArrayList<>();
        ArrayList<Integer> mod2 = new ArrayList<>();
        int len = digits.length;
        for(int digit:digits) {
            if(digit % 3==0) mod0.add(digit);
            else if(digit%3==1) mod1.add(digit);
            else mod2.add(digit);
        }
        
        Collections.sort(mod1, (first, second)->second-first);
        Collections.sort(mod2, (first, second)->second-first);
        int pos0=0, pos1=0, pos2=0;
        int lenmod0 = mod0.size();
        int lenmod1 = mod1.size();
        int lenmod2 = mod2.size();
        StringBuilder str = new StringBuilder(); 
        int res[] = help(lenmod1,lenmod2);
        // System.out.println(res[0]+" "+res[1]);
        boolean flag=true;
        if(lenmod0==0 && res[0]==0 && res[1]==0) return "";
        else {
            for(int i=0;i<res[0];i++) mod0.add(mod1.get(i));
            for(int i=0;i<res[1];i++) mod0.add(mod2.get(i));
            Collections.sort(mod0, (first, second)->second-first);
            for(int i=0;i<mod0.size();i++) {
                str.append(mod0.get(i));
                if(mod0.get(i)!=0) flag=false;
            }
        }
        if(flag) return "0";
        return str.toString();
    }
}