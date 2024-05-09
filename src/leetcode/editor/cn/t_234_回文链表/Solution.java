package leetcode.editor.cn.t_234_回文链表;
//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// Related Topics 栈 递归 链表 双指针 👍 1894 👎 0

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了99.72% 的Java用户
 * 	内存消耗:58.5 MB,击败了59.27% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode p = head, q = head;
        // 基于快慢指针寻找中点
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        // 此时p位于中间位点左侧或者中间位点, 翻转p之后元素
        ListNode prev = p;
        p = p.next;
        while (p != null) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        // prev作为反转后的头结点
        p = head;
        q = prev;
        while (true) {
            if (p.val != q.val) return false;
            if (p.next == q.next) return true; // 奇数情况
            if (p.next == q || q.next == p) return p.val == q.val; // 偶数
            p = p.next;
            q = q.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
