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
    // medium order method O(N) space
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        TreeNode prenode = new TreeNode(Integer.MIN_VALUE);
        TreeNode first = null;
        TreeNode second = null;
        while(!s.empty() || node!=null) {
            while(node!=null) {
                s.push(node);
                node=node.left;
            }
            node = s.pop();
            // System.out.println("prenode: "+prenode.val);
            // System.out.println("node: "+node.val);
            if(first==null && node.val < prenode.val) {
                first=prenode; 
                // System.out.println("first: "+first.val);
            }
            if(first!=null && node.val < prenode.val) {
                second=node; 
                // System.out.println("second: "+second.val);
                // break;
            }
            prenode = node;
            node = node.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}