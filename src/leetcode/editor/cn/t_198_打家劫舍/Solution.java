package leetcode.editor.cn.t_198_打家劫舍;

//你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上
//被小偷闯入，系统会自动报警。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,1]
//输出：4
//解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 2： 
//
// 
//输入：[2,7,9,3,1]
//输出：12
//解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
//     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 400 
// 
//
// Related Topics 数组 动态规划 👍 2956 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:40.1 MB,击败了21.70% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        /*
            status[i][0]表示不偷第i家的时候的最大金额, status[i][1]表示偷第i加的时候的最大金额, 状态转化方程为:
            status[i][0] = Math.max(status[i-1][0], status[i-1][1]) // 取不偷或者偷的最大值
            status[i][1] = status[i-1][0] + nums[i] // 不能偷上一家
         */
        // 初始化第一家
        int noGet = 0;
        int get = nums[0];

        for (int i = 1; i <nums.length; i++) {
            int preNoGet = noGet;
            int preGet = get;
            noGet = Math.max(preGet, preNoGet);
            get = preNoGet + nums[i];
        }

        return Math.max(noGet, get);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
