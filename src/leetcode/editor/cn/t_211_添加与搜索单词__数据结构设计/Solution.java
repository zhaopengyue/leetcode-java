package leetcode.editor.cn.t_211_添加与搜索单词__数据结构设计;

//请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。 
//
// 实现词典类 WordDictionary ： 
//
// 
// WordDictionary() 初始化词典对象 
// void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配 
// bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 
//'.' ，每个 . 都可以表示任何一个字母。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["WordDictionary","addWord","addWord","addWord","search","search","search",
//"search"]
//[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
//输出：
//[null,null,null,null,false,true,true,true]
//
//解释：
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("bad");
//wordDictionary.addWord("dad");
//wordDictionary.addWord("mad");
//wordDictionary.search("pad"); // 返回 False
//wordDictionary.search("bad"); // 返回 True
//wordDictionary.search(".ad"); // 返回 True
//wordDictionary.search("b.."); // 返回 True
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 25 
// addWord 中的 word 由小写英文字母组成 
// search 中的 word 由 '.' 或小写英文字母组成 
// 最多调用 10⁴ 次 addWord 和 search 
// 
//
// Related Topics 深度优先搜索 设计 字典树 字符串 👍 557 👎 0

/**
 * 击败60%和70%
 */
//leetcode submit region begin(Prohibit modification and deletion)
class WordDictionary {

    private static class TrieNode {

        char c;
        TrieNode[] next = new TrieNode[26];
        boolean isEnd = false;

        TrieNode(char c) {
            this.c = c;
        }

    }

    private TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode('/');
    }
    
    public void addWord(String word) {
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
        // 基于深度优先搜索
        return searchWord(root, 0, word);
    }

    /**
     * 从node节点的子节点中查找是否可以匹配到word.charAt(pos)
     * @param node trieNode节点
     * @param pos 当前查找字符串的pos
     * @param word 待查找字符串
     * @return 是否匹配
     */
    private boolean searchWord(TrieNode node, int pos, String word) {
        if (pos == word.length()) return node.isEnd;
        char c = word.charAt(pos);
        if (c == '.') {
          for (TrieNode child: node.next) {
              if (child != null) {
                  if (searchWord(child, pos + 1, word)) return true; // 若找到, 则直接返回
              }
          }
        } else {
            int i = c - 'a';
            return node.next[i] != null && searchWord(node.next[i], pos + 1, word);
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
//leetcode submit region end(Prohibit modification and deletion)
