package leetcode.editor.cn.t_041_缺失的第一个正数;
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 请你实现时间复杂度为 
//O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
//解释：范围 [1,2] 中的数字都在数组中。 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
//解释：1 在数组中，但 2 没有。 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
//解释：最小的正数 1 没有出现。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// Related Topics 数组 哈希表 👍 2110 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了98.89% 的Java用户
 * 	内存消耗:56.3 MB,击败了20.64% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        int i = 0;
        while (i < len) {
            if (nums[i] <=0 || nums[i] > len) {
                nums[i] = -1; // 标记为-1
                i++;
            } else {
                // 检测当前元素是否位于其位置上
                if (nums[i] == nums[nums[i]-1]) {
                    // 表示位于正确位置,处理下一个
                    i++;
                } else {
                    // 交换当前元素到其正确位置
                    swap(nums, i, nums[i]-1);
                }
            }
        }
        // 寻找第一个负数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
