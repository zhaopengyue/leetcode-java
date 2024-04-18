package leetcode.editor.cn.t_188_买卖股票的最佳时机_i_v;

//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1156 👎 0

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了33.64% 的Java用户
 * 	内存消耗:40.7 MB,击败了74.80% 的Java用户
 */

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        // 直接参考123题思路, 将思路中的2替换为k
        int[] preNoHas = new int[k+1];
        int[] preHas = new int[k+1];

        // 初始化
        for (int i = 1; i <= k; i++) {
            preHas[i] = -prices[0];
        }

        // 避免重复申请
        int[] nowHas = new int[k+1];
        int[] nowNoHas = new int[k+1];
        // 计算
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                nowHas[j] = Math.max(preHas[j], preNoHas[j-1] - prices[i]);
                nowNoHas[j] = Math.max(preNoHas[j], preHas[j] + prices[i]);
            }

            preNoHas = nowNoHas;
            preHas = nowHas;
        }

        // 返回最大值
        return Arrays.stream(preNoHas).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
