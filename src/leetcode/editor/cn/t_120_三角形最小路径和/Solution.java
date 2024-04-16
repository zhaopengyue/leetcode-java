package leetcode.editor.cn.t_120_三角形最小路径和;

//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
//
// Related Topics 数组 动态规划 👍 1324 👎 0
/**
 * 解答成功:
 * 	执行耗时:4 ms,击败了38.68% 的Java用户
 * 	内存消耗:42.2 MB,击败了92.58% 的Java用户
 */

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        /*
            status[i][j]表示从顶点到元素[i,j]的最小值, 状态转移方程为
            status[i][j] = Math.min(status[i][j-1], status[i-1][j-1])转化二来, 对于结果而言,求最后一行最小值即为能达到的最小值
            从上面的转移方程可以看出来,当前行状态仅依赖上一行当前列和前一列的状态,因此可以用一维数组存储, 然后从后向前处赋值即可
         */
        int[] status = new int[triangle.size()];
        // 初始化第一行值
        status[0] = triangle.get(0).get(0);
        int minTotal = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            minTotal = Integer.MAX_VALUE;
            // i表示行号
            for (int j = i; j >= 0; j--) {
                // 计算当前位置状态
                int minV = Integer.MAX_VALUE;
                if (j < i) {
                    minV = Math.min(minV, status[j]);
                }
                if (j > 0) {
                    minV = Math.min(minV, status[j - 1]);
                }
                status[j] = minV + triangle.get(i).get(j);
                minTotal = Math.min(status[j], minTotal);
            }
        }
        return minTotal;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
