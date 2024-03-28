package leetcode.editor.cn.t_295_数据流的中位数;

//中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。 
//
// 
// 例如 arr = [2,3,4] 的中位数是 3 。 
// 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。 
// 
//
// 实现 MedianFinder 类: 
//
// 
// MedianFinder() 初始化 MedianFinder 对象。 
// void addNum(int num) 将数据流中的整数 num 添加到数据结构中。 
// double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10⁻⁵ 以内的答案将被接受。 
// 
//
// 示例 1： 
//
// 
//输入
//["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
//[[], [1], [2], [], [3], []]
//输出
//[null, null, null, 1.5, null, 2.0]
//
//解释
//MedianFinder medianFinder = new MedianFinder();
//medianFinder.addNum(1);    // arr = [1]
//medianFinder.addNum(2);    // arr = [1, 2]
//medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
//medianFinder.addNum(3);    // arr[1, 2, 3]
//medianFinder.findMedian(); // return 2.0 
//
// 提示: 
//
// 
// -10⁵ <= num <= 10⁵ 
// 在调用 findMedian 之前，数据结构中至少有一个元素 
// 最多 5 * 10⁴ 次调用 addNum 和 findMedian 
// 
//
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 👍 969 👎 0

/**
 * 解答成功:
 * 	执行耗时:101 ms,击败了96.78% 的Java用户
 * 	内存消耗:61.4 MB,击败了98.69% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.PriorityQueue;

class MedianFinder {

    // 小顶堆
    private PriorityQueue<Integer> small;
    // 大顶堆
    private PriorityQueue<Integer> big;
    private int size = 0;

    public MedianFinder() {
        small = new PriorityQueue<>();
        big = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }
    
    public void addNum(int num) {
        if (small.isEmpty() && big.isEmpty()) {
            big.add(num);
        } else {
            if (num < big.peek()) {
                big.add(num);
            } else {
                small.add(num);
            }
        }
        balance();
        size += 1;
    }
    
    public double findMedian() {
        return (size & 1) == 0 ? (Double.valueOf(small.peek()) + big.peek()) / 2 : big.peek();
    }

    // 平衡大顶堆和小顶堆,
    private void balance() {
        if (big.size() > small.size() + 1) {
            small.add(big.poll());
        } else if (big.size() < small.size()) {
            big.add(small.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)
