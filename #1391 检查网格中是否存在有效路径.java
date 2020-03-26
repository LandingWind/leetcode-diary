class Solution {
    public boolean dfs(int[][] grid, int x, int y, int dir) {
        // System.out.println(x+" "+y);  
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]==0) {
            return false;
        }
        int c=grid[x][y];
        if(dir!=0) 
        if((dir==1 && c%2==0) 
            || (dir==2 && (c==1||c==3||c==4))
            || (dir==3 && (c==2||c==3||c==5))
            || (dir==4 && (c==1||c==5||c==6)) 
        ) {
            return false;
        }
        if(x+1==grid.length && y+1==grid[0].length) return true;
        grid[x][y]=0;
        if(c==1) return dfs(grid, x, y+1,1) || dfs(grid, x,y-1,3);
        else if(c==2) return dfs(grid, x+1,y,2)||dfs(grid,x-1,y,4);
        else if(c==3) return dfs(grid,x,y-1,3)||dfs(grid,x+1,y,2);
        else if(c==4) return dfs(grid,x,y+1,1)||dfs(grid,x+1,y,2);
        else if(c==5) return dfs(grid,x,y-1,3)||dfs(grid,x-1,y,4);
        else if(c==6) return dfs(grid,x,y+1,1)||dfs(grid,x-1,y,4);
        grid[x][y]=c;
        return false;
    } 
    public boolean hasValidPath(int[][] grid) {
        return dfs(grid,0,0,0);
    }
}