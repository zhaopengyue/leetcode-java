package leetcode.editor.cn.t_064_最小路径和;

//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 200 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1656 👎 0

/**
 * 解答成功:
 * 	执行耗时:2 ms,击败了95.09% 的Java用户
 * 	内存消耗:44.4 MB,击败了54.96% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        /*
          status[i][j]表示到达[i,j]节点的最小路劲和, 该状态仅会从如下两个状态转化过来, 状态转移方程为
          status[i][j] = Math.min(status[i-1][j], status[i][j-1]) + grid[i][j]
          为节省空间, 这里直接使用原数组存储状态数据, 为减少额外下标判断, 初始化时直接将第一行和第一列初始化完成
         */
        // 初始化第一行
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i-1];
        }
        // 初始化第一列
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i-1][0];
        }
        // 计算后续元素
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
