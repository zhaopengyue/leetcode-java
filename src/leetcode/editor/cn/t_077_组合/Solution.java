package leetcode.editor.cn.t_077_组合;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
//
// Related Topics 回溯 👍 1596 👎 0

/**
 * 解答成功:
 * 	执行耗时:23 ms,击败了37.01% 的Java用户
 * 	内存消耗:92.5 MB,击败了20.21% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        process(0, 1, n, k, res, new Integer[k]);
        return res;
    }

    // 第i个元素
    public void process(int i, int currNum, int n, int k, List<List<Integer>> res, Integer[] tmp) {
        if (i == k) {
            res.add(Arrays.asList(Arrays.copyOf(tmp, tmp.length)));
            return;
        }

        while (currNum <= n) {
            tmp[i] = currNum;
            process(i + 1, currNum + 1, n, k, res, tmp);
            currNum++ ;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
