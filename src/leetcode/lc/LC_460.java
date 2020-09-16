package leetcode.lc;

import leetcode.util.Print;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Edwin Xu on 9/12/2020 2:19 PM
 *
 * 460. LFU缓存
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 *
 */

public class LC_460 {
    private int capacity;
    public LC_460(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);

    private Map<Integer,Node> map = new HashMap<>();

    public int get(int key) {
        System.out.println("\nget "+key);
        int res = -1;
        if (capacity==0)return res;
        if (map.containsKey(key)){
            Node node = map.get(key);
            res = node.val;
            node.refCnt++;
            //向前调整
            adjust(node);
        }

        print(head);
        System.out.println(res);
        return res;
    }

    public void put(int key, int value) {
        if (capacity==0)return ;
        System.out.println("\nput key = "+key +" val = "+value);
        if (map.containsKey(key)){//存在了
            //引用+1
            Node node = map.get(key);
            node.refCnt++;
            node.val = value;

            //向前调整：
            adjust(node);

        }else{ //不存在
            if (map.size()==capacity){//达到容量上限, 删除最后一个
                Node prev = tail.prev.prev;
                Node del = tail.prev;

                tail.prev.prev.next = tail;
                tail.prev = prev;

                map.remove(del.key);
                del = null;//加速回收
            }
            //添加到链表尾部
            Node newNode  = new Node(key,value);
            map.put(key,newNode);

            Node prev =  tail.prev;
            prev.next = newNode;
            newNode.prev = prev;

            newNode.next =tail;
            tail.prev = newNode;

            adjust(newNode);
        }
        print(head);
    }

    //向前调整
    private void adjust(Node node){
        if (node.prev == head)return;//第一个，不用调整
        int refCnt = node.refCnt;
        while (node.prev!=head && node.prev.refCnt<=refCnt){
            Node prevOfprev = node.prev.prev;
            Node prev = node.prev;
            Node next = node.next;

            prevOfprev.next = node;
            node.prev = prevOfprev;
            prev.next = next;
            next.prev = prev;

            node.next = prev;
            prev.prev = node;
        }
    }

    class Node{
        int key;
        int val;
        int refCnt;
        Node prev ;
        Node next;
        Node(int key,int val){
            this.val  = val;
            this.key=key;
            refCnt = 1;
        }
    }


    public static void main(String[] args) {
        LC_460 lru = new LC_460(3);
        lru.put(1,1);
        lru.put(2,2);
        lru.put(3,3);
        lru.put(4,4);

        lru.get(4);
        lru.get(3);
        lru.get(2);
        lru.get(1);

        lru.put(5,5);

        lru.get(1);
        lru.get(2);
        lru.get(3);
        lru.get(4);
        lru.get(5);
    }

    public  void print(Node head){
        Node cur = head;
        StringBuilder sb = new StringBuilder();
        while (cur!=null){
            sb.append("(");
            sb.append(cur.val);
            sb.append(",");
            sb.append(cur.refCnt);
            sb.append(")");
            sb.append(" ");
            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}


//---------------------------------------------------
// O(1)
// 第一个Map：<key, Node>
// 第二个个Map： <频数，该频数的Hash链表>

class LFUCache {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次
    class Node {
        int key;
        int value;
        int freq = 1;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LFUCache(int capacity) {
        cache = new HashMap<> (capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}
