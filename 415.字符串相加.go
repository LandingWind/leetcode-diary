/*
 * @lc app=leetcode.cn id=415 lang=golang
 *
 * [415] 字符串相加
 */

// @lc code=start
func addStrings(num1 string, num2 string) string {
	res := []int{}
	len1 := len(num1)
	len2 := len(num2)
	p1 := len1-1
	p2 := len2-1
	up := 0
	for p1>=0 && p2>=0 {
		t := (int(num1[p1]) - int('0')) + (int(num2[p2]) - int('0')) + up
		res = append(res, t%10)
		up = t/10
		p1--
		p2--
	}
	for p1>=0 {
		t := int(num1[p1]) - int('0') + up
		res = append(res, t%10)
		up = t/10
		p1--
	}
	for p2>=0 {
		t := int(num2[p2]) - int('0') + up
		res = append(res, t%10)
		up = t/10
		p2--
	}
	if up != 0 {
		res = append(res, up)
	}
	ret := make([]string, len(res))
    	for i := range res {
        	ret[i] = strconv.Itoa(res[len(res)-i-1])
    	}
	return strings.Join(ret, "")
}
// @lc code=end

