class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int []res = new int[m];
        for(int i=0;i<m;i++) res[i] = i;
        for(int i=0;i<m-1;i++) {
            for(int j=0;j<m-i-1;j++) {
                int n1=0;
                int n2=0;
                for(int z=0;z<n;z++) {
                    if(mat[j][z]==1) n1++;
                    if(mat[j+1][z]==1) n2++;
                }
                if(n1>n2) {
                    int []copy = mat[j].clone();
                    mat[j]=mat[j+1].clone();
                    mat[j+1]=copy.clone();
                    int t=res[j];
                    res[j]=res[j+1];
                    res[j+1]=t;
                }
            }
        }
        // for(int i=0;i<m;i++) {for(int j=0;j<n;j++) 
        // System.out.print(mat[i][j]);System.out.println();}
       
        return Arrays.copyOf(res,k);
    }
}