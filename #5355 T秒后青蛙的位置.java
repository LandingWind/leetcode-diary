class Solution {
    HashMap<Integer, HashSet<Integer>> hm = null;
    ArrayList<Integer> mytrace = null;
    public void dfs(int cur, int target, ArrayList<Integer> trace, HashSet<Integer> hs) {
        if(cur==target) {
            trace.add(target);
            this.mytrace=trace;
            return;
        }
        trace.add(cur);
        hs.add(cur);
        if(hm.get(cur)!=null) {
            HashSet<Integer> x=hm.get(cur);
            for(int next:x) {
                if(hs.contains(next)) continue;
                ArrayList<Integer> newtrace = (ArrayList<Integer>)trace.clone();
                HashSet<Integer> newhs =(HashSet<Integer>)hs.clone();
                dfs(next, target, newtrace,newhs);
            }
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        // if(target==1) return 0;
        HashSet<Integer> visit = new HashSet<>();
        hm = new HashMap<>();
        for(int edge[]:edges) {
            if(hm.get(edge[0])==null) hm.put(edge[0], new HashSet<>());
            hm.get(edge[0]).add(edge[1]);
            if(hm.get(edge[1])==null) hm.put(edge[1], new HashSet<>());
            hm.get(edge[1]).add(edge[0]);
        }
        dfs(1, target, new ArrayList<Integer>(), new HashSet<Integer>());
        System.out.println(hm);
        System.out.println(mytrace);
        if(mytrace==null) return 0;
        if(target==1) 
        if(hm.get(1)!=null && hm.get(1).size()>0) return 0;
        else return 1;
        double res=1;
        int d=0;
        // visit.add(1);
        if(t<mytrace.size()-1) return 0;
        for(int i=0;i<t;i++) {
            int x=mytrace.get(d);
            if(hm.get(x).size()>1) {
                int xlen=x==1?hm.get(x).size():hm.get(x).size()-1;
                if(xlen!=0) res=res/xlen;
            }
            d++;
            // visit.add(x);
            if(d==mytrace.size() && hm.get(x).size()>1) return 0;
            if(d==mytrace.size()) d--;
        }
        return res;
    }
}