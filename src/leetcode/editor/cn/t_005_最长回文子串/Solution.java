package leetcode.editor.cn.t_005_最长回文子串;

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 7138 👎 0

/*
解答成功:
	执行耗时:140 ms,击败了24.21% 的Java用户
	内存消耗:45.2 MB,击败了43.87% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        /*
            定义状态status[i:j]表示闭区间s[i:j]的字符串是否为回文串, 那么状态转移方程为:
            status[i][j] = status[i+1][j-1] && s[i] == s[j]
            初始时初始化本身及其右侧元素的值
         */
        // 初始化二维数组
        boolean[][] status = new boolean[s.length()][s.length()];
        int maxLen = 1;
        // 最长元素索引下标
        int l = 0, r = 0;
        // 初始化
        for (int i = 1; i < s.length(); i++) {
            status[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) {
                status[i-1][i] = true;
                l = i - 1;
                r = i;
                maxLen = 2;
            }
        }

        // 从倒数第三行还是处理
        for (int i = s.length() - 3; i >= 0 ; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && status[i+1][j-1]) {
                    status[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        l = i;
                        r = j;
                    }
                } else {
                    status[i][j] = false;
                }
            }
        }

        return s.substring(l, r + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
