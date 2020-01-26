class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++) {
            // start: i,0
            int x = i;
            int y = 0;
            ArrayList<Integer> dd = new ArrayList<>();
            while(x<m && y<n) {
                dd.add(mat[x++][y++]);
            }
            // System.out.println(x+","+y+":"+dd);
            Collections.sort(dd);
            // System.out.println("sorted:"+dd);
            x=i;
            y=0;
            int index=0;
            while(x<m && y<n) {
                mat[x++][y++]=dd.get(index++);
            }
        }
        for(int i=1;i<n;i++) {
            // start: 0,i
            int x = 0;
            int y = i;
            ArrayList<Integer> dd = new ArrayList<>();
            while(x<m && y<n) {
                dd.add(mat[x++][y++]);
            }
            // System.out.println(x+","+y+":"+dd);
            Collections.sort(dd);
            // System.out.println("sorted:"+dd);
            x=0;
            y=i;
            int index=0;
            while(x<m && y<n) {
                mat[x++][y++]=dd.get(index++);
            }
        }
        return mat;
    }
}