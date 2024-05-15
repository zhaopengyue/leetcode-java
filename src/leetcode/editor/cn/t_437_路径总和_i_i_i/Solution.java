package leetcode.editor.cn.t_437_路径总和_i_i_i;

//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1852 👎 0

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了99.89% 的Java用户
 * 	内存消耗:43.5 MB,击败了10.23% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return f(root, 0L, targetSum, map);
    }

    private int f(TreeNode root, Long preSum, int targetSum, Map<Long, Integer> map) {
        if (root == null) return 0;
        long currSum = preSum + root.val;
        long flag = currSum - targetSum;
        int res = 0;
        res += map.getOrDefault(flag, 0);
        // 加入前缀和
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        res += f(root.left, currSum, targetSum, map);
        res += f(root.right, currSum, targetSum, map);

        // 移除当前节点, 避免影响
        map.put(currSum, map.get(currSum) - 1);
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
