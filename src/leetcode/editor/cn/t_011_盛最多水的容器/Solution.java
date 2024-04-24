package leetcode.editor.cn.t_011_盛最多水的容器;

//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4950 👎 0

/**
 * 解答成功:
 * 	执行耗时:4 ms,击败了59.99% 的Java用户
 * 	内存消耗:56.7 MB,击败了39.18% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int i = 0, j = height.length - 1;

        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j - i));
            if (height[i] > height[j]) {
                j-- ;
            } else {
                i++;
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
