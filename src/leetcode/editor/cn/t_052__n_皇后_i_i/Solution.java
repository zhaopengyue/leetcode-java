package leetcode.editor.cn.t_052__n_皇后_i_i;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 513 👎 0


import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:2 ms,击败了64.00% 的Java用户
 * 	内存消耗:39.4 MB,击败了64.03% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        List<String> res = new LinkedList<>();
        // 元素值表示对应的是第i行存储的是第几列
        int[] status = new int[n];

        dfs(0, n, status, res);

        return res.size();
    }

    private void dfs(int i, int n, int[] status, List<String> res) {
        if (i == n) {
            res.add("find");
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, status)) {
                status[i] = j;
                // 可以放, 处理下一层
                dfs(i + 1, n, status, res);
            }
        }
    }

    // 验证当前第i层是否合法
    private boolean isValid(int row, int col, int[] status) {
        if (row == 0) return true; // 第一层怎么放都可以

        for (int i = 0; i < row; i++) {
            if (status[i] == col) return false; // 正下方
            if (col - (row - i) >= 0 && status[i] == col - (row - i)) return false;//左斜
            if (col + (row - i) < status.length && status[i] == col + (row - i)) return false;//右斜
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
