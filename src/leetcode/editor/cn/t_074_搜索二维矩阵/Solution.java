package leetcode.editor.cn.t_074_搜索二维矩阵;
//给你一个满足下述两条属性的 m x n 整数矩阵： 
//
// 
// 每行中的整数从左到右按非严格递增顺序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 904 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41 MB,击败了72.28% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // step1: 从第一列中抽出最后一个小于等于target的索引下标
        int l = 0;
        int r = matrix.length;
        int row = -1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int midV = matrix[mid][0];
            if (midV > target) {
                r = mid - 1;
            } else {
                if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                    row = mid;
                    break;
                } else {
                    l = mid + 1;
                }
            }
        }

        if (row == -1) return false;

        // 在第i行二分查找, 若找不到
        l = 0;
        r = matrix[0].length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int midV = matrix[row][mid];
            if (midV > target) {
                r = mid - 1;
            } else if (midV < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
