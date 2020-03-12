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
    int max=0;
    public int maxHeight(TreeNode root) {
        if (root==null) return 0;
        int l=maxHeight(root.left);
        int r=maxHeight(root.right);
        this.max=Math.max(max, l+r);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int t=maxHeight(root);
        return max;
    }
}