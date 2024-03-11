package leetcode.editor.cn.t_017_电话号码的字母组合;

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2774 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:41 MB,击败了59.25% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
class Solution {
    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        ArrayList<List<Character>> keyMap = new ArrayList<>(8);
        // 初始化
        keyMap.add(Arrays.asList('a', 'b', 'c'));
        keyMap.add(Arrays.asList('d', 'e', 'f'));
        keyMap.add(Arrays.asList('g', 'h', 'i'));
        keyMap.add(Arrays.asList('j', 'k', 'l'));
        keyMap.add(Arrays.asList('m', 'n', 'o'));
        keyMap.add(Arrays.asList('p', 'q', 'r', 's'));
        keyMap.add(Arrays.asList('t', 'u', 'v'));
        keyMap.add(Arrays.asList('w', 'x', 'y', 'z'));

        char[] tmp = new char[digits.length()];

        process(0, digits, keyMap, tmp, res);

        return res;
    }

    private void process(int pos, String digits, ArrayList<List<Character>> keyMap, char[] tmp, List<String> res) {
        if (pos == digits.length()) {
            res.add(String.valueOf(tmp));
            return;
        }
        for (char c: keyMap.get(digits.charAt(pos) - '2')) {
            tmp[pos] = c;
            process(pos + 1, digits, keyMap, tmp, res);
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)
