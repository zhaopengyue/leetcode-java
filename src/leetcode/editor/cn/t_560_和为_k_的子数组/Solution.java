package leetcode.editor.cn.t_560_和为_k_的子数组;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 子数组是数组中元素的连续非空序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 2330 👎 0
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int preSum = 0;

       map.put(0, 1);
        for (int num : nums) {
            if (map.containsKey(preSum + num - k)) {
                res += map.get(preSum + num - k);
            }
            map.put(preSum + num, map.getOrDefault(preSum + num, 0) + 1);
            preSum += num;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
