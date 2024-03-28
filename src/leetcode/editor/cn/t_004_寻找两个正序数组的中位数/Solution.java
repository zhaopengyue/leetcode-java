package leetcode.editor.cn.t_004_寻找两个正序数组的中位数;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
//
// Related Topics 数组 二分查找 分治 👍 7051 👎 0

/**
 * 解答成功:
 * 	执行耗时:1 ms,击败了100.00% 的Java用户
 * 	内存消耗:44.7 MB,击败了74.18% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Cnt = nums1.length;
        int n2Cnt = nums2.length;

        int mid1 = (n1Cnt + n2Cnt + 1) >> 1;
        int mid2 = (n1Cnt + n2Cnt + 2) >> 1;

        return (getKth(nums1, nums2, mid1, 0, n1Cnt - 1, 0, n2Cnt - 1)
                + getKth(nums1, nums2, mid2, 0, n1Cnt - 1, 0, n2Cnt - 1)) / 2;
    }

    /**
     * 获取第k大元素
     * @param nums1 nums1
     * @param nums2 nums2
     * @param k 第k大
     * @param n1L nums1左侧
     * @param n1R nums1右侧
     * @param n2L nums2左侧
     * @param n2R nums2右侧
     * @return 第k大元素
     */
    private double getKth(int[] nums1, int[] nums2, int k, int n1L, int n1R, int n2L, int n2R) {
        int l1 = n1R - n1L + 1, l2 = n2R - n2L + 1;
        // 确保永远都是n1的长度短
        if (l1 > l2) return getKth(nums2, nums1, k, n2L, n2R, n1L, n1R);
        // 若l1长度为0, 则直接从l2中取
        if (l1 == 0) return nums2[n2L + k - 1];

        if (k == 1) return Math.min(nums1[n1L], nums2[n2L]);

        // 计算l1索引
        int num1m = n1L + Math.min(k / 2, l1) - 1, num2m = n2L + Math.min(k / 2, l2) - 1;
        if (nums1[num1m] > nums2[num2m]) {
            // nums2前半部分皆不会属于第k大元素
            return getKth(nums1, nums2, k - (num2m - n2L + 1), n1L, n1R, num2m + 1, n2R);
        } else {
            return getKth(nums1, nums2, k - (num1m - n1L + 1), num1m + 1, n1R, n2L, n2R);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
