package leetcode.editor.cn.t_155_最小栈;

//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 实现 MinStack 类: 
//
// 
// MinStack() 初始化堆栈对象。 
// void push(int val) 将元素val推入堆栈。 
// void pop() 删除堆栈顶部的元素。 
// int top() 获取堆栈顶部的元素。 
// int getMin() 获取堆栈中的最小元素。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// pop、top 和 getMin 操作总是在 非空栈 上调用 
// push, pop, top, and getMin最多被调用 3 * 10⁴ 次 
// 
//
// Related Topics 栈 设计 👍 1765 👎 0

/**
 * 解答成功:
 * 	执行耗时:3 ms,击败了100.00% 的Java用户
 * 	内存消耗:43.9 MB,击败了51.69% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    private static class Node {
        Node next;
        int v;
        // 上一个最小的元素
        Node mNext;

        Node () {}
        Node (int _v) {
            this.v = _v;
        }
    }

    private Node MIN;
    private final Node HEAD;
    // 避免处理null
    private Node tail;

    public MinStack() {
        this.MIN = new Node(Integer.MAX_VALUE);
        this.HEAD = new Node();
        this.tail = new Node();
        HEAD.next = tail;
    }
    
    public void push(int val) {
        Node node = new Node(val);
        node.next = HEAD.next;
        HEAD.next = node;
        if (node.v < MIN.v) {
            node.mNext = MIN;
            MIN = node;
        }
    }
    
    public void pop() {
        Node node = HEAD.next;
        HEAD.next = node.next;
        if (node == MIN) {
            MIN = node.mNext;
        }
        // 便于GC
        node = null;
    }
    
    public int top() {
        return HEAD.next.v;
    }
    
    public int getMin() {
        return MIN.v;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
