package leetcode.nowcoder.nc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 9/18/2020 11:28 PM
 * 题目描述
 * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次
 * 例如：
 * 给出的链表为1\to1\to21→1→2,返回1 \to 21→2.
 * 给出的链表为1\to1\to 2 \to 3 \to 31→1→2→3→3,返回1\to 2 \to 31→2→3.
 */
public class NC_25 {
    public ListNode deleteDuplicates (ListNode head) {
        ListNode cur = head;
        while(head !=null){
            if(head.next!=null && head.val==head.next.val)head.next = head.next.next;
            else  head = head.next;
        }
        return cur;

    }
}
