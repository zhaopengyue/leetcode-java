package leetcode.editor.cn.t_078_子集;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 2290 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41.7 MB,击败了63.47% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        f(0, nums, new LinkedList<>(), res);

        return res;
    }

    private void f(int pos, int[] nums, LinkedList<Integer> curr, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // 当前pos有两种选择,即添加或者不添加
        // 不添加
        f(pos + 1, nums, curr, res);
        curr.addLast(nums[pos]);
        f(pos + 1, nums, curr, res);
        curr.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
