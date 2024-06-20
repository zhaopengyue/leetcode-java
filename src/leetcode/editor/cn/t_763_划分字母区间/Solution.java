package leetcode.editor.cn.t_763_划分字母区间;

//给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。 
//
// 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。 
//
// 返回一个表示每个字符串片段的长度的列表。 
//
// 
//示例 1：
//
// 
//输入：s = "ababcbacadefegdehijhklij"
//输出：[9,7,8]
//解释：
//划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
//每个字母最多出现在一个片段中。
//像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。 
//
// 示例 2： 
//
// 
//输入：s = "eccbbbbdec"
//输出：[10]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 贪心 哈希表 双指针 字符串 👍 1140 👎 0

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, int[]> index = new HashMap<>();

        // 标记每个字符的开始位置和结束位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (index.containsKey(c)) {
                index.get(c)[1] = i;
            } else {
                index.put(c, new int[] {i, i});
            }
        }

        List<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int cLeft = index.get(c)[0];
            int cRight = index.get(c)[1];
            if (cLeft > right) {
                // 新开一个窗口,将当前结果添加到结果集中
                res.add(right - left + 1);
                right = cRight;
                left = cLeft;
            } else if (cRight > right) {
                right = cRight; // 扩充右边界
            }
        }
        res.add(right - left + 1); // 最后一组边界

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
