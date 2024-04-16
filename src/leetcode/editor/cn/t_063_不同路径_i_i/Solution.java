package leetcode.editor.cn.t_063_不同路径_i_i;

//一个机器人位于一个
// m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。 
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？ 
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。 
//
// 
//
// 示例 1： 
// 
// 
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
// 
//
// 示例 2： 
// 
// 
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] 为 0 或 1 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1226 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:40.5 MB,击败了93.49% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // status[i][j]表示走到[i][j]有几条路, 状态转移方程为
        /*
            status[i][j] = status[i-1][j] + status[i][j-1]
         */
        int rowCnt = obstacleGrid.length;
        int colCnt = obstacleGrid[0].length;
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        // 初始化第一行
        for (int i = 1; i < colCnt; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i-1];
            }

        }
        // 初始化第一列
        for (int i = 1; i < rowCnt; i++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
            } else {
                obstacleGrid[i][0] = obstacleGrid[i-1][0];
            }
        }

        for (int i = 1; i < rowCnt; i++) {
            for (int j = 1; j < colCnt; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
                }
            }
        }

        return obstacleGrid[rowCnt-1][colCnt-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
