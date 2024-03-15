package leetcode.editor.cn.t_148_排序链表;

//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 2263 👎 0

import com.sun.org.apache.bcel.internal.generic.RET;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
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

/**
 * 解答成功:
 * 	执行耗时:10 ms,击败了89.94% 的Java用户
 * 	内存消耗:55.6 MB,击败了45.87% 的Java用户
 */
class Solution {
    public ListNode sortList(ListNode head) {

        if (head == null || head.next == null) return head;

        // 快慢指针拆分链表
        ListNode p = head;
        ListNode q = head;

        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }

        // 断链
        ListNode head2 = p.next;
        p.next = null;

        // 合并head及head2
        ListNode link1 = sortList(head);
        ListNode link2 = sortList(head2);

        return merge(link1, link2);
    }


    private ListNode merge(ListNode a, ListNode b) {
        ListNode root = new ListNode();

        ListNode p = a;
        ListNode q = b;
        ListNode c = root;
        while (p != null && q != null) {
            if (p.val < q.val) {
                c.next = p;
                p = p.next;
            } else {
                c.next = q;
                q = q.next;
            }
            c = c.next;
        }

        if (p != null) c.next = p;
        if (q != null) c.next = q;

        return root.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
