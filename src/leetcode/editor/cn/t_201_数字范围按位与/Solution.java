package leetcode.editor.cn.t_201_数字范围按位与;

//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
//
// Related Topics 位运算 👍 507 👎 0

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了100.00% 的Java用户
 * 	内存消耗:42.8 MB,击败了56.08% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // 因为只要有一位为0,那么这个位置就为0, 则该题等价于求区间内数字的二进制形式的最长公共前缀
        // 包含两种方式:
        // 1: 同时右移left和right,当两者相等时,即算出两者的最长公共前缀.然后我们把公共前缀左移到对应的位置,右侧补0,即为按位与的结果
        /*int shift = 0;
        while (left < right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }
        // 左侧到对应位数
        return left << shift;*/
        // 2: 基于Brian Kernighan算法：当num & (num - 1)时, 会将num最右侧的1变为0. 基于该原理,我们可以将right一直与right-1与运算
        // 当新的right <= left时,对应的值即为最长公共前缀对应的数
        while (left < right) {
            right = right & (right - 1);
        }
        return right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
