package leetcode.editor.cn.t_373_查找和最小的_k_对数字;

//给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。 
//
// 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。 
//
// 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
//输出: [1,2],[1,4],[1,6]
//解释: 返回序列中的前 3 对数：
//     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
// 
//
// 示例 2: 
//
// 
//输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
//输出: [1,1],[1,1]
//解释: 返回序列中的前 2 对数：
//     [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// -10⁹ <= nums1[i], nums2[i] <= 10⁹ 
// nums1 和 nums2 均为 升序排列 
// 
// 1 <= k <= 10⁴ 
// k <= nums1.length * nums2.length 
// 
//
// Related Topics 数组 堆（优先队列） 👍 576 👎 0

/**
 * 解答成功:
 * 	执行耗时:31 ms,击败了47.92% 的Java用户
 * 	内存消耗:57.3 MB,击败了49.66% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 存入的是一个三元组, 分别是元素和, i和j
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> res = new ArrayList<>(k);

        // 首先, 最小的一定是[0, 0], 故先入堆
        heap.add(new int[] {nums1[0] + nums2[0], 0, 0});

        // 假设当前[i, j]为最小, 那么次小一定是[i+1, j]和[i, j+1]. 但是可能会有重复, 即[0, 1]可能产生[1,1],[1,0]也会产生[1,1]
        // 故规定[i,j]出堆时，只需将[i,j+1]入堆，无需将[i+1, j]入堆。但是这样的可能只会有[0,1][0,2]等，因此需要将[1,0][2,0]的时候也初始化进去
        while (! heap.isEmpty() && res.size() < k) {
            int[] node = heap.poll();
            int i = node[1], j = node[2];
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j == 0 && i + 1 < nums1.length) {
                // 初始化
                heap.add(new int[] {nums1[i + 1] + nums2[0], i + 1, 0});
            }
            if (j + 1 < nums2.length) {
                //
                heap.add(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
