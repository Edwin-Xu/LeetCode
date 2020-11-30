package leetcode.lc;

import leetcode.util.ListNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/2/2020 11:04 PM.
 *
 *
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */

public class LC_83 {
    //1MS
    public ListNode deleteDuplicates_edw(ListNode head) {
        ListNode p = head;
        while(p!=null){
            ListNode next = p.next;
            while(next!=null && next.val == p.val){
                p.next = p.next.next;
                next = null; //一定要赋值null，防止内存泄露
                next = p.next;
            }
            p = p.next;
        }
        return head;
    }

    //官方写法：
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}
