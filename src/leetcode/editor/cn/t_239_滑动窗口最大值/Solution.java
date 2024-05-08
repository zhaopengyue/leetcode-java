package leetcode.editor.cn.t_239_滑动窗口最大值;

//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。 
//
// 返回 滑动窗口中的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], k = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2783 👎 0

/**
 * 参考：https://www.cnblogs.com/Cattle-Horse/p/17033321.html
 * 解答成功:
 * 	执行耗时:32 ms,击败了44.61% 的Java用户
 * 	内存消耗:57.3 MB,击败了78.14% 的Java用户
 */

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列
        Deque<Integer> queue = new LinkedList<>();

        int [] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 检测队首元素超出边界, 若超过, 则不可能为最大值,出队
            if (!queue.isEmpty() && queue.peekFirst() < i - k + 1) queue.pollFirst();
            while (!queue.isEmpty() && nums[i] >= nums[queue.peekLast()] ) {
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i + 1 >= k) res[i-k+1] = nums[queue.peekFirst()];
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
