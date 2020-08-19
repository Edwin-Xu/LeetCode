package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 8/2/2020 10:10 PM
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LC_24 {
    /*
    * 妈的，这不就是两个一组翻转链表吗
    * */
    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head,2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k<=1)return head;
        ListNode res = null;
        ListNode H = head;
        ListNode T = head;
        ListNode N = head.next;
        ListNode tmp ;
        int num ;//用于判断后面有没有K个节点
        ListNode lastTail = null;
        while (N!=null){
            tmp = H;
            num = 0;
            while (tmp!=null && num<=k){
                num++;
                tmp = tmp.next;
            }
            if (num<k){//后面不足k个节点，结束
                if (lastTail!=null)lastTail.next = H;
                break;
            }else{
                //这4步用于交换两个节点
                num = 0;//统计已经交换的节点
                while (num<k-1){
                    T.next = N.next;
                    N.next = H;
                    H = N;
                    N = T.next;
                    num++;
                }
                if (lastTail==null)lastTail = T;
                else{
                    lastTail.next = H;
                    lastTail = T;
                }
                if (res==null)res = H;//判断是不是第一次翻转k个，是就赋值res为第一次翻转的链表尾，即元链表的第k个
                //切换到下一组
                H = N;
                T = N;
                N = N==null?null: N.next;
            }
        }
        if (res==null)res = head;
        return res;
    }




    /*
    *
    * */
    public ListNode swapPairs_(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public ListNode swapPairs__(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }



}
