package com.hsicen.lib.s104;

/**
 * 作者：hsicen  2020/5/22 9:22
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {

    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        if (null == root) return 0;

        

        return 2;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
