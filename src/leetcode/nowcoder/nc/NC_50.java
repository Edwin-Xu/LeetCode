package leetcode.nowcoder.nc;

import leetcode.util.ListNode;

import java.util.LinkedList;

/**
 * Created by Edwin Xu on 9/8/2020 4:41 PM
 * <p>
 * 题目描述
 * 将给出的链表中的节点每\ k k 个一组翻转，返回翻转后的链表
 * 如果链表中的节点数不是\ k k 的倍数，将最后剩下的节点保持原样
 * 你不能更改节点中的值，只能更改节点本身。
 * 要求空间复杂度 \ O(1) O(1)
 * 例如：
 * 给定的链表是1\to2\to3\to4\to51→2→3→4→5
 * 对于 \ k = 2 k=2, 你应该返回 2\to 1\to 4\to 3\to 52→1→4→3→5
 * 对于 \ k = 3 k=3, 你应该返回 3\to2 \to1 \to 4\to 53→2→1→4→5
 */
public class NC_50 {
    //最笨的办法：使用队列
    //O(NK)
    public ListNode reverseKGroup_edwinxu(ListNode head, int k) {
        LinkedList<ListNode> q = new LinkedList<>();
        ListNode cur = head;

        ListNode dummy = new ListNode(0);
        ListNode h = dummy;

        while (cur != null) {
            int cnt = 0;
            ListNode tmp = cur;//一段的头部
            while (cnt++ < k && cur != null) {
                q.add(cur);
                cur = cur.next;
            }
            if (q.size() == k) {
                while (q.size() > 0) {
                    h.next = q.removeLast();
                    h = h.next;
                }
            } else {
                h.next = tmp;
                break;
            }
        }
        return dummy.next;
    }


    //先计算总长度，然后分组计算
    //O(N)
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = head, temp;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        for (int i = 0; i < len / k; i++) {
            for (int j = 1; j < k; j++) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = pre.next;
                pre.next = temp;
            }
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }




}
