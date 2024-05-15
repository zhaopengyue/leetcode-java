package leetcode.editor.cn.t_124_二叉树中的最大路径和;

//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
// 
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 10⁴] 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2218 👎 0

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
 * 	执行耗时:1 ms,击败了36.02% 的Java用户
 * 	内存消耗:43.5 MB,击败了10.25% 的Java用户
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

    private int max;
    public int maxPathSum(TreeNode root) {
        max = -1001;

        f(root);

        return max;
    }

    private int f(TreeNode root) {
        if (root == null) return 0;

        // 寻找经过左右子树的最大路径和
        int left = f(root.left);
        int right = f(root.right);

        // 当前节点的最大路径和应该为当前节点 + 左最大 + 右最大
        int sum = root.val + left + right;
        max = Math.max(sum, max);

        // 经过当前root的最大路径, 需要从左和右孩子中选其一个最大的
        int outSum =  root.val + Math.max(0, Math.max(left, right));

        return Math.max(outSum, 0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
