package leetcode.editor.cn.t_322_零钱兑换;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics 广度优先搜索 数组 动态规划 👍 2791 👎 0

/**
 * 解答成功:
 * 	执行耗时:13 ms,击败了70.48% 的Java用户
 * 	内存消耗:43 MB,击败了92.03% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // status[i] 表示凑成i元最少需要的硬币个数, 根据定义, 状态转移方程为
        // status[i] = Math.min(status[i-m]....) + 1, 其中m为coins中的硬币币值
        int[] status = new int[amount + 1];
        // 初始化
        for (int coin: coins) {
            // 硬币币值需要个数为1
            if (coin <= amount) status[coin] = 1;
        }
        // 从1开始计算到amount
        for (int i = 1; i <= amount; i++) {
            if (status[i] == 0) {
                int minCnt = Integer.MAX_VALUE;
                for (int coin: coins) {
                    int remain = i - coin;
                    if (remain > 0 && status[remain] != -1) {
                        minCnt = Math.min(status[remain] + 1, minCnt);
                    }
                }
                if (minCnt == Integer.MAX_VALUE) minCnt = -1;
                status[i] = minCnt;
            }
        }
        return status[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
