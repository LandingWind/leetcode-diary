/*
 * @lc app=leetcode.cn id=160 lang=golang
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func getIntersectionNode(headA, headB *ListNode) *ListNode {
    if headA == nil || headB == nil {
		return nil
	}
	la := 1
	ta := headA
	for ;ta.Next != nil; ta = ta.Next {
		la++
	}
	lb := 1
	tb := headB
	for ;tb.Next != nil; tb = tb.Next {
		lb++
	}
	if ta != tb {
		return nil
	}
	if la > lb {
		for i:=0;i<la-lb;i++ {
			headA = headA.Next
		}
	}
	if lb > la {
		for i:=0;i<lb-la;i++ {
			headB = headB.Next
		}
	}
	for {
		if headA == headB {
			return headA
		}
		headA = headA.Next
		headB = headB.Next
	}
}
// @lc code=end

