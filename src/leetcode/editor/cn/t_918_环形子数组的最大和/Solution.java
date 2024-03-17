package leetcode.editor.cn.t_918_环形子数组的最大和;
//给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。 
//
// 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个
//元素是 nums[(i - 1 + n) % n] 。 
//
// 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不
//存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 3 * 10⁴ 
// -3 * 10⁴ <= nums[i] <= 3 * 10⁴ 
// 
//
// Related Topics 队列 数组 分治 动态规划 单调队列 👍 681 👎 0


/**
 * 解答成功:
 * 	执行耗时:6 ms,击败了55.06% 的Java用户
 * 	内存消耗:48.2 MB,击败了8.09% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) return nums[0];

        // preDPMax status[i] = 以i为结尾的最大子数组和
        // preDPMin status[i] = 以i为结尾的最小子数组和（表示存在环,即前缀位于末尾,后缀以i结尾）
        // 此时：环形数组中子数组最大和应该为max(以i皆为的最大子数组和, totalSum - 以i即为的最小子数组和)
        int preDPMax = nums[0];
        int preDPMin = nums[0];
        int max = nums[0];
        int min = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            preDPMax = Math.max(preDPMax + num, num);
            preDPMin = Math.min(preDPMin + num, num);
            max = Math.max(max, preDPMax);
            min = Math.min(min, preDPMin);
            sum += num;
        }

        // 注意: 特殊情况：若max<0,则说明数组中一定没有大于0的元素，此时，最大值应该就是max而不是sum-min，因为此时的sum-min一定为0，即子数组取了全部元素
        if (max < 0) {
            return max;
        } else {
            return Math.max(max, sum - min);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
