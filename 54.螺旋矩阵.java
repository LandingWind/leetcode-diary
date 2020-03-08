import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=54 lang=java
 *
 * [54] 螺旋矩阵
 *
 * https://leetcode-cn.com/problems/spiral-matrix/description/
 *
 * algorithms
 * Medium (38.89%)
 * Likes:    312
 * Dislikes: 0
 * Total Accepted:    43.8K
 * Total Submissions: 112.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * 示例 1:
 * 
 * 输入:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 
 * 
 * 示例 2:
 * 
 * 输入:
 * [
 * ⁠ [1, 2, 3, 4],
 * ⁠ [5, 6, 7, 8],
 * ⁠ [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * 
 * 
 */

// @lc code=start
class Solution {
    int top;
    int bottom;
    int left;
    int right;
    public boolean check(int x, int y) {
        // System.out.println("("+x+","+y+"): "+top+" "+bottom+" "+left+" "+right+" ");
        if(x>=top && x<=bottom && y>=left && y<=right) return true;
        else return false;
    }
    public void update(int direction) {
        if(direction==0) left++;
        else if(direction==1) top++;
        else if(direction==2) right--;
        else bottom--;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int m=matrix.length;
        if(m==0) return res;
        int n=matrix[0].length;
        top=0;
        bottom=m-1;
        left=0;
        right=n-1;
        int posx=0, posy=0;
        int dirs[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        int direction=0;
        while(true) {
            res.add(matrix[posx][posy]);
            if(check(posx+dirs[direction][0], posy+dirs[direction][1])) {
                posx=posx+dirs[direction][0];
                posy=posy+dirs[direction][1];
                continue;
            }else{
                // 转向
                int originalDirection=direction;
                direction=(direction+1)%4;
                boolean flag=false;
                while(direction!=originalDirection){
                    update(direction);
                    // System.out.println("ori: "+originalDirection+" direction: "+direction);
                    if(check(posx+dirs[direction][0], posy+dirs[direction][1])) {
                        posx=posx+dirs[direction][0];
                        posy=posy+dirs[direction][1];
                        flag=true;
                        break;
                    }
                    direction=(direction+1)%4;
                }
                if(!flag) return res;
            }
        }
    }
}
// @lc code=end

