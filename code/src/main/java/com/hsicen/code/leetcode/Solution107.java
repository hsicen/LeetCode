package com.hsicen.code.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 作者：hsicen  2020/5/22 16:33
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/comments/
 * <p>
 * 思路：每遍历一层，step加1
 */
public class Solution107 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);

        root.left = left;
        root.right = right;

        TreeNode secondLeft = new TreeNode(15);
        TreeNode secondRight = new TreeNode(7);
        right.left = secondLeft;
        right.right = secondRight;

        levelOrderBottom(root);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(root, list, 0);
        Collections.reverse(list);

        return list;
    }

    public static void bfs(TreeNode root, List<List<Integer>> data, int step) {
        if (null == root) return;
        if (step >= data.size()) data.add(new ArrayList<Integer>());
        bfs(root.left, data, step + 1);
        bfs(root.right, data, step + 1);

        data.get(step).add(root.val);
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
