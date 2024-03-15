package com.hsicen.code.leetcode;

/**
 * @author: hsicen
 * @date: 2024/3/15 16:00
 * @email: codinghuang@163.com
 * @description: 151. 反转字符串中的单词
 * <p>
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * 单词 是由非空格字符组成的字符串。
 * s 中使用至少一个空格将字符串中的 单词 分隔开。
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
 * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * <p>
 * 输入：s = "  hello world  "
 * 输出："world hello"
 * 解释：反转后的字符串中不能存在前导空格和尾随空格。
 * 示例 3：
 * <p>
 * 输入：s = "a good   example"
 * 输出："example good a"
 * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
 */
public class Solution151 {

    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String s = "  hello world  ";
        String reversed = solution.reverseWords(s);
        System.out.println(reversed);
    }

    public String reverseWords(String s) {
        // 去除首尾空格，然后按照一个或多个空格分割字符串
        String[] words = s.trim().split("\\s+");
        StringBuilder reversed = new StringBuilder();

        // 从后向前遍历单词数组，反向拼接单词
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" "); // 在单词之间添加空格，最后一个单词后不添加
            }
        }
        return reversed.toString();
    }
}
