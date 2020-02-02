/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int INT_MAX = 1<<31-1;
    public boolean judge(ListNode[] items) {
        boolean flag=false;
        for(ListNode i:items) {
            if(i!=null) {
                return true;
            }
        }
        System.out.println("flag:"+flag);
        return flag;
    }
    public int choose(ListNode[] items,int len) {
        int min = INT_MAX;
        int minI = -1;
        for(int i=0;i<len;i++) {
            ListNode item = items[i];
            if(item!=null) {
                if(item.val < min) {
                    min = item.val;
                    minI = i;
                }
            }
        }
        System.out.println("minI:"+minI);
        System.out.println("minV:"+min);
        if(minI!=-1){
            return minI;
        }
        return -1;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newList = new ListNode(0);
        ListNode item = newList;

        int len = lists.length;
        ListNode[] items = new ListNode[len];
        for(int i=0;i<len;i++) {
            items[i] = lists[i];
        }
        while(judge(items)) {
            int cs = choose(items,len);
            if(cs==-1) break;
            item.next = items[cs];
            items[cs] = items[cs].next;
            item = item.next;
        }

        return newList.next;
    }
}