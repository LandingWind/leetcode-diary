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
    public int aaa(TreeNode root, int d) {
        if(root==null) return d;
        return Math.max(aaa(root.left, d+1), aaa(root.right, d+1));
    }
    public int maxDepth(TreeNode root) {
        return aaa(root, 0);
    }
}