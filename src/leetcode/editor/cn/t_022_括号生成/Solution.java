package leetcode.editor.cn.t_022_括号生成;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3530 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41.7 MB,击败了74.62% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.LinkedList;
import java.util.List;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        char[] tmp = new char[n * 2];

        process(0, tmp, 0, 0, res);

        return res;
    }

    private void process(int pos, char[] tmp, int lNum, int rNum, List<String> res) {
        if (pos == tmp.length) {
            res.add(String.valueOf(tmp));
            return;
        }
        // 选择左括号
        if (lNum < tmp.length >> 1) {
            tmp[pos] = '(';
            process(pos + 1, tmp, lNum + 1, rNum, res);
        }
        // 若右括号数小于左括号数
        if (rNum < lNum) {
            tmp[pos] = ')';
            process(pos + 1, tmp, lNum, rNum + 1, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
