class Solution {
    public String rankTeams(String[] votes) {
        int len = votes.length;
        if(len==1) return votes[0];
        int st[][] = new int[26][votes[0].length()+1];
        StringBuilder strb = new StringBuilder();
        for(int i=0;i<26;i++) st[i][0]=i;
        for(String vote:votes) {
            for(int i=0;i<vote.length();i++) {
                char ch = vote.charAt(i);
                st[ch-'A'][i+1]++;
            }
        }
        
        Arrays.sort(st, (st1,st2)->{
            boolean flag=true;
            int t=0;
            for(int i=1;i<=votes[0].length();i++){
                if(st1[i]!=st2[i]) {flag=false;t=i;break;}
            }
            if(flag==true){
                return st1[0]-st2[0];
            }else{
                return st2[t]-st1[t];
            }
        });
        for(int i=0;i<votes[0].length();i++) {
            char ch2=(char)('A'+st[i][0]);
            strb.append(ch2);   
        }
        return strb.toString();
    }
}