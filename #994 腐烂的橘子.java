class Solution {
    public int orangesRotting(int[][] grid) {
        HashSet<Integer> hs = new HashSet<>();
        // 记录坐标 x*10+y
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==2) hs.add(i*10+j);
            }
        }
        int count=0;
        HashSet<Integer> temphs = new HashSet<>();
        HashSet<Integer> rmhs = new HashSet<>();
        while(!hs.isEmpty()) {
            count++;
            temphs.clear();
            rmhs.clear();
            for(int cell:hs) {
                int x=cell/10;
                int y=cell%10;
                boolean flag=false;
                // 更新周边四个格子
                if(x>0 && grid[x-1][y]==1) {
                    flag=true;
                    grid[x-1][y]=2;
                    temphs.add((x-1)*10+y);
                }
                if(x+1<grid.length && grid[x+1][y]==1) {
                    flag=true;
                    grid[x+1][y]=2;
                    temphs.add((x+1)*10+y);
                }
                if(y>0 && grid[x][y-1]==1) {
                    flag=true;
                    grid[x][y-1]=2;
                    temphs.add(x*10+y-1);
                }
                if(y+1<grid[0].length && grid[x][y+1]==1) {
                    flag=true;
                    grid[x][y+1]=2;
                    temphs.add(x*10+y+1);
                }
                if(!flag) rmhs.add(cell);
            }
            for(int item:rmhs) hs.remove(item);
            for(int item:temphs) hs.add(item);
        }
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j]==1) return -1;
            }
        }
        if(count==0) return count;
        else return count-1;
    }
}