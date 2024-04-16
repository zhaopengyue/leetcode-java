package leetcode.editor.cn.t_066_加一;

//给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。 
//
// 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。 
//
// 你可以假设除了整数 0 之外，这个整数不会以零开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = [1,2,3]
//输出：[1,2,4]
//解释：输入数组表示数字 123。
// 
//
// 示例 2： 
//
// 
//输入：digits = [4,3,2,1]
//输出：[4,3,2,2]
//解释：输入数组表示数字 4321。
// 
//
// 示例 3： 
//
// 
//输入：digits = [0]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= digits.length <= 100 
// 0 <= digits[i] <= 9 
// 
//
// Related Topics 数组 数学 👍 1378 👎 0

/**
 * 解答成功:
 * 	执行耗时:0 ms,击败了100.00% 的Java用户
 * 	内存消耗:40.7 MB,击败了91.07% 的Java用户
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (digits[len - 1] != 9) {
            // 不存在进位, 直接+1返回即可
            digits[len - 1]++;
            return digits;
        }
        // 可能存在进位
        int carry = 0, i = len - 1;
        // 暂存第一位
        int first = digits[0];
        while (i >= 0) {
            int sum = digits[i] + carry;
            if (i == len - 1) {
                sum++;
            }
            digits[i] = sum % 10;
            carry = sum >= 10 ? 1 : 0;
            if (carry == 0) break; // 当前位数不会影响前面的元素了
            i--;
        }
        if (first == 9 && carry == 1) {
            int[] newArr = new int[len + 1];
            newArr[0] = 1;
            System.arraycopy(digits, 0, newArr, 1, len);
            return newArr;
        } else {
            return digits;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
