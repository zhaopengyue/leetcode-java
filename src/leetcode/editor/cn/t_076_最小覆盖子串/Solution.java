package leetcode.editor.cn.t_076_最小覆盖子串;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
//解释：整个字符串 s 是最小覆盖子串。
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 
//o(m+n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2895 👎 0

/**
 * 解答成功:
 * 	执行耗时:15 ms,击败了63.60% 的Java用户
 * 	内存消耗:44.1 MB,击败了56.69% 的Java用户
 */

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int needNum = t.length();
        Map<Character, Integer> needs = new HashMap<>(t.length());
        // 记录每个char的个数
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, minI = 0, minJ = -1, minSize = Integer.MAX_VALUE;

        while (j < s.length()) {
            char c = s.charAt(j);
            if (needs.containsKey(c)) {
                needs.put(c, needs.get(c) - 1);
                if (needs.get(c) >= 0) needNum--; // 本次为有效
            }
            if (needNum == 0) {
                // 尽可能向右滑动i, 确保为最小范围
                while (i <= j) {
                    char ic = s.charAt(i);
                    if (needs.containsKey(ic)) {
                        if (needs.get(ic) == 0) break; // 删除当前字符会导致缺少字符,不处理当前i
                        needs.put(ic, needs.get(ic) + 1);
                    }
                    i++;
                }
                // 计算当前size
                if (j - i + 1 < minSize) {
                    minI = i;
                    minJ = j;
                    minSize = j - i + 1;
                }
                // 右移i便于计算信息的子串
                needs.put(s.charAt(i), needs.get(s.charAt(i)) + 1);
                needNum++;
                i++;
            }
            j++;
        }
        return s.substring(minI, minJ + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
