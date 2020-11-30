package leetcode.lc;

import leetcode.util.ListNode;

import java.util.*;

/**
 * Created by Edwin Xu on 10/2/2020 11:27 PM.
 *
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 */

public class LC_82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head; //添加一个头结点

        ListNode pre = dummy;//判断的节点的前节点。1222：判断222时设置pre=1
        ListNode cur = dummy.next;//判断的节点
        while(cur!=null){
            ListNode h = pre.next;//判断的子链表的头结点. 如上是第一个2
            int cnt = 0;//用来统计 子序列中重复的有几个，如上是3个2
            while(cur!=null && cur.val==h.val){
                cur = cur.next;
                cnt++;
            }
            if(cnt>1){//如果超过了两个
                pre.next = cur; //就跳过这两个
            }else{
                pre = pre.next;//否则pre move
            }
        }
        return dummy.next;
    }
}
