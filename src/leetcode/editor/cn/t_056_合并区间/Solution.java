package leetcode.editor.cn.t_056_合并区间;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 2321 👎 0

import java.util.*;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        // 按左侧排序, 此时仅需要考虑右侧区间
        Arrays.sort(intervals, 0, intervals.length, Comparator.comparingInt(o -> o[0]));

        // 初始第一个元素作为第一个
        int left = intervals[0][0], right = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int iLeft = intervals[i][0], iRight = intervals[i][1];
            if (iLeft <= right) {
                // 合并该区间到上一个区间
                right = Math.max(right, iRight);
            } else {
                // 上一个区间作为独立区间
                res.add(new int[] {left, right});
                left = iLeft;
                right = iRight;
            }
        }
        res.add(new int[] {left, right});

        return res.toArray(new int[][]{});
    }
}
//leetcode submit region end(Prohibit modification and deletion)
