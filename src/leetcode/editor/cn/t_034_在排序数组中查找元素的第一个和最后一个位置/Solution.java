package leetcode.editor.cn.t_034_在排序数组中查找元素的第一个和最后一个位置;

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2648 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:44.8 MB,击败了66.34% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // step1: 从0~nums.length寻找元素第一次出现的位置
        int l = 0, r = nums.length - 1;
        int[] rs = new int[]{-1, -1};

        while (l <= r) {
            int m = (l + r) >> 1;
            int mv = nums[m];
            if (mv == target) {
                if (m == 0 || nums[m - 1] != target) {
                    rs[0] = m;
                    break;
                }
                // 第一次出现的位置还在做左边
                r = m - 1;
            } else if (mv > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        if (rs[0] == -1) return rs;

        // 若找到第一个, 则从index -> nums.length-1寻找最后一个
        l = rs[0];
        r = nums.length - 1;
        while (l <= r) {
            int m = (l + r) >> 1;
            int mv = nums[m];
            if (mv == target) {
                if (m == nums.length - 1 || nums[m + 1] != target) {
                    rs[1] = m;
                    break;
                }
                // 一定还在右边
                l = m + 1;
            } else {
                r = m - 1; // 此时mv一定>=target
            }
        }

        return rs;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
