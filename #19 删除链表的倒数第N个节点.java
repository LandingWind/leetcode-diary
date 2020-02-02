/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=0;
        for(ListNode node = head;node!=null;node=node.next){
            len++;
        }
        // System.out.println("len:"+len);
        // 删除头节点
        if(len==n) return head.next; 
        // 其他情况
        int n2 = len-n;
        ListNode item = head;
        for(int i=0;i<n2-1;i++) {
            item = item.next;
        }
        item.next = item.next.next;
        return head;
    }
}