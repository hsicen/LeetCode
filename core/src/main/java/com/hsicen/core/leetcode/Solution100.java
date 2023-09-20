package com.hsicen.core.leetcode;

/**
 * 作者：hsicen  2020/5/20 16:11
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：判断一颗二叉树是否相同
 * https://leetcode-cn.com/problems/same-tree/
 * <p>
 * 思路：遍历二叉树，对比每个结点的值
 */
public class Solution100 {


    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        p.left = new TreeNode(1);
        p.right = new TreeNode(5);

        TreeNode q = new TreeNode(3);
        q.left = new TreeNode(1);
        q.right = new TreeNode(5);

        System.out.println("Is same：" + isSameTree(p, q));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == null && q == null;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else return false;
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
