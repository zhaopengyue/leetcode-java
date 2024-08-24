package leetcode.editor.cn.t_169_多数元素;

//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2259 👎 0

import java.util.Arrays;

/**
 * 解答成功:
 * 	执行耗时:2 ms,击败了61.89% 的Java用户
 * 	内存消耗:52 MB,击败了19.72% 的Java用户
 */

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        // 排序+取中位数
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
