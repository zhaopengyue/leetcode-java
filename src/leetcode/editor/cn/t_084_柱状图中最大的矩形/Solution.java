package leetcode.editor.cn.t_084_柱状图中最大的矩形;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
////输入：heights = [2,1,5,6,2,3]
// //输出：10
// //解释：最大的矩形为图中红色区域，面积为 10
// //
// //
// // 示例 2：
// //
// //
// //
// //
// 
//
// 

//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
//
// Related Topics 栈 数组 单调栈 👍 2724 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:32 ms,击败了41.20% 的Java用户
 * 	内存消耗:53.8 MB,击败了96.59% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {

        int len = heights.length;
        LinkedList<Integer> leftStack = new LinkedList<>();
        LinkedList<Integer> rightStack = new LinkedList<>();
        int[] left = new int[len], right = new int[len];

        // 获取每个元素左边比起小的第一个元素下标
        for (int i = 0; i < len; i++) {
            int lHeight = heights[i];
            int rHeight = heights[len - i - 1];
            while (! leftStack.isEmpty() && heights[leftStack.peek()] >= lHeight) {
                leftStack.pop();
            }
            while (! rightStack.isEmpty() && heights[rightStack.peek()] >= rHeight) {
                rightStack.pop();
            }
            int lIndex = -1, rIndex = len;
            if (! leftStack.isEmpty()) {
                lIndex = leftStack.peek();
            }
            if (! rightStack.isEmpty()) {
                rIndex = rightStack.peek();
            }
            left[i] = lIndex;
            right[len - i - 1] = rIndex;
            // 存入当前元素
            leftStack.push(i);
            rightStack.push(len - i - 1);
        }

        // 计算每个元素对应的最大矩形
        int res = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            int l = left[i];
            int r = right[i];
            res = Math.max(res, heights[i] * (r - l - 1)); // 面积 =(右边界 - 左边界 - 1) * 高
        }

        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
