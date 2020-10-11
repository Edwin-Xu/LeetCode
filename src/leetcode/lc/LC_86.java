package leetcode.lc;

import leetcode.util.ListNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/11/2020 7:45 PM.
 * <p>
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */

public class LC_86 {
    /*
1. 利用空间：两个队列，一个存>=x的，一个存<x的
其实不需要利用O(N)的空间：
    拆分后合并：
    拆分两个链表，然后合并即可

*/
    public ListNode partition(ListNode head, int x) {
        ListNode listA = new ListNode(0);
        ListNode listB = new ListNode(0);

        ListNode p = head;
        ListNode p_a = listA;
        ListNode p_b = listB;
        while (p != null) {
            if (p.val < x) {
                p_a.next = p;
                p_a = p_a.next;
                p = p.next; //先更新p
                p_a.next = null; //然后断开连接，不然出现环
            } else {
                p_b.next = p;
                p_b = p_b.next;
                p = p.next;
                p_b.next = null;
            }
        }
        p_a = listA;
        while (p_a.next != null) p_a = p_a.next;
        p_a.next = listB.next;
        return listA.next;
    }
}
