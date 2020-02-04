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
    public boolean aaa(TreeNode root, long max, long min) {
        if(root==null) return true;
        if(root.val >= max || root.val <= min) return false;
        return aaa(root.left, root.val, min) && aaa(root.right, max, root.val);
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return true;
        long a = Long.MAX_VALUE;
        long b = Long.MIN_VALUE;
        return aaa(root, a, b);
    }
}