import java.util.Collections;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=414 lang=java
 *
 * [414] 第三大的数
 *
 * https://leetcode-cn.com/problems/third-maximum-number/description/
 *
 * algorithms
 * Easy (34.44%)
 * Likes:    105
 * Dislikes: 0
 * Total Accepted:    20.5K
 * Total Submissions: 59.6K
 * Testcase Example:  '[3,2,1]'
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 
 * 示例 1:
 * 
 * 
 * 输入: [3, 2, 1]
 * 
 * 输出: 1
 * 
 * 解释: 第三大的数是 1.
 * 
 * 
 * 示例 2:
 * 
 * 
 * 输入: [1, 2]
 * 
 * 输出: 2
 * 
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 
 * 
 * 示例 3:
 * 
 * 
 * 输入: [2, 2, 3, 1]
 * 
 * 输出: 1
 * 
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int thirdMax(int[] nums) {
        int len=nums.length;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0], nums[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(len, Collections.reverseOrder());
        for(int num:nums) {
            pq.offer(num);
        }
        int max=pq.peek();
        int t=3;
        int pre=Integer.MIN_VALUE;
        while(t>0) {
            Integer x=pq.poll();
            if(x==null) break;
            if(x==pre) continue;
            pre=x;
            t--;
        }
        if(t==0) return pre;
        else return max;
        
    }
}
// @lc code=end