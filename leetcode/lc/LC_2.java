package leetcode.lc;

import leetcode.util.ListNode;

import java.util.Stack;

/**
 * Created by Edwin Xu on 8/2/2020 9:15 PM
 * <p>
 * 2. 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LC_2 {
    /*
    *
    * 思路简单：
    *  计算长度，长度末尾补0至一样长
    *  从头开始计算，末尾如果有进位，补上一个节点
    * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //计算长度
        int len1 = 0, len2 = 0;
        ListNode node = l1;
        while (node.next != null) {
            len1++;
            node = node.next;
        }
        ListNode node2 = l2;
        while (node2.next != null) {
            len2++;
            node2 = node2.next;
        }

        //保证l2更长
        if (len2 > len1) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        //补0
        ListNode tail = len2 < len1 ? node2 : node;
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            tail.next = new ListNode(0);
            tail = tail.next;
        }

        //开始加
        ListNode head = l1;
        int carry = 0;
        while (head != null) {
            int sum = head.val + l2.val + carry;
            head.val = sum % 10;
            carry = sum / 10;

            //看最后一个：是否有进位
            if (head.next == null) {
                if (carry == 1) head.next = new ListNode(1);
                break;
            }

            head = head.next;
            l2 = l2.next;
        }
        return l1;
    }


    /*
    * 优化上面的代码：
    *
    * 上面计算长度、补0其实是没必要的
    * 如果一个链表先到达末尾了，那剩下的都当做0处理，直到另一个链表达到末尾
    * */
    public ListNode addTwoNumbers_optimize(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(1);

// 1465+342 = 1807
        LC_2 lc_2 = new LC_2();
        ListNode res = lc_2.addTwoNumbers(head1,head2);
        while (res!=null){
            System.out.print(res.val);
            res =res.next;
        }
    }
}
