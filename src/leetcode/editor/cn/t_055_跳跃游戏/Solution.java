package leetcode.editor.cn.t_055_跳跃游戏;

//给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2766 👎 0

/**
 * 解答成功:
 * 	执行耗时:2 ms,击败了93.65% 的Java用户
 * 	内存消耗:44.8 MB,击败了6.94% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        // 右边界
        int limit = nums.length - 1;
        int right =  nums[0];
        int i = 1;
        while (i <= right) {
            if (right >= limit) return true;
            int num = nums[i];
            right = Math.max(num + i, right); // 逐步推进右侧边界
            i++;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
