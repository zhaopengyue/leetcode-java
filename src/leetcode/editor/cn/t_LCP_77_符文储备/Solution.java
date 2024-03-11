package leetcode.editor.cn.t_LCP_77_符文储备;

import java.util.Arrays;

//远征队在出发前需要携带一些「符文」，作为后续的冒险储备。`runes[i]` 表示第 `i` 枚符文的魔力值。
//
//他们将从中选取若干符文进行携带，并对这些符文进行重新排列，以确保任意相邻的两块符文之间的魔力值相差不超过 `1`。
//
//请返回他们能够携带的符文 **最大数量**。
//
//**示例 1：**
//
//> 输入：`runes = [1,3,5,4,1,7]`
//>
//> 输出：`3`
//>
//> 解释：最佳的选择方案为[3,5,4]
//> 将其排列为 [3,4,5] 后，任意相邻的两块符文魔力值均不超过 `1`，携带数量为 `3`
//> 其他满足条件的方案为 [1,1] 和 [7]，数量均小于 3。
//> 因此返回可携带的最大数量 `3`。
//
//**示例 2：**
//
//> 输入：`runes = [1,1,3,3,2,4]`
//>
//> 输出：`6`
//>
//> 解释：排列为 [1,1,2,3,3,4]，可携带所有的符文
//
//**提示：**
//- `1 <= runes.length <= 10^4`
//- `0 <= runes[i] <= 10^4`
//
// 👍 5 👎 0

/**
 * 击败87%
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int runeReserve(int[] runes) {
        if (runes.length <= 1) return runes.length;

        Arrays.sort(runes);
        int maxNum = 1;

        // 记录当前阶段开始pos
        int i = 0;
        int j = 1;
        while (j < runes.length) {
            if (runes[j] - runes[j - 1] > 1) {
                // 重置i, 并计算当前长度
                maxNum = Math.max(j - i, maxNum);
                i = j;
            }
            j++;
        }

        maxNum = Math.max(j - i, maxNum);

        return maxNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
