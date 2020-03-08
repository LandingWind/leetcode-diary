import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 *
 * https://leetcode-cn.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (40.53%)
 * Likes:    302
 * Dislikes: 0
 * Total Accepted:    57.6K
 * Total Submissions: 142.2K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 
 * 示例 1:
 * 
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 
 * 
 * 示例 2:
 * 
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        HashSet<Integer> ls = new HashSet<>();
        int l=0;
        int r=1;
        int len=intervals.length;
        if(len==0) return new int[0][0];
        if(len==1) return intervals;
        Arrays.sort(intervals,(x,y)->{
            return x[0]-y[0];
        });
        int ref[][]=intervals;
        ls.add(l);
        while(r<len) {
            if(ref[l][0]<=ref[r][0] && ref[r][0]<=ref[l][1]) {
                // 可以合并
                ref[l][1]=Math.max(ref[r][1], ref[l][1]);
                r++;
            }else{
                l=r;
                r++;
                ls.add(l);
            }
        }
        // return process
        int res[][] = new int[ls.size()][];
        int count=0;
        for(int i:ls) res[count++]=intervals[i];
        return res;
    }
}
// @lc code=end

