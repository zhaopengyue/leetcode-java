package leetcode.editor.cn.t_069_x_的平方根;

//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。 
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// Related Topics 数学 二分查找 👍 1529 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了88.27% 的Java用户
 * 	内存消耗:39.9 MB,击败了52.04% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l <= x) {
            int m = (l + r) >> 1;
            if (Math.pow(m, 2) <= x) {
                if (Math.pow(m + 1, 2) > x) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else {
                r = m - 1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
