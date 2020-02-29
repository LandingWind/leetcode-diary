/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxx=Integer.MIN_VALUE;
    public int help(TreeNode r) {
        if(r==null) return 0;
        int left = Math.max(0,help(r.left));
        int right = Math.max(0,help(r.right));
        maxx = Math.max(maxx, left+r.val+right);
        return r.val+Math.max(left, right);
    }
    public int maxPathSum(TreeNode root) {
        int max=help(root);
        return maxx;
    }
}