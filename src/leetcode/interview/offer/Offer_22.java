package leetcode.interview.offer;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 6/28/2020 6:34 PM
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯
 * ，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链
 * 表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个
 * 链表的倒数第3个节点是值为4的节点。
 *
 *
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 */
public class Offer_22 {
    /*
    * 思路1：递归
    * 这题一看，定位节点是目标，从前往后统计节点数后再次遍历可以实现，不过需要两次遍历
    * 感觉要是从后往前遍历就好了
    * 倒序——递归可以实现
    * */

    private ListNode target;
    public ListNode getKthFromEnd(ListNode head, int k) {
            get(head,k);
            return target;
    }
    private int get(ListNode head, int k) {
        if (head ==null)return 0;
        int num = get(head.next,k)+1;
        if (num==k){
            target = head;
            //不想执行后面的递归了，异常方式跳出
//            throw new  Exception("find it!");
        }
        return num;
    }

    /*
    * 上面这种方式都是弟弟
    *
    * 下面来一种双指针：
    * h，t都指向头部
    * 然后h向后走k步，这时h位于链表中间，距离前面k节点————我们已经找到了正序的第k节点
    * 如果找到逆序K节点？ h继续移动，t也移动。h到达尾部时t不就是逆序第K吗
    *
    * 机智，牛逼。
    *
    * */
    public ListNode getKthFromEnd_genius(ListNode head, int k) {
        ListNode h = head;
        ListNode t = head;
        for (int i = 0; i < k; i++) {
            h = h.next;
        }
        while (h!=null){
            h = h.next;
            t = t.next;
        }
        return t;
    }


    public static void main(String[] args) {

        /*
        *
        * 1-->2-->3
        *
        * */

        ListNode a = new ListNode(0);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next =c;
        System.out.println(new Offer_22().get(a,3));
    }
}
