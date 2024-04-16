package leetcode.editor.cn.t_070_爬楼梯;

//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 45 
// 
//
// Related Topics 记忆化搜索 数学 动态规划 👍 3481 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:39.5 MB,击败了5.66% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        // 动态规划方法
        // status[i]表示第i+1阶有status[i]种走法, 因为status[i]只会从i - 1和i - 2两种方式转移过来
        /*
        status[i] = status[i - 1] + status[i - 2]
         */
        // before_1: 前一个
        int before_1 = 2;
        int before_2 = 1;
        int ans = 0;

        for (int i = 2; i < n; i++) {
            ans = before_1 + before_2;
            before_2 = before_1;
            before_1 = ans;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
