package leetcode.editor.cn.t_139_单词拆分;

//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。 
//
// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
// 
//
// 示例 2： 
//
// 
//输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
//     注意，你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 
//输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s 和 wordDict[i] 仅由小写英文字母组成 
// wordDict 中的所有字符串 互不相同 
// 
//
// Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2454 👎 0
/**
 * 解答成功:
 * 	执行耗时:5 ms,击败了79.39% 的Java用户
 * 	内存消耗:43.5 MB,击败了51.25% 的Java用户
 */

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // status[i]表示前i个字符(即闭区间[0:i-1], 也就是长度为i)是否已经匹配到word
        boolean[] status = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>(wordDict);
        status[0] = true;

        // i表示计算长度为i的字符
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 判断当前区间[j:i-1]之间的串是否符合需求
                if (set.contains(s.substring(j, i)) && status[j]) {
                    status[i] = true;
                    break;
                }
            }
        }

        return status[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
