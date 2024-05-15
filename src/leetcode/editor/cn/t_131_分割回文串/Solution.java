package leetcode.editor.cn.t_131_分割回文串;

//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 1784 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:9 ms,击败了51.18% 的Java用户
 * 	内存消耗:55.8 MB,击败了34.36% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> partition(String s) {
        boolean[][] status = getStatus(s);
        List<List<String>> res = new LinkedList<>();

        f(0, s, s.length(), status, new LinkedList<>(), res);

        return res;
    }

    private void f(int pos, String s, int len, boolean[][] status, LinkedList<String> curr, List<List<String>> res) {
        if (pos == len) {
            res.add(new ArrayList<>(curr));
            return;
        }
        // 从pos开始计算每个子串是否可以作为回文串
        for (int i = pos; i < len; i++) {
            if (status[pos][i]) {
                curr.addLast(s.substring(pos, i + 1));
                f(i + 1, s, len, status, curr, res);
                curr.removeLast();
            }
        }
    }

    private boolean[][] getStatus(String s) {
        // 获取s的状态数组
        int len = s.length();
        boolean[][] status = new boolean[len][len];
        status[0][0] = true;
        for (int i = 1; i < len; i++) {
            status[i][i] = true;
            status[i-1][i] = s.charAt(i) == s.charAt(i - 1);
        }
        // 从右下角开始计算
        for (int i = len - 3; i >= 0 ; i--) {
            for (int j = i + 2; j < len; j++) {
                status[i][j] = status[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        }
        return status;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
