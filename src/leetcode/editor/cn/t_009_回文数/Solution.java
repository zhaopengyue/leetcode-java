package leetcode.editor.cn.t_009_回文数;

//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 
// 例如，121 是回文，而 123 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
//
// Related Topics 数学 👍 2820 👎 0

/**
 * 解答成功:
 * 	执行耗时:4 ms,击败了100.00% 的Java用户
 * 	内存消耗:42.8 MB,击败了75.93% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        // 逆向计算，也就是将倒数第一位当作第一位使用
        int nx = 0;
        int oldX = x;
        while (oldX != 0) {
            nx = nx * 10 + oldX % 10;
            oldX = oldX / 10;
        }
        return nx == x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
