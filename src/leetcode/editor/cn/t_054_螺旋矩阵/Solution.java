package leetcode.editor.cn.t_054_螺旋矩阵;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 模拟 👍 1672 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:40.6 MB,击败了43.77% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length, n = matrix[0].length, nums = m * n, top = 0, floor = m - 1, left = 0, right = n - 1;

        List<Integer> rs = new ArrayList<>(nums);

        while (nums > 0) {
            // left -> right
            for (int i = left; i <= right; i++) {
                if (nums > 0) {
                    rs.add(matrix[top][i]);
                    nums--;
                }
            }
            top++;
            for (int i = top; i <= floor; i++) {
                if (nums > 0) {
                    rs.add(matrix[i][right]);
                    nums--;
                }
            }
            right--;
            for (int i = right; i >= left; i--) {
                if (nums > 0) {
                    rs.add(matrix[floor][i]);
                    nums--;
                }
            }
            floor--;
            for (int i = floor; i >= top; i--) {
                if (nums > 0) {
                    rs.add(matrix[i][left]);
                    nums--;
                }
            }
            left++;
        }
        return rs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
