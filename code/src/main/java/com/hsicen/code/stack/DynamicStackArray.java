package com.hsicen.code.stack;

/**
 * <p>作者：Night  2019/3/20 16:25
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：基于数组实现的动态扩容的栈
 * 每次扩容大小为当前容量的0.75
 */
@SuppressWarnings("ALL")
public class DynamicStackArray<T> {
    private T[] items;
    /*** 当前栈中的元素 */
    private int count;
    /*** 栈的大小 */
    private int length;

    public DynamicStackArray(int capacity) {
        this.length = capacity;
        items = (T[]) new Object[capacity];
        count = 0;
    }

    /*** 入栈操作*/
    public boolean push(T item) {
        if (count == length) {
            resize();
        }

        items[count] = item;
        count++;

        return true;
    }

    /*** 出栈操作*/
    public T pop() {
        if (count == 0) {
            System.out.println("当前栈为空，出栈失败");
            return null;
        }

        return items[--count];
    }

    /*** 重新分配栈的大小*/
    private void resize() {
        length = (int) (length * (1 + 0.75));
        T[] temp = (T[]) new Object[length];

        System.arraycopy(items, 0, temp, 0, items.length);
        this.items = temp;
    }
}
