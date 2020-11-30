package leetcode.lc;

import leetcode.util.ListNode;

/**
 * Created by Edwin Xu on 8/31/2020 3:34 PM
 *
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */
public class LC_19 {

    /*
    * 使用递归，一次遍历
    * 利用的点就是递归的话可以反向
    * */
    private int cur=0;
    public ListNode removeNthFromEnd_recur(ListNode head,int n){
        if (head==null)return null;//到达倒数-1个节点(最后一个节点的子节点)
        ListNode next = removeNthFromEnd_recur(head.next,n);//递归下去
        cur++; //一次递归返回后计数，保证从末尾开始计数
        if (cur==n){
            return head.next;//返回head的子节点，实际就是把head删除
        }
        else{
            head.next = next;
            return head; //不删除head，把head指向递归返回的next即可
        }
    }


    /*
    * 其实可以使用迭代
    * 还记得两个链表的第一个公共节点吗？
    * 一个链表达到末尾后两个链表交换移位到头结点：本质是两个指针走 链表A+链表B，时间一样
    *
    * 这里也类似
    * 链表总长为 L
    * 现在有指针A、B，A先从头结点走N步，然后AB同时走知道A到达末尾，此时B处于倒数第N个
    *
    *
    * 这种奇妙的思维要多训练一些
    * 这是属于双指针的思维。
    * 通过先后、步数长度等实现巧妙的功能
    *
    * */
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode a = dummy, b=dummy;
        for (int i = 0; i <n+ 1; i++) {
            a = a.next;
        }
        while (a!=null){
            a=a.next;
            b =b.next;
        }
        b.next = b.next.next;
        return dummy.next;

    }



    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);

//        ListNode res = new LC_19().removeNthFromEnd(head,1);
//        while (res!=null){
//            System.out.println(res.val);
//            res = res.next;
//        }


        System.out.println(new LC_19().removeNthFromEnd(head,2).val);
        while (head!=null){
            System.out.println(head.val);
            head = head.next;
        }

    }
}
