package leetcode.nowcoder.nc;

import leetcode.util.Print;

import java.util.*;

/**
 * Created by Edwin Xu on 8/30/2020 1:57 PM
 *
 * 一个缓存结构需要实现如下功能。
 * set(key, value)：将记录(key, value)插入该结构
 * get(key)：返回key对应的value值
 * 但是缓存结构中最多放K条记录，如果新的第K+1条记录要加入，就需要根据策略删掉一条记录，
 * 然后才能把新记录加入。这个策略为：在缓存结构的K条记录中，哪一个key从进入缓存结构的时刻
 * 开始，被调用set或者get的次数最少，就删掉这个key的记录；
 * 如果调用次数最少的key有多个，上次调用发生最早的key被删除
 * 这就是LFU缓存替换算法。实现这个结构，K作为参数给出
 * [要求]
 * set和get方法的时间复杂度为O(1)
 *
 * 若opt=1，接下来两个整数x, y，表示set(x, y)
 * 若opt=2，接下来一个整数x，表示get(x)，若x未出现过或已被移除，则返回-1
 *
 * 对于每个操作2，输出一个答案
 *
 */

/*
* 分析：
*- 需要记录使用次数
*
* */
public class NC_94 {
    /**
     * lfu design
     * @return int整型一维数组
     *
     *
     * 我这个设计很不好
     */
    class Node {
        int val;
        int key;
        Node pre;
        Node next;
        int useCount;//调用次数
        long lastUseTime;
        public Node(int key,int val){
            this.val =val;
            this.key = key;
            useCount =1;//构造的时候是set，使用了第一次
            lastUseTime = System.currentTimeMillis();
        }
        public void set(int val) {
            this.lastUseTime = System.currentTimeMillis();
            this.val = val;
            this.useCount++;
        }
        public void setUseCountPlus(){
            this.useCount++;
        }
    }

    private int size = 10;
    private Node head = new Node(0,0);
    private Node tail = new Node(0,0);
    private Map<Integer,Node> map = new HashMap<>();

    public NC_94() {
        head.next = tail;
        tail.pre = head;
    }

    public int[] LFU (int[][] operators, int k) {
        size = k;
        ArrayList<Integer>resList= new ArrayList<>();
        for (int[] op: operators){
            if (op[0]==1){
                set(op[1],op[2]);
            }else{
                resList.add(get(op[1]));
            }
        }
        int []res = new int[resList.size()];
        for (int i = 0; i <resList.size() ; i++) {
            res[i] = resList.get(i);
        }
        return res;

    }

    public void set(int key,int value){
        if (map.containsKey(key)){
            if (map.size()<size){
                //出现过了，更新值
                Node node = map.get(key);
                node.set(value);
                //这时候使用数+1，需要往前移动
                Node pre = node.pre;
                while (pre!=head){
                    if (pre.useCount<node.useCount ||(pre.useCount==node.useCount && pre.lastUseTime<node.lastUseTime)){
                        //前面的使用数更少，移到后面
                        Node tmp = pre.pre;

                        pre.pre.next = node;
                        pre.next  = node.next;
                        node.next=pre;

                        pre.pre = node;
                        pre.next.pre = pre;

                        node.pre = tmp;
                        pre = node.pre;

                    }
                }

            }else{
                //先删除，再添加
                map.remove(new Integer(tail.pre.key));
                Node tmp = tail.pre.pre;
                tail.pre.pre.next = tail;
                tail.pre = tmp;


                Node newNode = new Node(key,value);
                //这时候使用的次数为1，加到最后面：   链表按使用数、时间从前往后
                tail.pre.next = newNode;
                newNode.next =tail;
                map.put(key,newNode);
                map.put(key,newNode);

            }



        }else{
            //没有出现过
            Node newNode = new Node(key,value);
            //这时候使用的次数为1，加到最后面：   链表按使用数、时间从前往后
            tail.pre.next = newNode;
            newNode.next =tail;
            tail.pre = newNode;
            map.put(key,newNode);

        }
    }

    public int get(int key){
        return map.get(key).val;
    }


    public static void main(String[] args) {
        NC_94 nc_94 = new NC_94();
        int [][] a=
                {
                        {1,1,1},
                        {1,2,2},
                        {1,3,2},
                        {1,2,4},
                        {1,3,5},
                        {2,2},
                        {1,4,4},
                        {2,1}
                };
        Print.printArr( nc_94.LFU(a,3));
    }





}

/*
*
* LFU: Least frequently used
* */

    /*
    *
    *
    * 更好的设计：
    *      通过一个min_num记录当前最少set get操作次数

    核心map 存放   key到对应（key,value,num）的映射    其中num表示其次数

    由于相同的操作数目可能多个（key,value）  故采取拉链法处理map冲突    list链表最后一个表示当前最久的(key,value)
    *
    * */

    /*
    * 所以说总体思路比较简单：
    * 1. 建立节点Node，用于存储数据
    * 2. 建立核心map：用于存放<key,Node>
    * 3. 建立调用次数链map: <callCount, List<Node>>
    * */
class Solution {

    public class LFUCache {

        private class Node {
            int k;
            int v;
            int count; //调用次数

            public Node(int k, int v) {
                this.k = k;
                this.v = v;
                count = 1;
            }
        }

        private int size;
        private int maxSize;
        private Map<Integer, Node> key2node;
        private Map<Integer, LinkedList<Node>> count2list; //<调用次数，对于调用次数的链表>

        public LFUCache(int maxSize) {
            this.maxSize = maxSize;
            size = 0;
            key2node = new HashMap<>();
            count2list = new HashMap<>();
        }

        public void set(int k, int v) {
            if (key2node.containsKey(k)) { //存在
                key2node.get(k).v = v;
                get(k); //get 一次用于改变调用次数
                return;
            }
            //不存在：建一个新节点
            Node node = new Node(k, v);
            //如果调用次数map中不存在，就添加一个新链表
            if (!count2list.containsKey(node.count)) count2list.put(node.count, new LinkedList<>());
            LinkedList<Node> list = count2list.get(node.count);
            list.addFirst(node);//插入到该链表的头部，表示该调用次数中，是最近调用的，链表尾才是最久没有调动的
            key2node.put(k, node);//同时加入核心map
            size++;
            if (size > maxSize) {//超过容量了，删除一个
                key2node.remove(list.getLast().k);
                list.removeLast();
                size--;
            }
        }

        public int get(int k) {
            if (!key2node.containsKey(k)) return -1;
            Node node = key2node.get(k);//获取之后
            //还需要更新调用次数：
            LinkedList<Node> oldList = count2list.get(node.count);
            oldList.remove(node);//原来的链表中删除
            if (oldList.isEmpty()) count2list.remove(node.count);
            node.count++;
            //建立并加入新链表
            if (!count2list.containsKey(node.count)) count2list.put(node.count, new LinkedList<>());
            LinkedList<Node> list = count2list.get(node.count);
            list.addFirst(node);
            return node.v;
        }
    }

    public int[] LFU(int[][] operators, int k) {
        LFUCache cache = new LFUCache(k);
        List<Integer> list = new ArrayList<>();
        for (int[] e : operators) {
            if (e[0] == 1) cache.set(e[1], e[2]);
            else list.add(cache.get(e[1]));
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) res[i] = list.get(i);
        return res;
    }

}
