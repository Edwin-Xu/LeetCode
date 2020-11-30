package leetcode.interview.inte;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 8/25/2020 12:35 AM
 *
 * 面试题 16.25. LRU缓存
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 *
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 *
 * 类似NC的：
 * https://www.nowcoder.com/practice/e3769a5f49894d49b871c09cadd13a61?tpId=117&&tqId=35015&rp=1&ru=/ta/job-code-high&qru=/ta/job-code-high/question-ranking
 *
 * 可以使用LinkedHashMap
 *
 * 最好使用双链表+HashMap
 * HashMap存储key对于的Node
 * 以便在set\get的时候O(1)时间内定位
 *
 */
public class Int_16_25 {
    class LRUCache{

        //定义双向链表节点
        private class ListNode {
            int key;
            int val;
            ListNode pre;
            ListNode next;

            public ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                pre = null;
                next = null;
            }
        }

        private int capacity;
        private Map<Integer, ListNode> map;     //key->node
        private ListNode head;  //dummy head
        private ListNode tail;  //dummy tail

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(-1, -1);
            tail = new ListNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            ListNode node = map.get(key);
            //先把这个节点删除，再接到尾部
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);

            return node.val;
        }

        public void put(int key, int value) {
            //直接调用这边的get方法，如果存在，它会在get内部被移动到尾巴，不用再移动一遍,直接修改值即可
            if (get(key) != -1) {
                map.get(key).val = value;
                return;
            }
            //不存在，new一个出来,如果超出容量，把头去掉
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            moveToTail(node);

            if (map.size() > capacity) {
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
            }
        }

        private void moveToTail(ListNode node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.pre.next = node;
            node.next = tail;
        }
    }

}
