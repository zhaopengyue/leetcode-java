package leetcode.editor.cn.t_035_搜索插入位置;
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 
//
// 请必须使用时间复杂度为 O(log n) 的算法。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,3,5,6], target = 5
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums = [1,3,5,6], target = 2
//输出: 1
// 
//
// 示例 3: 
//
// 
//输入: nums = [1,3,5,6], target = 7
//输出: 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// nums 为 无重复元素 的 升序 排列数组 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 二分查找 👍 2272 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:42 MB,击败了28.18% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int searchInsert(int[] nums, int target) {
        // 等价于寻找第一个大于等于target的元素
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            int num = nums[mid];
            if (num < target) {
                // 值还在右边
                l = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    return mid;
                } else {
                    r = mid - 1;
                }
            }
        }
        // 默认找不到,即所有元素均小于target，此时插入末尾
        return nums.length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
