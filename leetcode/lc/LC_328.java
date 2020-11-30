package leetcode.lc;

import leetcode.util.ListNode;

import java.util.*;

/**
 * Created by Edwin Xu on 11/14/2020 12:12 AM.
 *
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */

public class LC_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;

        ListNode odd = new ListNode(0);
        ListNode odd_ = odd;

        ListNode even = new ListNode(0);
        ListNode even_ = even;

        ListNode cur = head;
        boolean isOdd = true;
        while(cur!=null){
            if(isOdd){
                odd_.next = cur;
                odd_ = odd_.next;
                isOdd = false;
            }else{
                even_.next = cur;
                even_ = even_.next;
                isOdd = true;
            }
            ListNode pre = cur;
            cur = cur.next;
            pre.next = null; //切断
        }

        odd_ = odd;
        //定位到奇数链末尾
        while(odd_!=null && odd_.next!=null)odd_=odd_.next;
        //连接
        odd_.next = even.next;
        return odd.next;
    }


    /*
    * 官方解法
    * 改进
    * */
    public ListNode oddEvenList_official(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
