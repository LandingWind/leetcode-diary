class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int len=manager.length;
        int count=0;
        Queue<ArrayList<Integer>> q= new LinkedList<>();
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        // HashSet<Integer> formed= new HashSet<>();
        for(int i=0;i<len;i++) {
            if(manager[i]==-1) continue;
            if(hm.get(manager[i])==null) hm.put(manager[i], new HashSet());
            hm.get(manager[i]).add(i);
        }
        // System.out.println(hm);
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        al.add(headID);
        q.offer(al);
        // formed.add(headID);
        while(!q.isEmpty()) {
            ArrayList<Integer> cur=q.poll();
            int curl=cur.size();
            count=Math.max(count, cur.get(0));
            for(int i=1;i<cur.size();i++){
                int x=cur.get(i);
                if(hm.get(x)==null) continue;
                HashSet<Integer> temp=hm.get(x);
                ArrayList<Integer> newal = new ArrayList<Integer>();
                newal.add(cur.get(0)+informTime[x]);
                for(int next:temp) {
                    newal.add(next);
                }
                q.offer(newal);
            }
        }
        
        
        
        return count;
    }
}