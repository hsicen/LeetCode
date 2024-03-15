package com.hsicen.code.stack;

/**
 * <p>作者：Night  2019/3/20 15:51
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：基于数组实现的顺序栈
 */
public class StackArray {
    private int[] items;
    /**
     * 当前栈中元素个数
     */
    private int count;
    /**
     * 栈的大小
     */
    private int length;

    public StackArray(int capacity) {
        items = new int[capacity];
        this.length = capacity;
        count = 0;
    }

    /*** 入栈操作
     *     先入栈，再++
     * */
    public boolean push(int item) {
        if (count == length) {
            System.out.println("当前栈已满，入栈失败");
            return false;
        }

        items[count] = item;
        count++;
        return true;
    }

    /*** 出栈操作
     *     先--，再出栈
     * */
    public int pop() {
        if (count == 0) {
            System.out.println("当前栈为空，出栈失败");
            return -1;
        }

        return items[--count];
    }

    /*** 获取当前栈顶元素*/
    public int peek() {
        if (isEmpty()) return -1;

        return items[count - 1];
    }

    /*** 判断当前栈是否为空*/
    private boolean isEmpty() {

        return count == 0;
    }


}
