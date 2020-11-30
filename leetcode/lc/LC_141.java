package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 5/29/2020 10:23 PM
 *
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接
 * 到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class LC_141 {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode f = head;
        ListNode s = head;
        do{
            if (f==null||f.next==null)return false;
            s = s.next;
            f = f.next.next;
        }while (f!=s);
        return true;
    }


    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode f = head;
        ListNode s = head;
        do{
            if (f==null||f.next==null)return null;
            s = s.next;
            f = f.next.next;
        }while (f!=s);
        s = head;
        while (s!=f){
            s = s.next;
            f = f.next;
        }
        return s;
    }



















    /*
    * 判断环的存在性
    *
    * */

    private boolean existsCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        do {
//            if (slow!=null && fast!=null && fast.next!=null){
            /*上面不用判断Slow：fast走得更快，fastOK slow就一定OK*/
            if (fast!=null && fast.next!=null){
                fast= fast.next.next;
                slow = slow.next;
            }else{
                return false;
            }

        }while (fast!=slow);
        return true;
    }









}
