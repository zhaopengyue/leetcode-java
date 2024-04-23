package leetcode.editor.cn.t_212_单词搜索_i_i;

//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
// 
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
//
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 858 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:286 ms,击败了64.30% 的Java用户
 * 	内存消耗:43.8 MB,击败了58.20% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 方向
    private static final int[][] directions = new int[][] {
            {-1, 0}, // 上
            {1, 0}, // 下
            {0, -1}, // 左
            {0, 1} // 右
    };

    public List<String> findWords(char[][] board, String[] words) {
        // 初始化构建trie树
        Trie root = new Trie();
        for (String word: words) root.insert(word);

        // dfs遍历board,查看是否存在前缀
        Set<String> res = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, res, root);
            }
        }

        return new ArrayList<>(res);

    }

    // 判断x,y是否为curr的子节点
    private void dfs(int x, int y, char[][] board, Set<String> res, Trie currNode) {
        char c = board[x][y];
        int index = c - 'a';
        if (currNode.children[index] == null) return; // 未找到
        currNode = currNode.children[index];

        if (!currNode.word.isEmpty()) {
            res.add(currNode.word); // 已经找到,加入结果集, 继续寻找
        }
        char ori = board[x][y];
        board[x][y] = '$';

        for (int[] direction : directions) {
            int nx = direction[0] + x;
            int ny = direction[1] + y;
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && board[nx][ny] != '$') {
                dfs(nx, ny, board, res, currNode);
            }
        }
        // 还原
        board[x][y] = ori;
    }

    private static class Trie {
        // 每个trie树叶子结点存储其完整word
        private String word = "";
        private final Trie[] children;

        Trie() {
            this.children = new Trie[26];
        }

        void insert(String word) {
            Trie curr = this;
            for (int i = 0; i < word.length(); i++) {
                char wc = word.charAt(i);
                int index = wc - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new Trie();
                }
                curr = curr.children[index];
            }
            curr.word = word;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
