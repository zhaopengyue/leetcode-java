package leetcode.editor.cn.t_215_数组中的第_k个最大元素;

//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4], k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6], k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 2433 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int index = oneSort(l, r, nums);
            if (index == k - 1) {
                return nums[index];
            } else if (index < k - 1) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return 0;
    }

    private int oneSort(int l, int r, int[] nums) {
        int flag = nums[r], i = l, j = l;
        while (j <= r - 1) {
            if (nums[j] > flag) {
                swap(nums, i, j);
                i++;
            }
            j++;
        }
        swap(nums, i, r);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
