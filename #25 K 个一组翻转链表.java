/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode t=null;
        ListNode ts[] = new ListNode[k];
        // special condition
        if(head==null) return head;
        for(ts[0]=head;;){
            for(int i=1;i<k;i++) {
                ts[i] = ts[i-1].next;
                if(ts[i]==null) return head;
            }
            if(ts[0]==head) {
                // head condition
                ts[0].next = ts[k-1].next;
                for(int i=k-1;i>0;i--) {
                    ts[i].next = ts[i-1];
                }
                head = ts[k-1];
            } else {
                t.next = ts[k-1];
                ts[0].next = ts[k-1].next;
                for(int i=k-1;i>0;i--) {
                    ts[i].next = ts[i-1];
                }
            }
            t = ts[0];
            ts[0] = t.next;
            if(ts[0]==null) break;
        }
        return head;
    }
}