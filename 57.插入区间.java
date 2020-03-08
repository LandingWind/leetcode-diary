import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 *
 * https://leetcode-cn.com/problems/insert-interval/description/
 *
 * algorithms
 * Hard (37.08%)
 * Likes:    110
 * Dislikes: 0
 * Total Accepted:    16.6K
 * Total Submissions: 44.9K
 * Testcase Example:  '[[1,3],[6,9]]\n[2,5]'
 *
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 * 
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * 
 * 示例 1:
 * 
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 
 * 
 * 示例 2:
 * 
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 
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
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int d[][] = new int[intervals.length+1][];
        int i;
        for(i=0;i<intervals.length;i++) {
            if(intervals[i][0]<newInterval[0]) {
                d[i]=intervals[i];
            }
            else if(intervals[i][0]>=newInterval[0]) break;
        }
        d[i]=newInterval;
        for(i=i+1;i<d.length;i++) d[i]=intervals[i-1];

        return merge(d);
    }
}
// @lc code=end

