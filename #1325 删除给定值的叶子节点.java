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
    public TreeNode findandremove(TreeNode r, int target) {
        if(r.left!=null || r.right!=null) {
            // not leaf node
            if(r.left!=null) {
                r.left = findandremove(r.left, target);
            }
            if(r.right!=null) {
                r.right = findandremove(r.right, target);
            }
            if(r.left==null && r.right==null) {
                // r become a leaf node
                if(r.val==target){
                    return null;
                }
            }
            return r;
        } 
        // leaf node
        if(r.val == target) {
            return null;
        } else {
            return r;
        }
    }
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return findandremove(root, target);
    }
}