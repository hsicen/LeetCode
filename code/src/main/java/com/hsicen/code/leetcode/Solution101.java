package com.hsicen.core.leetcode;

/**
 * 作者：hsicen  2020/5/20 16:19
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：镜像对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 */
public class Solution101 {

    public static void main(String[] args) {

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.right) && isSameTree(p.right, q.left);
        } else return false;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSameTree(root.left, root.right);
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
