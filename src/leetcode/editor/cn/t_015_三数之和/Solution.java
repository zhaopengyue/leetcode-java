package leetcode.editor.cn.t_015_三数之和;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6840 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:28 ms,击败了88.55% 的Java用户
 * 	内存消耗:50.2 MB,击败了87.62% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        int len = nums.length;
        // 不符合题目要求
        if (nums.length < 3 || nums[0] > 0 || nums[len-1] < 0) return Collections.emptyList();

        List<List<Integer>> res = new ArrayList<>();

        int i = 0, j, k;
        while (i < len - 1 && nums[i] <= 0) {
            if (i == 0 || nums[i] != nums[i-1]) {
                j = i + 1;
                k = len - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        // 重置j和k, 跳过
                        while (j < k && nums[j] == nums[j+1]) {
                            j++;
                        }
                        j++;
                        while (j < k && nums[k] == nums[k-1]) {
                            k--;
                        }
                        k--;
                    }
                }
            }
            i++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
