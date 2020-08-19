package leetcode.lc;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Edwin Xu on 5/25/2020 2:44 PM
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *  
 *
 *
 * 达到baseline的的都是80分，都需要作报告，以检验真实性
 * 再差也会及格： 50~100之间
 *
 */
public class LC_146 {
    /*这里使用hash表+队列，
    * 时间复杂度O(N)
    *
    * 不好*/
//    private int  cap;
//    private Map<Integer,Integer> map = new HashMap<>();
//    private LinkedList<Integer> q = new LinkedList<>();
//    public LC_146(int capacity) {
//        this.cap =capacity;
//    }
//
//    public int get(int key) {
//        int r = q.indexOf(key);
//        while(r!=-1){
//            q.remove(r);
//            r = q.indexOf(key);
//        }
//        //
//        q.add(key);
//        return map.containsKey(key)?map.get(key):-1;
//    }
//
//    public void put(int key, int value) {
//        if(map.size()==cap){
//
//            map.remove( q.pop());
//            map.put(key,value);
//        }
//        else{
//            map.put(key,value);
//
//        }
//        // int r = q.indexOf(key);
//        // while(r!=-1){
//        //     q.remove(r);
//        //     r = q.indexOf(key);
//        // }
//        //  q.add(key);

//    }





}

/*
 * hash+双向链表
 *
 * 使用java自带的 HashMap链表
 * */
class LRU extends LinkedHashMap<Integer,Integer>{
    private int cap;
    LRU(int cap){

        super(cap, 0.75F, true);
        this.cap =cap;
    }
    public int get(int key){
        return super.getOrDefault(key,-1);
    }
    public void put(int key,int value){
        super.put(key,value);
    }

    public static void main(String[] args) {

    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > cap;
    }

}

/*
*单链表+hash表
* */
class Node{
    int k;
    int v;
    Node next;
    Node(int k_,int v_){
        k=k_;
        v=v_;
    }
}
class LRUCache{
    private int cap;
    private Node head,tail;
    public LRUCache(int cap){
        this.cap =cap;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next =tail;
    }

}