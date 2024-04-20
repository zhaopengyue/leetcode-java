package leetcode.editor.cn.t_149_直线上最多的点数;

//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
// 
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
// 
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// points 中的所有点 互不相同 
// 
//
// Related Topics 几何 数组 哈希表 数学 👍 549 👎 0

import java.util.HashMap;
/**
 * 解答成功:
 * 	执行耗时:34 ms,击败了31.66% 的Java用户
 * 	内存消耗:43.8 MB,击败了17.03% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length, ans = 1;
        // 枚举任意两个节点, 计算任意两个节点之间的斜率, 斜率相同的节点中
        for (int i = 0; i < n; i++) {
            // 从i节点出发到其它点中斜率相同的点的个数
            HashMap<String, Integer> pointMap = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < n; j++) {
                int ix = points[i][0], iy = points[i][1], jx = points[j][0], jy = points[j][1];
                int xf = ix - jx, yf = iy - jy;
                int k = gcd(xf, yf); //计算差的最大公约数
                String key = xf/k + "_" + yf/k;
                pointMap.put(key, pointMap.getOrDefault(key, 0) + 1);
                max = Math.max(max, pointMap.get(key));
            }
            ans = Math.max(max + 1, ans);
        }
        return ans;
    }

    // 辗转相除法计算最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
