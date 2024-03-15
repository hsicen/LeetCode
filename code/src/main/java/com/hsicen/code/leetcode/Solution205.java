package com.hsicen.core.leetcode;

/**
 * @author: hsc
 * @date: 2024/3/12 18:10
 * @email: codinghuang@163.com
 * @description: 205. 同构字符串
 * <p>
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class Solution205 {

  public static void main(String[] args) {
    Solution205 solution205 = new Solution205();
    System.out.println(solution205.isIsomorphic("egg", "add"));
    System.out.println(solution205.isIsomorphic("foo", "bar"));
    System.out.println(solution205.isIsomorphic("paper", "title"));
  }

  public boolean isIsomorphic(String s, String t) {
    if (s == null || t == null || s.length() != t.length()) {
      return false;
    }

    int[] s2t = new int[256];
    int[] t2s = new int[256];
    for (int i = 0; i < s.length(); i++) {
      if (s2t[s.charAt(i)] != t2s[t.charAt(i)]) {
        return false;
      }

      s2t[s.charAt(i)] = i + 1;
      t2s[t.charAt(i)] = i + 1;
    }
    return true;
  }
}
