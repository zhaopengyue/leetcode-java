package leetcode.editor.cn.t_072_编辑距离;

//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
//
// 
//
// 提示： 
//
// 
// 0 <= word1.length, word2.length <= 500 
// word1 和 word2 由小写英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 3366 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        /*
            定义status[i][j]表示word1[0:i]转化为word2[0:j]所需要的最小编辑距离，则按照状态转移方程: 如下
            status[i][j] = {
                情况1: min(status[i-1][j] + 1, status[i][j-1] + 1, status[i-1][j-1])   // word1[i] == word2[j]
                情况2: min(status[i-1][j] + 1, status[i][j-1] + 1, status[i-1][j-1] + 1) // word1[i] != word2[j]
            }


            初始化时:
                status[0][0] = 0或者为1，取决于两个单词第一个字符是否一致
                status[0][i] = {
                    i // word1[0] == word2[i]
                    status[0][i-1] + 1// word1[0] != word2[i]
                }
         */
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        int[][] status = new int[word1.length()][word2.length()];

        // 初始化
        status[0][0] = word1.charAt(0) == word2.charAt(0) ? 0: 1;
        for (int i = 1; i < word2.length(); i++) {
            status[0][i] = word1.charAt(0) == word2.charAt(i) ? i : status[0][i-1] + 1;
        }
        for (int i = 1; i < word1.length(); i++) {
            status[i][0] = word1.charAt(i) == word2.charAt(0) ? i : status[i-1][0] + 1;
        }

        // 状态转移
        for (int i = 1; i < word1.length(); i++) {
            for (int j = 1; j < word2.length(); j++) {
                int lastV = word1.charAt(i) == word2.charAt(j) ?  status[i-1][j-1] : status[i-1][j-1] + 1;
                status[i][j] = Arrays.stream(new int[]{status[i-1][j] + 1, status[i][j-1] + 1, lastV}).min().getAsInt();
            }
        }

        return status[word1.length()-1][word2.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
