package leetcode.editor.cn.t_128_最长连续序列;

//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2067 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:53 ms,击败了34.19% 的Java用户
 * 	内存消耗:56.2 MB,击败了81.98% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        // 构建map, 存储包含当前数字的最长连续序列长度
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;
        for (int num: nums) {
            // 因为修改序列长度时仅修改了边界值, 故需要确保数字不在连续的范围内
            if (! map.containsKey(num)) {
                // 获取左侧节点长度
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int currLen = left + right + 1;
                ans = Math.max(currLen, ans);
                // 更新左右边界及自身的长度
                map.put(num, currLen);
                map.put(num - left, currLen);
                map.put(num + right, currLen);
            }
        }

        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
