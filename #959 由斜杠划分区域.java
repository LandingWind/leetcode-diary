
import java.util.Scanner;

public class Slash {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4*N*N);
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                char ch = grid[i].charAt(j);
                System.out.println("char: "+ch);
                int base = (i*N + j)*4;
                // join in a cell
                if(ch == ' ') {
                    dsu.join(base,base+1);
                    dsu.join(base, base+2);
                    dsu.join(base, base+3);
                } else if (ch == '/') {
                    dsu.join(base,base+3);
                    dsu.join(base+1,base+2);
                } else if (ch == '\\') {
                    dsu.join(base,base+1);
                    dsu.join(base+2,base+3);
                } else {
                    System.out.println("input error!");
                    return 0;
                }
                // join with other cells
                if(i > 0) {
                    dsu.join(base, base-4*N+2);
                }
                if(j > 0) {
                    dsu.join(base+3, base-4+1);
                }
            }
        }
        // get res
        int res = 0;
        for (int i = 0; i < 4 * N * N; i++) {
            if (dsu.find(i) == i)
                res++;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Slash a = new Slash();
        int N = in.nextInt();
        in.nextLine();
        String[] grid = new String[N];
        for (int i=0;i<N;i++) {
            String t = in.nextLine();
            System.out.println("input: "+t);
            grid[i] = t;
        }
        int res = a.regionsBySlashes(grid);
        System.out.println("res: "+res);
    }
}

// DSU: Disjoint Set Union
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
        System.out.println("join "+x+" and "+y);
        int rootx = find(x);
        int rooty = find(y);
        if(rootx != rooty) {
            this.parent[rootx] = rooty;
        }
    }
}

