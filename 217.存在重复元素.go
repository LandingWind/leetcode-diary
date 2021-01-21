/*
 * @lc app=leetcode.cn id=217 lang=golang
 *
 * [217] 存在重复元素
 */

// @lc code=start
func containsDuplicate(nums []int) bool {
	m := map[int]bool{}
	for _, num := range nums {
		if _, ok:=m[num]; ok {
			return true
		} else {
			m[num] = true
		}
	}
	return false
}
// @lc code=end

