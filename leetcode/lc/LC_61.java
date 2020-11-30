package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 9/30/2020 4:35 PM
 * <p>
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class LC_61 {
    //就是分为前后两部分，然后前后反转
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;//节点空 返回

        ListNode tmp = head;
        int cnt = 0; //计算长度
        while (tmp != null) {
            tmp = tmp.next;
            cnt++;
        }
        k %= cnt; //移动的个数需要取余

        if (k == 0) return head; //不用调整

        ListNode h = head; //h指向后半部分的尾节点
        for (int i = 0; i < cnt - k - 1; i++) {
            h = h.next;
        }

        ListNode tail = h.next;
        ListNode res = tail;
        h.next = null;

        while (tail != null && tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        return res;

    }
}
