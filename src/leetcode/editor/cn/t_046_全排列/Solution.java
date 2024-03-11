package leetcode.editor.cn.t_046_全排列;

//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2829 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了91.94% 的Java用户
 * 	内存消耗:43.5 MB,击败了38.67% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        process(0, nums, new Integer[nums.length], new int[nums.length], res);

        return res;
    }

    private void process(int pos, int[] nums, Integer[] tmp, int[] flag, List<List<Integer>> res) {
        if (pos == nums.length) {
            res.add(Arrays.asList(Arrays.copyOf(tmp, tmp.length)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] != 1) {
                tmp[pos] = nums[i];
                flag[i] = 1;
                process(pos + 1, nums, tmp, flag, res);
                flag[i] = 0;
            }
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
