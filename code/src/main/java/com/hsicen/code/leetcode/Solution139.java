package com.hsicen.code.leetcode;


import java.util.List;

/**
 * @author: hsc
 * @date: 2024/3/14 18:51
 * @email: codinghuang@163.com
 * @description: 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。
 * 如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 示例 1:
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 可以拼接出 "leetcode"："leet" + "code"
 * <p>
 * 示例 2:
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 可以拼接出 "applepenapple": "apple" + "pen" + "apple"
 * 注意: 你可以重复使用字典中的单词。
 * 示例 3:
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成。
 * wordDict 中的所有字符串 互不相同。
 */
public class Solution139 {

    public static void main(String[] args) {
        Solution139 solution139 = new Solution139();
        System.out.println(solution139.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(solution139.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(solution139.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakdfs(s, wordDict, 0, new boolean[s.length()]);
    }

    public boolean wordBreakdfs(String s, List<String> wordDict, int start, boolean[] visited) {
        if (start == s.length()) {//一直能搜到 搜到s的末尾
            return true;
        }
        if (visited[start]) {//visited[] 看每个字符串是否遍历
            return false;
        }
        for (String word : wordDict) {//遍历字典
            if (s.startsWith(word, start)) {//如果是以 word 能匹配上 ==>> 开始深搜
                if (wordBreakdfs(s, wordDict, start + word.length(), visited)) {//遍历返回值为 true 说明都能找到
                    return true;
                }
            }
        }
        visited[start] = true;//遍历完发现没有符合的 标记 start 开始的字典
        return false;
    }
}
