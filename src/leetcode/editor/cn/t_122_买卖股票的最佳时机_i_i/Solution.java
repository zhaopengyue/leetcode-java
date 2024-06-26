package leetcode.editor.cn.t_122_买卖股票的最佳时机_i_i;

//给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。 
//
// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。 
//
// 返回 你能获得的 最大 利润 。 
//
// 
//
// 示例 1： 
//
// 
//输入：prices = [7,1,5,3,6,4]
//输出：7
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
//     总利润为 4 + 3 = 7 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
//     总利润为 4 。 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 交易无法获得正利润，所以不参与交易可以获得最大利润，最大利润为 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10⁴ 
// 0 <= prices[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2466 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /*
         * status(0)(0) = 0 // 不持有股票，此时现金收益为0
         status(0)(1) = -prices(0) // 第一天持有股票，此时现金收益为-prices(0)
         * 状态转移方程：注：下述前提是股票不能多持，即今天买了股票，那么明天只能卖出或不处理，而不能继续买入
         * 若当天不持有股票，则当天的现金来源有两种可能：a: 昨天不持有股票，今天不处理 b: 昨天持有股票+今天卖出
         * status[i][0] = max(status[i-1][0], status[i-1][1] + prices(i))
         * 若当天持有股票，则当天的现金来源有两种可能：a: 昨天持有股票,今天不处理 b: 昨天不持有股票+今天持有股票
         * status[i][1] = max(status[i-1][1], status[i-1][0] - prices(i))
         *
         * 根据上述思路，状态仅依赖于上一天的状态，故使用两个变量维护即可
         */
        int preHas = -prices[0];
        int preNoHas = 0;

        for (int i = 1; i < prices.length; i++) {
            int nowHas = Math.max(preNoHas - prices[i], preHas);
            int nowNoHas = Math.max(preNoHas, preHas + prices[i]);
            preHas = nowHas;
            preNoHas = nowNoHas;
        }

        // 最后一天一定不持有
        return preNoHas;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
