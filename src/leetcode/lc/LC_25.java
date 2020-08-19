package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 5/16/2020 11:38 AM
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *
 *
 * 分析：
 * 翻转链表的时候同时计数，数值达到k就重新翻转。
 *
 * 关键点：翻转链表：
 *  借助于2个临时变量：已经翻转了的头H，已经翻转了的尾T，下一个待翻转的头N
 *      1      2  3
 *     H T     N
 *   -------------
 *     2  1   3
 *     H  T   N
 *
 */
public class LC_25 {
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

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);

        head = new LC_25().reverseKGroup(head,4);

        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
