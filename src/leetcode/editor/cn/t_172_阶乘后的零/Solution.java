package leetcode.editor.cn.t_172_阶乘后的零;

//给定一个整数 n ，返回 n! 结果中尾随零的数量。 
//
// 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：0
//解释：3! = 6 ，不含尾随 0
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：1
//解释：5! = 120 ，有一个尾随 0
// 
//
// 示例 3： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁴ 
// 
//
// 
//
// 进阶：你可以设计并实现对数时间复杂度的算法来解决此问题吗？ 
//
// Related Topics 数学 👍 821 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:39.7 MB,击败了33.48% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        // 等价于寻找5的倍数的因子有多少个
        // 比如30!中5的倍数的因子有30(1个)、25(2个),20(1个), 15(1个),10(1个),5(1个),也就是说30!的结果中有7个0
        // 而5每隔5个出现一次, 每隔25个出现2次，每隔125出现3次
        // 即出现次数 = n/5 + n/25 + n/125 + .....
        int cnt = 0;
        while (n > 0) {
            // 先计算下n / 5
            cnt += (n / 5);
            // 等价于下一轮计算n/25、n/125等等的个数
            n /= 5;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
