package leetcode.editor.cn.t_300_最长递增子序列;

//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
//
// Related Topics 数组 二分查找 动态规划 👍 3609 👎 0

/**
 * 解答成功:
 * 	执行耗时:2 ms,击败了99.52% 的Java用户
 * 	内存消耗:42.9 MB,击败了92.22% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // 构建一个tail数组
        int[] tail = new int[nums.length];
        int cnt = 0;
        for (int num: nums) {
            int l = 0;
            int r = cnt;
            // [1, 2, 4], 若当前元素为3, 则应该为[1,2,3],若当前元素为5,则应该为[1,2,4,5], 等于与寻找第一个大于num的元素所在的位置
            while (l < r) {
                int m = (l + r) >> 1;
                if (tail[m] < num) {
                    l = m + 1; // 大于的元素一定在右边
                } else {
                    r = m;
                }
            }
            // 存放到对应的位置
            tail[l] = num;
            if (l == cnt) cnt++;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
