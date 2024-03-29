package leetcode.editor.cn.t_190_颠倒二进制位;

//颠倒给定的 32 位无符号整数的二进制位。 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 00000010100101000001111010011100
//输出：964176192 (00111001011110000010100101000000)
//解释：输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
//
// 示例 2： 
//
// 
//输入：n = 11111111111111111111111111111101
//输出：3221225471 (10111111111111111111111111111111)
//解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
//
// 
//
// 提示： 
//
// 
// 输入是一个长度为 32 的二进制字符串 
// 
//
// 
//
// 进阶: 如果多次调用这个函数，你将如何优化你的算法？ 
//
// Related Topics 位运算 分治 👍 685 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:40.9 MB,击败了30.81% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 基于分治法
        // step1: 分组数为1:交换相邻两个元素(奇偶交换)
        n = n >>> 1 & 0x55555555 | (n & 0x55555555) << 1;
        // step2: 分组数为2: 每隔两个交换一次
        n = n >>> 2 & 0x33333333 | (n & 0x33333333) << 2;
        // step3: 分组数为4: 每隔4个交换一次
        n = n >>> 4 & 0x0f0f0f0f | (n & 0x0f0f0f0f) << 4;
        // step4: 分组数为8, 每隔8个交换一次
        n = n >>> 8 & 0x00ff00ff | (n & 0x00ff00ff) << 8;
        // step5: 分组数为16, 其实就是交换前16个和后16个
        return n >>> 16 | n << 16;
        // step6: 分组数已经为32, 无需处理了, 故分组数最低位16
    }
}
//leetcode submit region end(Prohibit modification and deletion)
