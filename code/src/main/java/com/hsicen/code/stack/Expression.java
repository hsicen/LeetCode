package com.hsicen.code.stack;

import java.util.Stack;

/**
 * <p>作者：Night  2019/2/25 17:07
 * <p>邮箱：codinghuang@163.com
 * <p>作用：括号匹配
 * <p>描述：LeetCode  20.Valid Parentheses
 * <p>
 * https://leetcode.com/problems/valid-parentheses/
 * <p>
 * 思路：
 * ·如果为(,[,{就讲括号入栈，后者就和当前栈顶的括号对比是否匹配
 */
public class Expression {

    public boolean isValid(String s) {
        if (s.isEmpty()) return true;

        char[] ch = s.toCharArray();
        if ((ch.length & 1) == 1) return false;
        Stack<Character> st = new Stack<>();
        for (char aCh : ch) {
            if (st.isEmpty())
                st.push(aCh);
            else {
                if ((aCh == ')' && st.peek() == '(') ||
                        (aCh == ']' && st.peek() == '[') ||
                        (aCh == '}' && st.peek() == '{')) {
                    st.pop();
                } else
                    st.push(aCh);
            }
        }
        return st.isEmpty();
    }
}
