package leetcode.editor.cn.t_739_每日温度;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现
//在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 
//
// 
//
// 示例 1: 
//
// 
//输入: temperatures = [73,74,75,71,69,72,76,73]
//输出: [1,1,4,2,1,1,0,0]
// 
//
// 示例 2: 
//
// 
//输入: temperatures = [30,40,50,60]
//输出: [1,1,1,0]
// 
//
// 示例 3: 
//
// 
//输入: temperatures = [30,60,90]
//输出: [1,1,0] 
//
// 
//
// 提示： 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
//
// Related Topics 栈 数组 单调栈 👍 1757 👎 0

import java.util.*;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 基于单调栈
        LinkedList<Integer> stack = new LinkedList<>();
        int len = temperatures.length;
        int[] res = new int[len];
        stack.push(len - 1);

        for (int i = len - 2; i >= 0; i--) {
            int v = temperatures[i];
            // 在单调栈中寻找大于当前值的那个元素
            while (! stack.isEmpty()) {
                if (v > temperatures[stack.peek()]) {
                    stack.pop();
                } else {
                    break;
                }
            }
            int nextMax = i;
            if (! stack.isEmpty()) nextMax = stack.peek();

            stack.push(i);
            res[i] = nextMax - i;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
