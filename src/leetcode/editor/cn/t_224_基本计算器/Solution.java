package leetcode.editor.cn.t_224_基本计算器;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// Related Topics 栈 递归 数学 字符串 👍 1034 👎 0

import java.util.LinkedList;
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        // 操作数栈
        LinkedList<Character> opStack = new LinkedList<>();
        // 符号栈
        LinkedList<Integer> numStack = new LinkedList<>();

        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(\\+", "(0+");
        s = s.replaceAll("\\(-", "(0-");

        char[] cs = s.toCharArray();
        int len = cs.length;
        // 添加0, 防止开始为负数的特殊处理
        if (cs[0] == '-' || cs[0] == '+') numStack.push(0);
        int i = 0;

        while (i < len) {
            char c = cs[i];
            int inc = 1;
            if (c == '(') {
                opStack.push(c);
            } else if (c == ')') {
                // 计算一下存入操作数栈
                calc(numStack, opStack);
                // 将最近一个左括号出栈
                opStack.pop();
            } else if (c == '+' || c == '-'){
                // 操作符
                if (! opStack.isEmpty() && opStack.peek() != '(') calc(numStack, opStack);
                opStack.push(c);
            } else {
                int j = i + 1;
                int num = c - 48; // 转化int
                while (j < len && cs[j] >= '0' && cs[j] <= '9') {
                    num = num * 10 + cs[j] - 48;
                    j++;
                }
                inc = j - i;
                numStack.push(num);
            }
            i += inc;
        }
        // 最后再计算一次
        calc(numStack, opStack);

        // 取出最后计算结果
        
        return numStack.pop();
    }

    private void calc(LinkedList<Integer> numStack, LinkedList<Character> opStack) {
        // 数字不足, 不处理
        if (numStack.size() < 2) return;
        if (opStack.isEmpty()) return;
        int a = numStack.pop();
        int b = numStack.pop();
        char op = opStack.pop();

        numStack.push(op == '+' ? a + b : b - a);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate( " 30"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
