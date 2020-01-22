/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode t1,t2,t=head;
        // special condition
        if(head==null) return head;
        if(head.next==null) return head;
        for(t1=head;;){
            t2 = t1.next;
            if(t1==head) {
                // head condition
                head=t2;
                t1.next = t2.next;
                head.next = t1;
            } else {
                t1.next = t2.next;
                t.next = t2;
                t2.next = t1;
            }
            t = t1;
            if(t1.next==null) break;
            else if(t1.next.next==null) break;
            else {
                t1 = t1.next;
            }
        }
        return head;
    }
}