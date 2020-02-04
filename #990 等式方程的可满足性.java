class Solution {
    public boolean equationsPossible(String[] equations) {
//        HashSet<Character> hs = new HashSet<>();
//        for (String equation : equations) {
//            hs.add(equation.charAt(0));
//            hs.add(equation.charAt(3));
//        }
        DSU dsu = new DSU(26);
//        int len = equations.length;
        for (String equation : equations) {
            if(equation.charAt(1) == '=') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                dsu.join(x, y);
            }
        }
        for (String equation : equations) {
            if(equation.charAt(1) == '!') {
                int x = equation.charAt(0) - 'a';
                int y = equation.charAt(3) - 'a';
                if(dsu.find(x) == dsu.find(y)) return false;
            }
        }
        return true;
    }
}

class DSU {
    public int parent[];
    public DSU(int n) {
        // init parent
        this.parent = new int[n];
        for (int i=0;i<n;i++) this.parent[i] = i;
    }
    public int find(int item) {
        // find root
        int x = item;
        while(x != this.parent[x]) {
            x = this.parent[x];
        }
        // update route
        int y = item;
        int temp;
        while(y != this.parent[y]) {
            temp = this.parent[y];
            this.parent[y] = x;
            y = temp;
        }
        return x;
    }
    public void join(int x, int y) {
        // join two disjoint set
        // System.out.println("join "+x+" and "+y);
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            this.parent[rootx] = rooty;
        }
    }
}