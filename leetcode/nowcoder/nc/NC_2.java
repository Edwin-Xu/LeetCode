package leetcode.nowcoder.nc;

import leetcode.util.ListNode;
import leetcode.util.Print;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Edwin Xu on 8/23/2020 10:06 PM
 * 题目描述
 * 将给定的单链表\ L L： L_0→L_1→…→L_{n-1}→L_ nL
 * 0
 * ​
 *  →L
 * 1
 * ​
 *  →…→L
 * n−1
 * ​
 *  →L
 * n
 * ​
 *
 * 重新排序为：L_0→L_n →L_1→L_{n-1}→L_2→L_{n-2}→…L
 * 0
 * ​
 *  →L
 * n
 * ​
 *  →L
 * 1
 * ​
 *  →L
 * n−1
 * ​
 *  →L
 * 2
 * ​
 *  →L
 * n−2
 * ​
 *  →…
 * 要求使用原地算法，不能改变节点内部的值，需要对实际的节点进行交换。
 * 例如：
 * 对于给定的单链表{1,2,3,4}，将其重新排序为{1,4,2,3}.
 */
public class NC_2 {
    public void reorderList(ListNode head) {
        /*
        把链表分为前后两部分：
        然后后面部分反转，插入到前面部分
        */
        int len = 0;
        ListNode h = head;
        while(h!=null){
            len++;
            h = h.next;
        }
        ListNode a = head;
        ListNode b = a;
        for(int i=1;i< (len%2==0?len/2+1 :len/2)-1 ;i++){
            b = b.next;
        }
        //需要截断
        ListNode last = b;
        b = b.next;
        last.next = null;

        ListNode dummy = new ListNode(0);
        while(b!=null){
            ListNode t = dummy.next;
            dummy.next = b;
            b = b.next;
            dummy.next.next = t;
        }
        b = dummy.next;

        ListNode.printList("a",a);
        ListNode.printList("b",b);

        //把b插入到a中
        ListNode cur_b = b;
        ListNode cur_a = a;
        while (cur_b!=null){
            Print.print(cur_a.val,cur_b.val);
            ListNode t = cur_a.next;
            cur_a.next = cur_b;
            cur_a.next.next = t;

            cur_b = cur_b.next;
            cur_a = t;

        }

        ListNode.printList("res",a);

    }


    /*
    * 上面真的有些细节不好处理
    * 使用栈、队列更好处理
    * */
    public void reorderList_sq(ListNode head) {
        Deque<ListNode >deque = new LinkedList<>();
        ListNode cur = head;
        while (cur!=null){
            deque.add(cur);
            cur = cur.next;
        }
        int size = deque.size();
        int lastHalfSize = size/2;  //不管总长度是奇数还是偶数，后面的长度保持一定

        Deque<ListNode >deque2 = new LinkedList<>();
        for (int i = 0; i <lastHalfSize ; i++) {
            deque2.add(deque.pollLast());
        }

        ListNode res = new ListNode(0);
        ListNode ans = res;
        for (int i = 0; i < lastHalfSize; i++) {
            res.next = deque.pollFirst();
            res.next.next = deque2.pollFirst();
            res = res.next.next;
        }
        if (deque.size()>0){
            res.next = deque.pollFirst();
            res.next.next= null;
        }

        ListNode.printList("res",ans.next);


    }


    public void reorderList_others(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return ;
        //快慢指针，找到中间节点
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode start = head;
        ListNode end = mid.next;
        mid.next = null;//断链
        //翻转end链表,处理第一个节点
        ListNode pre = end;
        ListNode cur = pre.next;
        while(cur !=null){
            if(pre == end)
                pre.next = null;
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        end = pre;
        //插入
        while(start != null && end!=null){
            ListNode next1 = start.next;
            ListNode next2 = end.next;
            start.next = end;
            end.next = next1;
            start = next1;
            end = next2;
        }
        return ;

    }
    public static void main(String[] args) {
        NC_2 nc_2 = new NC_2();
        ListNode head =  ListNode.getList("1,2,3,4");

        nc_2.reorderList_sq(head);
    }
}
