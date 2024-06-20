package leetcode.editor.cn.t_045_跳跃游戏_i_i;

//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2521 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了99.25% 的Java用户
 * 	内存消耗:44.1 MB,击败了30.33% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int limit = nums.length - 1, i = 1, right = nums[0], res = 1;

        while (right < limit) {
            // 计算本次可以跳的最远距离
            int maxRight = right;
            while (i <= right) {
                maxRight = Math.max(i + nums[i], maxRight);
                i++;
            }
            i = right + 1; //
            right = maxRight;
            res++;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
