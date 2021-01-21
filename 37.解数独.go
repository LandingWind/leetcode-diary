/*
 * @lc app=leetcode.cn id=37 lang=golang
 *
 * [37] 解数独
 */

// @lc code=start

// default false
var mm = map[int]byte{
	1: '1',
	2: '2',
	3: '3',
	4: '4',
	5: '5',
	6: '6',
	7: '7',
	8: '8',
	9: '9',
}

type ctx struct {
	step  int
	total int
	board [][]byte
	rowt  [9][9]bool
	colt  [9][9]bool
	gridt [9][9]bool
	flag  bool
}

func (c *ctx) findOne() (int, int) {
	for i := range c.board {
		for j := range c.board[i] {
			if c.board[i][j] == '.' {
				return i, j
			}
		}
	}
	return -1, -1
}
func (c *ctx) dfs() {
	if c.flag {
		return
	}
	if c.step == c.total {
		// success
		c.flag = true
		return
	}
	curi, curj := c.findOne()
	if curi == -1 || curj == -1 {
		return
	}
	// range 1-9
	for t := 1; t <= 9; t++ {
		gridN := curi/3*3 + curj/3
		if c.rowt[curi][t-1] || c.colt[curj][t-1] || c.gridt[gridN][t-1] {
			continue
		}
		// mark and dfs
		c.rowt[curi][t-1] = true
		c.colt[curj][t-1] = true
		c.gridt[gridN][t-1] = true
		c.board[curi][curj] = mm[t]
		c.step++
		c.dfs()
		c.step--
		if c.flag {
			return
		}
		// bt
		c.rowt[curi][t-1] = false
		c.colt[curj][t-1] = false
		c.gridt[gridN][t-1] = false
		c.board[curi][curj] = '.'
	}
}
func solveSudoku(board [][]byte) {
	rowt := [9][9]bool{}
	colt := [9][9]bool{}
	gridt := [9][9]bool{}
	flag := false
	// cal rest steps
	t := 0 // t is cur steps
	for i := range board {
		for j := range board[i] {
			if board[i][j] == '.' {
				t++
			} else {
				num := int(board[i][j]) - 48
				rowt[i][num-1] = true
				colt[j][num-1] = true
				gridN := i/3*3 + j/3
				gridt[gridN][num-1] = true
			}
		}
	}
	myctx := &ctx{
		step:  0,
		total: t,
		board: board,
		rowt:  rowt,
		colt:  colt,
		gridt: gridt,
		flag:  flag,
	}
	// fmt.Println(myctx)
	myctx.dfs()
}
// @lc code=end

