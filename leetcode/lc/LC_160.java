package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 9/12/2020 4:18 PM
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class LC_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headB==null||headA==null)return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a.next;
            b=b.next;
            if(a==null && a!=b)a = headB;
            if(b==null && a!=b)b = headA;
        }
        return a;
    }
}
