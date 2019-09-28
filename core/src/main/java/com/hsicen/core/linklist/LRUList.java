package com.hsicen.core.linklist;

/**
 * <p>作者：Night  2019/3/19 11:12
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：使用单链表实现LRU 缓存算法
 */
public class LRUList {
    /** 缓存的大小 */
    private int size = 10;
    /** 单链表缓存维护 */
    private ListNode cache;
    /** 当前缓存容量 */
    private int length = 0;

    public LRUList(int size) {
        this.size = size;
    }

    /** 添加数据 */
    public void add(int data) {
        //链表为空
        if (cache == null) {
            cache = new ListNode(data);
            return;
        }

        //判断是否缓存过数据(将缓存数据插入链表头部)
        if (contain(data)) {
            delete(data);
            insert(data);
        }

        //判断缓存是否已满
        if (length < size) {
            insert(data);
        }
    }


    /** 查找指定值 */
    private boolean contain(int data) {
        //链表为空
        if (cache == null) return false;

        while (cache != null) {
            if (cache.val == data) return true;
            cache = cache.next;
        }

        return false;
    }

    /** 删除链表中指定数据 */
    private boolean delete(int data) {
        if (cache == null) return false;

        while (cache != null) {
            if (cache.val == data) {
                cache = cache.next;
                length--;
                return true;
            }

            cache = cache.next;
        }

        return false;
    }

    /** 使用头插法插入节点 */
    private void insert(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = cache;
        length++;
    }

}
