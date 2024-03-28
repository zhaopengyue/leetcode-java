package leetcode.editor.cn.t_191_位1的个数;

//编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中 设置位 的个数（也被称为汉明重量）。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 11
//输出：3
//解释：输入的二进制串 1011 中，共有 3 个设置位。
// 
//
// 示例 2： 
//
// 
//输入：n = 128
//输出：1
//解释：输入的二进制串 10000000 中，共有 1 个设置位。
// 
//
// 示例 3： 
//
// 
//输入：n = 2147483645
//输出：30
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 30 个设置位。 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 如果多次调用这个函数，你将如何优化你的算法？ 
// 
//
// Related Topics 位运算 分治 👍 634 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:39.6 MB,击败了69.62% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hammingWeight(int n) {
        n = n - ((n >>> 1) & 0x55555555);
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        n = (n + (n >>> 4)) & 0x0f0f0f0f;
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
