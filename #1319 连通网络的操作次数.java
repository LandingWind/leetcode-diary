class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if(len+1 < n) return -1;
        DSU dsu = new DSU(n);
        for(int i=0;i<len;i++) {
            dsu.join(connections[i][0], connections[i][1]);
        }
        // dsu.print();
        int ans = 0;
        for(int i=0;i<n;i++) {
            if(i == dsu.find(i)) ans++;
        }
        // System.out.println("ans: "+ans);
        return ans-1;
    }
}
class DSU {
    public int parent[];
    public DSU(int n) {
        this.parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }
    public int find(int x) {
        if(x!=parent[x]) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void join(int x, int y) {
        parent[find(x)] = find(y);
    }
    public void print() {
        for(int i=0;i<parent.length;i++) {
            System.out.println(i+": "+parent[i]);
        }
    }
}