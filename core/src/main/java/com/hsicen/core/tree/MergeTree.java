package com.hsicen.core.tree;

/**
 * <p>作者：hsicen  2020/1/15 11:15
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：利用递归树进行算法时间复杂度分析
 * <p>
 * 快速排序算法：
 * 选择一个轴点，将小于轴点的放在放在左边，大于轴点的放在右边，然后对左右两边区域依次递归
 * 每递归依次需要进行n次交换操作，直到递归完；所以时间复杂度 = n*递归次数
 * 递归树分析：每次对n个数据进行分组
 * 最优情况：每次数据一分为二，然后为一棵满二叉树，树的高度为logn
 * 最差情况：每次数据都在轴的一边，然后最长路径为n-1个数据那一边，树的高度为等比数列的第n项值为1，然后求n的值，树的高度也为logn
 * 时间复杂度为：O(nlogn)
 * <p>
 * 菲波那切数列：
 * f(1) = 1
 * f(2) = 1
 * f(n) = f(n-1)+f(n-2)
 * 将n个数据分组，然后由下向上进行递归相加
 * 递归树时间复杂度分析：每次对数据进行n-1和n-2进行分裂
 * 最优路径情况：每次进行n-2的那条路径，然后高度为n/2 ， 则前n项和为2^0,2^1,2^2 ...... 2^(n/2 - 1)   为 2^(n/2)
 * 最差路径情况：每次进行n-1的那条路径，然后高度为n  ，则前n项和为2^0,2^1,2^2 ...... 2^(n-1)     为 2^n
 * 时间复杂度为：O(2^n)
 * <p>
 * 全排列时间复杂度分析：
 * 从a个数中选出b个数进行排列，能够有多少种组合
 * 确定第一个数，则有a中组合       a次交换操作
 * 确定第二个数，则有a-1种组合   a*(a-1)次交换操作
 * 确定第三个数，则有a-2种组合   a*(a-1)*(a-2)次交换操作
 * ........
 * 确定第b个数，则有a-b+1种组合 a*(a-1)*(a-2)*....*(a-b+1)
 * <p>
 * 若b为1，则最后一项的操作为 a! 次操作
 * 那么总的操作次数< a* a!
 * <p>
 * 问题：
 * 一个细胞的生命周期是3小时，每小时分裂1次，n小时过后有多少细胞(细胞分裂后再死亡)
 * f(0) = 1
 * f(1) = 2
 * f(2) = 4
 * f(3) = 7
 * f(n) = 2f(n-1) + f(n-4)
 */
public class MergeTree {

    public static void main(String[] args) {
        int[] src = new int[]{1, 2, 3, 4};
        printPermutations(src, 4, 1);
    }

    /*** 组合数据
     * @param data 排列数据源
     * @param n    待排列总数
     * @param k    排列数 */
    public static void printPermutations(int[] data, int n, int k) {
        if (data == null || data.length == 0) return;

        if (k == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + "  ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; i++) {
            int temp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = temp;

            printPermutations(data, n, k - 1);

            temp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = temp;
        }
    }
}
