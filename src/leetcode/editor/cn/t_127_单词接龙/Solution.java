package leetcode.editor.cn.t_127_单词接龙;

//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列
// beginWord -> s1 -> s2 -> ... -> sk： 
//
// 
// 每一对相邻的单词只差一个字母。 
// 
// 对于 1 <= i <= k 时，每个
// si 都在
// wordList 中。注意， beginWord 不需要在
// wordList 中。
// 
// sk == endWord 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 
//中的 单词数目 。如果不存在这样的转换序列，返回 0 。 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
//
// Related Topics 广度优先搜索 哈希表 字符串 👍 1361 👎 0

import java.util.*;

/**
 * 解答成功:
 * 	执行耗时:92 ms,击败了57.72% 的Java用户
 * 	内存消耗:46.5 MB,击败了50.45% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> distSet = new HashSet<>(wordList);
        if (! distSet.contains(endWord) || wordList.isEmpty()) return 0;

        Set<String> visited = new HashSet<>(wordList.size() + 1);
        LinkedList<String> queue = new LinkedList<>();
        // 初始步数为1
        int step = 1;

        // 采用边遍历边构建的方式
        // 基于BFS特性，只要能访问到endWord,那么此时的step就是最小的
        visited.add(beginWord);
        queue.offer(beginWord);

        while (! queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 逐层访问
                String word = queue.poll();
                if (isTurnToEndWord(word, endWord, distSet, visited, queue)) {
                    return step + 1;
                }
                // 若无法被转化, 则继续遍历
            }
            step ++;
        }

        return 0;
    }

    // 判断start是否可以一个单词转化为end
    private boolean isTurnToEndWord(String start, String end, Set<String> distSet, Set<String> visited, LinkedList<String> queue) {
        // 尝试改变每一个字符
        char[] arr = start.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ori = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                arr[i] = j;
                String word = String.valueOf(arr);
                if (word.equals(end)) return true;
                // 当前元素可以转换且未被访问过
                if (distSet.contains(word) && ! visited.contains(word)) {
                    queue.offer(word); // 当前元素可以转化
                    visited.add(word); // 标记当前元素为访问, 防止被重复建立
                }
            }
            // 还原
            arr[i] = ori;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
