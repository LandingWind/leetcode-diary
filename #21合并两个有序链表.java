/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(0);
        ListNode item = newList;
        ListNode item1 = l1;
        ListNode item2 = l2;
        while(item1!=null && item2!=null) {
            if(item1.val<item2.val) {
                item.next = item1;
                item1 = item1.next;
            } else {
                item.next = item2;
                item2 = item2.next;
            }
            item = item.next;
        }
        if(item1==null) {
            // link2 is not null
            item.next = item2;
        }
        if(item2==null) {
            // link1 is not null
            item.next = item1;
        }
        return newList.next;
    }
}