package com.hsicen.core.leetcode;

/**
 * 作者：hsicen  2020/5/22 9:22
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * 思路：
 * 1. 递归实现
 * 2. 迭代实现(广度优先搜索和层序遍历，深度优先搜索和栈)
 */
public class Solution104 {

    public static void main(String[] args) {

    }

    /*** 递归实现*/
    public int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
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
