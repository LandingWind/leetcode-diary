/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public boolean check(ListNode h, TreeNode r) {
        if(h==null) return true;
        if(r==null) return false;
        if(h.val!=r.val) return false;
        return check(h.next, r.left) || check(h.next, r.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }
}