package com.hsicen.lib.s108;

/**
 * 作者：hsicen  2020/5/24 14:54
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：将有序数组转换成一颗二叉搜索树(BST)
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {

    public static void main(String[] args) {

    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums) return null;

        TreeNode bstTree = new TreeNode(nums[0]);




        return bstTree;
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
