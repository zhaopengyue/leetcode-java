package leetcode.editor.cn.t_123_买卖股票的最佳时机_i_i_i;

//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 10⁵ 
// 0 <= prices[i] <= 10⁵ 
// 
//
// Related Topics 数组 动态规划 👍 1686 👎 0

/**
 * 解答成功:
 * 	执行耗时:5 ms,击败了62.37% 的Java用户
 * 	内存消耗:53.6 MB,击败了99.95% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        /*
         * status[i][j][k]表示第i天, 其中j表示是否持有股票, 值为0或者1, k表示当前已经持有了几次股票,值为[0,1,2] 则状态转移方程为:
         * 若当天要持有股票, 则可能为前一天持有,今天无操作或者今天新购买的
         * status[i][1][1] = max(
         *      status[i-1][1][1], // 之前已经持有过一次, 当天股票数无变化
         *      status[i-1][0][0] - prices[i] // 之前没有持有过,今天第一次持有
         * )
         * status[i][1][2] = max(
         *      status[i-1][1][2], // 之前已经持有过2次, 当天股票数无变化
         *      status[i-1][0][1] - prices[i] // 之前持有过一次,今天第2次持有
         * )
         * 若当天不持有股票, 则可能昨天不持有, 今天不处理或者今天卖掉了
         * status[i][0][0] = 0 // 从未持有过
         * status[i][0][1] = max(
         *      status[i-1][0][1], // 昨天不持有,今天继续不持有
         *      status[i-1][1][1] + prices[i] // 昨天已经持有,今天卖出去
         * )
         * status[i][0][2] = max(
         *      status[i-1][0][2], // 昨天不持有,今天继续不持有
         *      status[i-1][1][2] + prices[i] // 昨天已经持有,今天卖出去
         * )
         * 初始状态为
         * status[0][0][0] = 0
         * status[0][1][1] = -prices[0]
         * status[0][1][2] = // 无意义
         *
         * 下述简化了状态
         */
        int[] preNoHas = new int[3];
        int[] preHas = new int[3];

        // 初始化状态
        preHas[1] = -prices[0];
        preHas[2] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            int[] nowHas = new int[3];
            int[] nowNoHas = new int[3];

            nowHas[1] = Math.max(preHas[1], preNoHas[0] - prices[i]);
            nowHas[2] = Math.max(preHas[2], preNoHas[1] - prices[i]);

            nowNoHas[1] = Math.max(preNoHas[1], preHas[1] + prices[i]);
            nowNoHas[2] = Math.max(preNoHas[2], preHas[2] + prices[i]);

            preNoHas = nowNoHas;
            preHas = nowHas;
        }

        // 返回最大值
        return Math.max(preNoHas[1], preNoHas[2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
