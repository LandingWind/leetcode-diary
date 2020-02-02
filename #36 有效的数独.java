class Solution {
    public boolean isValidSudoku(char[][] board) {
        // row
        for(int i=0;i<9;i++) {
            int t[] = new int[10];
            for(int j=0;j<9;j++) {
                char ch = board[i][j];
                if(ch=='.') continue;
                int cc = ch-'0';
                // System.out.println("cc "+cc);
                if(t[cc]==0) t[cc]=1;
                else return false;
            }
        }
        // column
        for(int i=0;i<9;i++) {
            int t[] = new int[10];
            for(int j=0;j<9;j++) {
                char ch = board[j][i];
                if(ch=='.') continue;
                int cc = ch-'0';
                if(t[cc]==0) t[cc]=1;
                else return false;
            }
        }
        // cell
        for(int i=0;i<9;i++) {
            int t[] = new int[10];
            int y=(i*3)%9;
            int x=(i*3)/9*3;
            // System.out.println(x+" "+y);
            for(int j=0;j<9;j++) {
                int y1 = y+j%3;
                int x1 = x+j/3;
                char ch = board[x1][y1];
                if(ch=='.') continue;
                int cc = ch-'0';
                if(t[cc]==0) t[cc]=1;
                else return false;
            }
        }

        return true;
    }
}