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
    long rootsum=0;
    long mul=0;
    public long sum(TreeNode root) {
        long res = root.val;
        if(root.left!=null) res = res + sum(root.left);
        if(root.right!=null) res = res + sum(root.right);
        return res;
    }
    public long aaa(TreeNode node) {
        if(node==null) return 0;
        long t = aaa(node.left) + aaa(node.right) + node.val;
        this.mul = Math.max(this.mul, t*(this.rootsum - t));
        return t;
    }
    public int maxProduct(TreeNode root) {
        this.rootsum = sum(root);
        long tt = aaa(root);
        return (int)(mul % (10e8+7));
    }
}