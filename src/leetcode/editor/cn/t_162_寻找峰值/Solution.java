package leetcode.editor.cn.t_162_寻找峰值;

//峰值元素是指其值严格大于左右相邻值的元素。 
//
// 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 
//
// 你可以假设 nums[-1] = nums[n] = -∞ 。 
//
// 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1]
//输出：2
//解释：3 是峰值元素，你的函数应该返回其索引 2。 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,1,3,5,6,4]
//输出：1 或 5 
//解释：你的函数可以返回索引 1，其峰值元素为 2；
//     或者返回索引 5， 其峰值元素为 6。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 对于所有有效的 i 都有 nums[i] != nums[i + 1] 
// 
//
// Related Topics 数组 二分查找 👍 1262 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41.5 MB,击败了5.19% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            /*
            此处需要注意题中的nums[-1]为负无穷,也就是说当左侧小于右侧时,因为最后一个元素一定为负无穷，也就说说右侧一定会有峰值，当然左侧
            也可能有, 所以我们往右侧二分
             */
            if (mid != nums.length - 1 && nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else {
                // 当右侧的元素小于左侧时，当前mid可能位于下坡阶段，也可能位于山顶，但其山顶一定位于其及其左侧
                /*
                需要注意的当mid == length - 1的与mid + 1相比较会产生越界错误，但是由于nums[length] = 负无穷,
                所以默认mid = length - 1的时候比它的右边大，从而 right = mid - 1
                 */
                r = mid - 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
