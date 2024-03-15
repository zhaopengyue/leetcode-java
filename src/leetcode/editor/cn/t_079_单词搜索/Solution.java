package leetcode.editor.cn.t_079_单词搜索;

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
// 
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
//
// Related Topics 数组 字符串 回溯 矩阵 👍 1786 👎 0

/**
 * 解答成功:
 * 	执行耗时:158 ms,击败了47.98% 的Java用户
 * 	内存消耗:40.5 MB,击败了61.78% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean exist(char[][] board, String word) {

        // 上下左右
        int[][] pos = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        int rowLimit = board.length;
        int colLimit = board[0].length;

        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (process(1, word, i, j, board, pos)) return true;
                }
            }
        }

        return false;
    }

    /**
     * 从x,y出发,判断word.charAt(i)是否可以匹配
     */
    private boolean process(int i, String word, int x, int y, char[][] board, int[][] pos) {
        if (i == word.length()) return true;

        char origin = board[x][y];
        // 标记为访问过
        board[x][y] = '\01';
        boolean isFind = false;
        for (int[] f: pos) {
            int nx = x + f[0];
            int ny = y + f[1];
            int rowLimit = board.length;
            int colLimit = board[0].length;

            if (nx >= 0 && nx < rowLimit
                    && ny >= 0 && ny < colLimit
                    && board[nx][ny] == word.charAt(i)) {
                isFind |= process(i + 1, word, nx, ny, board, pos);
            }
        }
        // 还原
        board[x][y] = origin;
        return isFind;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
