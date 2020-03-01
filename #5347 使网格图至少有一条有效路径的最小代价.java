class Solution {
    HashSet<Integer> visit = new HashSet<>(); // 101*i+j add in
    int mygrid[][] = null;
    int m;
    int n;
    int go[][] = {{0,1},{0,-1},{1,0},{-1,0}}; // directions
    
    public void dfs(int i, int j) {
        if(!visit.contains(101*i+j) && i>=0 && i<m && j>=0 && j<n) {
            visit.add(101*i+j);
            int deltaI = go[mygrid[i][j]-1][0];
            int deltaJ = go[mygrid[i][j]-1][1];
            dfs(i+deltaI, j+deltaJ);
        }
    }
    public int minCost(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        if(m==1 && n==1) return 0;
        this.mygrid = grid;
        
        int cost = 0;
        dfs(0,0);
        HashSet<Integer> hs = new HashSet<>();
        while(!visit.contains( (m-1)*101+(n-1) )) {
            cost++;
            hs.clear();
            for(int item:visit) {
                for(int direction[]:go) {
                    int i = item/101 + direction[0];
                    int j = item%101 + direction[1];
                    hs.add(101*i+j);
                }
            }
            for(int item:hs) dfs(item/101, item%101);
        }
        return cost;
    }
}