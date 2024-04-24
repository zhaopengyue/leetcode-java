package leetcode.editor.cn.t_042_接雨水;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 10⁴ 
// 0 <= height[i] <= 10⁵ 
// 
//
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5139 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:45.6 MB,击败了5.39% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int n = height.length;
        if (n < 3) return 0; // 小于3个柱子接不住雨水

        int leftMax = height[0];
        int rightMax = height[n-1];

        int i = 1, j = n - 2;
        while (i <= j) {
            if (leftMax < rightMax) {
                // 当前元素储水量取决于两侧中的低者与当前元素的关系
                ans += Math.max(0, Math.max(leftMax, height[i]) - height[i]);
                leftMax = Math.max(leftMax, height[i]);
                i++;
            } else {
                ans += Math.max(0, Math.max(rightMax, height[j]) - height[j]);
                rightMax = Math.max(rightMax, height[j]);
                j--;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
