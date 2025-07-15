package com.hsicen.code.linklist;

/**
 * <p>作者：Night  2019/3/19 11:12
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：使用双向链表+HashMap实现LRU缓存算法
 */
public class LRUList {
    private int capacity;
    private Node head;
    private Node tail;
    private java.util.Map<Integer, Node> cache;

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUList(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.HashMap<>();

        // 创建虚拟头尾节点
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    /**
     * 获取缓存值
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }

        // 移动到头部
        moveToHead(node);
        return node.val;
    }
    
    /**
     * 添加或更新缓存
     */
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node != null) {
            // 更新已存在的节点
            node.val = value;
            moveToHead(node);
        } else {
            // 添加新节点
            Node newNode = new Node(key, value);

            if (cache.size() >= capacity) {
                // 删除尾部节点
                Node last = removeTail();
                cache.remove(last.key);
            }

            // 添加到头部
            addToHead(newNode);
            cache.put(key, newNode);
        }
    }
    
    /**
     * 添加节点到头部
     */
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除节点
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 移动节点到头部
     */
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾部节点
     */
    private Node removeTail() {
        Node last = tail.prev;
        removeNode(last);
        return last;
    }

    /**
     * 为了兼容旧接口，保留add方法
     */
    public void add(int data) {
        put(data, data);
    }
    
    /**
     * 打印当前缓存状态
     */
    public void printCache() {
        Node current = head.next;
        System.out.print("LRU Cache: ");
        while (current != tail) {
            System.out.print(current.key + "->" + current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 测试方法
     */
    public static void main(String[] args) {
        LRUList lru = new LRUList(3);

        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        lru.printCache(); // 3->3 2->2 1->1

        lru.get(2); // 访问2，移动到头部
        lru.printCache(); // 2->2 3->3 1->1

        lru.put(4, 4); // 添加4，删除最久未使用的1
        lru.printCache(); // 4->4 2->2 3->3

        System.out.println("Get 1: " + lru.get(1)); // -1 (not found)
        System.out.println("Get 2: " + lru.get(2)); // 2
    }
}
