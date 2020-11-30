package leetcode.interview.offer;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 7/28/2020 11:19 AM
 *
 * 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * 如下面的两个链表：
 */


 /*
 思路1：从尾部开始向前找
 思路2：利用栈，从尾部找
 思路3：计算长度，差为X，长的先走X，然后一起走直到相遇
 思路4：双指针: 这个方法不是很稳定？

 */
public class Offer_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode L = headA;
        ListNode R = headB;
        int count=0; //当一个节点达到一个链表的尾部，则从另一个链表继续，同时count++
        while (L != R) {
            L = L.next;
            R = R.next;
            if (L == null) {
                L = headB;//----------------这里地方交换了，太巧妙了
                count ++;
                System.out.println("a++");
            }
            if (R == null) {
                R = headA; //-----------------这里地方交换了，太巧妙了
                count++;
                System.out.println("b++");
            }
            System.out.println("now: L:"+L.val+" R:"+R.val);
            if (count >2) {
                //为什么>两次走到末尾就没有交点
                return null;
            }
        }
        return L;
    }

    public static void main(String[] args) {
        ListNode pub = new ListNode(-1);
        ListNode a = new ListNode(0);
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        ListNode b = new ListNode(10);

        a.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next=a4;
        a4.next=a5;
        a5.next = pub;
        b.next =pub;

        Offer_52 offer_52 = new Offer_52();
        ListNode res = offer_52.getIntersectionNode(a,b);
        System.out.println(res.val);

    }
}
