/*
 * @lc app=leetcode.cn id=202 lang=golang
 *
 * [202] 快乐数
 */

// @lc code=start
func mul(n int) int {
	s := 0
	for {
		if n != 0 {
			k := n%10
			s += k*k
			n /= 10
		} else {
			break
		}
	}
	return s
}
func isHappy(n int) bool {
	slow, fast := n, mul(n)
	for slow != fast && slow != 1 {
		slow = mul(slow)
		fast = mul(mul(fast))
	}
	return slow == 1
}
// @lc code=end

