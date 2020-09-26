package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 9/26/2020 2:19 PM
 * <p>
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LC_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode p = dummy;
        int cnt = 0;
        while (cnt < m - 1 && p != null) {
            p = p.next;
            cnt++;
        }
        //现在P=翻转部分的前一个


        ListNode toReverse = p.next; //待翻转的节点
        p.next = null;
        //先把从P出切断，把后面的一个个加到P后面
        // 本质如下：
        // dummy-head-----p-null,
        // toReverse ---- tail--null
        // 把toReverse一个个添加到p后面

        while (cnt < n) {
            ListNode pNext = p.next; //存储P的尾部。
            p.next = toReverse; // 插入到p的后面
            toReverse = toReverse.next; //指向下一个待翻转的节点
            p.next.next = pNext;//恢复p
            cnt++; //数量+1
        }

        //移动到前半部分链表的尾部
        while (p != null && p.next != null) {
            p = p.next;
        }
        //前后两部分 连接起来
        p.next = toReverse;


        return dummy.next;

        //牛逼，分析好了，一次编写，就过了

    }
}
