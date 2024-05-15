package leetcode.editor.cn.t_394_字符串解码;

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 
//输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 
//输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 
//输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 30 
// 
// s 由小写英文字母、数字和方括号
// '[]' 组成 
// s 保证是一个 有效 的输入。 
// s 中所有整数的取值范围为
// [1, 300] 
// 
//
// Related Topics 栈 递归 字符串 👍 1755 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:6 ms,击败了12.40% 的Java用户
 * 	内存消耗:41 MB,击败了6.46% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        Deque<String> numStack = new LinkedList<>();
        Deque<String> strStack = new LinkedList<>();

        // 初始添加一个空字符, 最终结果写入该节点
        strStack.push("");
        StringBuilder numBuilder = new StringBuilder();

        String format = String.format("1[%s]", s);
        for (int i = 0; i < format.length(); i++) {
            char c = format.charAt(i);
            if (c >= '0' && c <= '9') {
                numBuilder.append(c);
            } else if (c >= 'a' && c <= 'z') {
                // 字母
                strStack.push(strStack.pop() + c);
            } else if (c == '[') {
                numStack.push(numBuilder.toString());
                numBuilder.setLength(0);
                strStack.push(""); // 插入一个空串, 将左括号内的元素合并到该字符串中
            } else {
                int num = Integer.parseInt(numStack.pop());
                String base = strStack.pop();
                strStack.push(strStack.pop() + repeat(base, num));
            }
        }

        return strStack.pop();
    }

    private String repeat(String base, int num) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num; i++) {
            builder.append(base);
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
