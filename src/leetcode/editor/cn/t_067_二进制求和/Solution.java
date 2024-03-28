package leetcode.editor.cn.t_067_二进制求和;

//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。 
//
// 
//
// 示例 1： 
//
// 
//输入:a = "11", b = "1"
//输出："100" 
//
// 示例 2： 
//
// 
//输入：a = "1010", b = "1011"
//输出："10101" 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length <= 10⁴ 
// a 和 b 仅由字符 '0' 或 '1' 组成 
// 字符串如果不是 "0" ，就不含前导零 
// 
//
// Related Topics 位运算 数学 字符串 模拟 👍 1180 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了99.55% 的Java用户
 * 	内存消耗:41.3 MB,击败了58.97% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length()) + 1;
        char[] res = new char[maxLen];

        int i = 1;
        int carry = 0, ac = 0, bc = 0;
        while (i <= maxLen) {

            ac = i <= a.length() ? a.charAt(a.length() - i) - 48 : 0;
            bc = i <= b.length() ? b.charAt(b.length() - i) - 48 : 0;
            res[maxLen - i] = (char)((carry ^ ac ^ bc) + 48);
            // 存在两个及以上1时, 下一个
            carry = carry + ac + bc > 1 ? 1 : 0;

            i++;
        }

        return res[0] == '0' ? String.valueOf(res, 1, res.length - 1) : String.valueOf(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
