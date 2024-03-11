package leetcode.editor.cn.t_208_实现_trie_前缀树;

//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼
//写检查。 
//
// 请你实现 Trie 类： 
//
// 
// Trie() 初始化前缀树对象。 
// void insert(String word) 向前缀树中插入字符串 word 。 
// boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 
//false 。 
// boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否
//则，返回 false 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
//[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
//输出
//[null, null, true, false, true, null, true]
//
//解释
//Trie trie = new Trie();
//trie.insert("apple");
//trie.search("apple");   // 返回 True
//trie.search("app");     // 返回 False
//trie.startsWith("app"); // 返回 True
//trie.insert("app");
//trie.search("app");     // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length, prefix.length <= 2000 
// word 和 prefix 仅由小写英文字母组成 
// insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 1612 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Trie {

    private static class TrieNode {

        char c;
        TrieNode[] next = new TrieNode[26];
        boolean isEnd = false;

        TrieNode(char c) {
            this.c = c;
        }

    }

    private final TrieNode root;

    public Trie() {
        this.root = new TrieNode('/');
    }
    
    public void insert(String word) {
        TrieNode p = root;
        int i = 0;
        while (i < word.length()) {
            int pos = word.charAt(i) - 'a';
            if (p.next[pos] == null) {
                p.next[pos] = new TrieNode(word.charAt(i));
            }
            p = p.next[pos];
            i++;
        }
        p.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode p = root;
        for (char c: word.toCharArray()) {
            int pos = c - 'a';
            if (p.next[pos] == null) return false;
            p = p.next[pos];
        }
        return p.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (char c: prefix.toCharArray()) {
            int pos = c - 'a';
            if (p.next[pos] == null) return false;
            p = p.next[pos];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)
