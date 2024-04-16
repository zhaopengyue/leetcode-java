package leetcode.editor.cn.t_097_交错字符串;

//给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。 
//
// 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串： 
//
// 
// s = s1 + s2 + ... + sn 
// t = t1 + t2 + ... + tm 
// |n - m| <= 1 
// 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ... 
// 
//
// 注意：a + b 意味着字符串 a 和 b 连接。 
//
// 
//
// 示例 1： 
// 
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：s1 = "", s2 = "", s3 = ""
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s1.length, s2.length <= 100 
// 0 <= s3.length <= 200 
// s1、s2、和 s3 都由小写英文字母组成 
// 
//
// 
//
// 进阶：您能否仅使用 O(s2.length) 额外的内存空间来解决它? 
//
// Related Topics 字符串 动态规划 👍 988 👎 0

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了66.22% 的Java用户
 * 	内存消耗:40.8 MB,击败了46.79% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // 参考自: https://leetcode.cn/problems/interleaving-string/solutions/335561/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/?envType=study-plan-v2&envId=top-interview-150
        /*
         * 定义状态status[i][j]表示s1前i个字符和s2前j个字符是否可以交错为s3, 对于上述二维状态数组，则状态转移方程为:
         * status[i][j] = (status[i-1][j] && s3[i - 1 + j] == s1[i-1]) || (status[i][j-1] && s3[i - 1 + j] == s2[i - 1])
         *
         * status[0][0] = true
         */
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] status = new boolean[s1.length() + 1][s2.length() + 1];
        // 初始化为true
        status[0][0] = true;

        // 初始化第0行和第0列
        for (int i = 1; i <= s2.length() && s2.charAt(i - 1) == s3.charAt(i - 1); i++) {
            status[0][i] = true;
        }
        for (int i = 1; i <= s1.length() && s1.charAt(i - 1) == s3.charAt(i - 1); i++) {
            status[i][0] = true;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                status[i][j] = (status[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i - 1 + j))) || (status[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }

        return status[s1.length()][s2.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
