package leetcode.editor.cn.t_221_最大正方形;

//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1651 👎 0

/**
 * 解答成功:
 * 	执行耗时:5 ms,击败了96.23% 的Java用户
 * 	内存消耗:53.7 MB,击败了89.77% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalSquare(char[][] matrix) {
        // 参考自：https://leetcode.cn/problems/maximal-square/solutions/44586/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/?envType=study-plan-v2&envId=top-interview-150
        /*
            status[i][j]表示以matrix[i-1][j-1]为右下角元素的正方形的最大边长. 当前正方形的最大边长等于上侧、左侧、左上正常行中的最小值。按照推送, 递推公式为:
                status[i][j] = {
                    0                                                         // matrix[i-1][j-1] == '0'
                    min(status[i-1][j-1], status[i][j-1], status[i-1][j]) + 1 // matrix[i-1][j-1] == '1'
                }
             为什么status[i][j]代表的是[i-1][j-1]呢，因为依赖于左侧上册和左上，需要加很多if，为了简化代码，我们假设存在-1行和-1列，值皆为0, 此时边无需添加过多if语句

             根据上述思路可以简化状态, 即只需要一个一维数组存储上一行的状态，一个变量存储左上角的值
         */
        // 下述直接基于一维数组描述状态
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[] status = new int[n + 1];
        int northwest = 0;
        int maxSide = 0;

        for (char[] chars : matrix) {
            for (int j = 0; j < n; j++) {
                // 暂存作为新的左上角
                int nextNorthWest = status[j + 1];
                if (chars[j] == '1') {
                    status[j + 1] = Math.min(status[j], Math.min(northwest, status[j + 1])) + 1;
                    maxSide = Math.max(status[j + 1], maxSide);
                } else {
                    status[j + 1] = 0;
                }
                northwest = nextNorthWest;
            }
        }

        return maxSide * maxSide;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
